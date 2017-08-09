package com.ych.core.pay;

import java.util.Map;

/**
 * 支付渠道操作结果
 *
 * @author U
 */
public interface ChannelOperationResult {

    /**
     * @return 获取流水号
     */
    String getFlowNo();

    /**
     * @return 获取渠道的流水号
     */
    String getChannelFlowNo();

    /**
     * @return 某些渠道创建订单时返回的是预支付单号
     */
    String getPrepayChannelFlowNo();

    /**
     * @return 渠道返回的的错误码
     */
    String getErrorCode();

    /**
     * @return 错误消息
     */
    String getErrorMsg();

    /**
     * 如果返回非null则表示操作需要进行页面跳转,返回的结果为视图名称
     *
     * @return 视图名称
     */
    String getViewName();

    /**
     * 要跳转视图的情况下视图的属性列表
     *
     * @return 视图的属性列表
     */
    Map<String, Object> getViewAtrributes();

    /**
     * 跟支付渠道有关系得特定参数
     *
     * @return 渠道有关系得特定参数
     */
    Map<String, Object> getExtendedParameters();

}
