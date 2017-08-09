package com.ych.core.pay;

import java.util.Map;

import com.ych.core.model.CommonOperationResultWidthData;

/**
 * 支付策略
 *
 * @author U
 */
public interface PaymentStrategy {

    /**
     * @return 支持的支付渠道的名称
     */
    String[] getSupportChannelNames();

    /**
     * 创建支付单据
     *
     * @param parameter
     *         参数
     * @param extendedParamters
     *         支付渠道的扩展参数
     * @return 操作结果
     */
    CommonOperationResultWidthData<ChannelOperationResult> createPayOrder(CreatePayOrderParameter parameter, Map<String, Object> extendedParamters);

    /**
     * 取消支付单据
     *
     * @param channelName
     *         渠道名称
     * @param orderNo
     *         订单号
     * @param channelOrderNo
     *         渠道单据号
     * @param extendedParamters
     *         支付渠道的扩展参数
     * @return 操作结果
     */
    CommonOperationResultWidthData<ChannelOperationResult> cancelPayOrder(String channelName, String orderNo, String channelOrderNo,
                                                                          Map<String, Object> extendedParamters);

    /**
     * 退款
     *
     * @param channelName
     *         渠道名称
     * @param orderNo
     *         订单号
     * @param refundNo
     *         退款单号
     * @param channelOrderNo
     *         渠道单据号
     * @param channelRefundNo
     *         渠道退款流水号,部分渠道需要此参数
     * @param extendedParamters
     *         支付渠道的扩展参数
     * @return 操作结果
     */
    CommonOperationResultWidthData<ChannelOperationResult> refund(String channelName, String orderNo, String refundNo, String channelOrderNo, String channelRefundNo,
                                                                  Map<String, Object> extendedParamters);

    /**
     * 退款是否需要生成单独的订单号
     *
     * @param channelName
     *         渠道名称
     * @return 退款是否需要独立的单号
     */
    boolean isGenerateRefundNo(String channelName);

}
