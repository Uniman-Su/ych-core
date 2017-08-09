package com.ych.core.event.crossapp;

import com.ych.core.event.IEvent;

/**
 * 跨应用的事件广播器
 * <p>
 * Created by U on 2017/3/6.
 */
public interface ICrossAppEventBroadcaster {

    /**
     * 广播时间
     *
     * @param name
     *         事件名称
     * @param sourceEvent
     *         源事件
     * @param event
     *         发送的源事件
     */
    void broadcastEvent(String name, IEvent sourceEvent, ICrossAppEvent event);

}
