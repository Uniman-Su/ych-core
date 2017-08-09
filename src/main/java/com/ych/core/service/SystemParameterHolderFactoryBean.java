package com.ych.core.service;

import org.springframework.beans.factory.FactoryBean;

import com.ych.core.model.SystemParameterHolder;

/**
 * 系统参数持有者构造工厂
 *
 * Created by U on 2017/7/17.
 */
public class SystemParameterHolderFactoryBean implements FactoryBean<SystemParameterHolder> {

    /**
     * 系统参数服务
     */
    private SystemParameterService systemParameterSvc;

    /**
     * 应用的Key
     */
    private String appKey;

    /**
     * 保留参数的key
     */
    private String key;

    private SystemParameterHolder systemParameterHolder;

    /**
     * @param systemParameterSvc
     *         系统参数服务
     */
    public void setSystemParameterSvc(SystemParameterService systemParameterSvc) {
        this.systemParameterSvc = systemParameterSvc;
    }

    /**
     * @param appKey
     *         应用的Key
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    /**
     * @param key
     *         保留参数的key
     */
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public SystemParameterHolder getObject() throws Exception {
        if (systemParameterHolder == null) {
            systemParameterHolder = new SystemParameterHolder(systemParameterSvc, appKey, key);
        }

        return systemParameterHolder;
    }

    @Override
    public Class<?> getObjectType() {
        return SystemParameterHolder.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
