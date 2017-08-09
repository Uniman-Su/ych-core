package com.ych.core.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ych.core.service.SystemParameterService;

/**
 * 系统参数持有者,注入对象不需要关注参数的系统参数的Key
 * <p>
 * Created by U on 2017/6/30.
 */
public class SystemParameterHolder {

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

    /**
     * 默认构造方法
     */
    public SystemParameterHolder() {

    }

    /**
     * 构造方法
     *
     * @param systemParameterSvc
     *         系统参数服务
     * @param appKey
     *         应用的Key
     * @param key
     *         保留参数的key
     */
    public SystemParameterHolder(SystemParameterService systemParameterSvc, String appKey, String key) {
        systemParameterSvc = systemParameterSvc;
        appKey = appKey;
        key = key;
    }

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

    /**
     * @return 存储在数据库中的字符值
     */
    public String getStringValue() {
        return systemParameterSvc.getStringValue(appKey, key);
    }

    /**
     * @return 存储在数据库中的整型值
     */
    public Integer getIneterValue() {
        return systemParameterSvc.getIneterValue(appKey, key);
    }

    /**
     * @return 存储在数据库中的长整型值
     */
    public Long getLongValue() {
        return systemParameterSvc.getLongValue(appKey, key);
    }

    /**
     * @return 存储在数据库中的Decimal值
     */
    public BigDecimal getDecimalValue() {
        return systemParameterSvc.getDecimalValue(appKey, key);
    }

    /**
     * @return 存储在数据库中的Boolean值
     */
    public Boolean getBooleanValue() {
        return systemParameterSvc.getBooleanValue(appKey, key);
    }

    /**
     * @return 存储在数据库中的时间
     */
    public Date getDateValue() {
        return systemParameterSvc.getDateValue(appKey, key);
    }

    /**
     * @return 存储在数据库中的字符串列表
     */
    public List<String> getStringListValue() {
        return systemParameterSvc.getStringListValue(appKey, key);
    }

    /**
     * @return 存储在数据库中的Decimal列表
     */
    public List<BigDecimal> getBigDecimalListValue() {
        return systemParameterSvc.getBigDecimalListValue(appKey, key);
    }
}
