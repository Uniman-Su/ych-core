package com.ych.core.event.crossapp;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;

import com.ych.core.event.IEntityCreatedEvent;
import com.ych.core.event.IEntityModifiedEvent;
import com.ych.core.event.IEntityRemovedEvent;
import com.ych.core.event.IEvent;
import com.ych.core.jms.SerializableMessageCreator;
import com.ych.core.model.SystemParameterKey;
import com.ych.core.service.SystemParameterService;

/**
 * JMS实现的跨应用事件广播器
 * <p>
 * Created by U on 2017/3/6.
 */
public class JmsCrossAppEventBroadcaster implements ICrossAppEventBroadcaster, ICrossAppEventReceiveHelper, ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(JmsCrossAppEventBroadcaster.class);

    /**
     * 系统参数服务
     */
    private SystemParameterService systemParameterService;

    /**
     * JMS模板
     */
    private JmsTemplate jmsTemplate;

    /**
     * 应用上下文
     */
    private ApplicationContext applicationContext;

    /**
     * @param systemParameterService
     *         系统参数服务
     */
    public void setSystemParameterService(SystemParameterService systemParameterService) {
        this.systemParameterService = systemParameterService;
    }

    /**
     * @param jmsTemplate
     *         JMS模板
     */
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 执行发送事件的操作
     *
     * @param name
     *         事件名称
     * @param event
     *         事件对象
     */
    protected void doBroadcast(String name, ICrossAppEvent event) {
        List<String> queues = systemParameterService.getStringListValue(SystemParameterKey.EVENT_QUEUE_PREFIX + name);
        if (CollectionUtils.isNotEmpty(queues)) {
            MessageCreator msgCreator = new SerializableMessageCreator(event);
            for (String queue : queues) {
                jmsTemplate.send(queue, msgCreator);
            }
        }
    }

    @Override
    public void broadcastEvent(final String name, final IEvent sourceEvent, final ICrossAppEvent event) {
        Assert.notNull(name, "name can not be null");
        Assert.notNull(event, "event can not be null");

        if (sourceEvent.isOriginal()) {
            if (TransactionSynchronizationManager.isSynchronizationActive()) {
                TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                    @Override
                    public void afterCommit() {
                        doBroadcast(name, event);
                    }
                });
            } else {
                doBroadcast(name, event);
            }
        }
    }

    /**
     * 接受跨应用事件并在本应用内广播
     *
     * @param event
     *         跨应用事件
     */
    @Override
    public void receiveEvent(ICrossAppEvent event) {
        if (!StringUtils.equals(event.getSourceAppKey(), systemParameterService.getAppKey())) {
            IEvent wrappedEvent = event.getWrappedEvent();

            if (wrappedEvent instanceof IEntityCreatedEvent<?>) {
                logger.info("Entity created event recevied:{}", ((IEntityCreatedEvent<?>) wrappedEvent).getEntity());
            } else if (wrappedEvent instanceof IEntityModifiedEvent<?>) {
                logger.info("Entity modified event recevied:");
                logger.info("Old entity:{}", ((IEntityModifiedEvent<?>) wrappedEvent).getOldEntity());
                logger.info("New entity:{}", ((IEntityModifiedEvent<?>) wrappedEvent).getNewEntity());
            } else {
                logger.info("Entity removed event recevied:{}", ((IEntityRemovedEvent<?>) wrappedEvent).getEntity());
            }

            applicationContext.publishEvent(wrappedEvent);
        }
    }
}
