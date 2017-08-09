package com.ych.core.pay;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.ych.core.model.CommonOperationResultWidthData;

/**
 * 支付策略的中介者
 */
public class PaymentStrategyMediator implements PaymentStrategy {

    /**
     * 使用的支付策略列表
     */
    private List<PaymentStrategy> paymentStrategies;

    /**
     * 支持的支付渠道名称
     */
    private String[] supportChannelNames;

    /**
     * @param paymentStrategies
     *         使用的支付策略列表
     */
    public void setPaymentStrategies(List<PaymentStrategy> paymentStrategies) {
        this.paymentStrategies = paymentStrategies;
    }

    @PostConstruct
    public void init() {
        HashSet<String> channels = new HashSet<>();

        for (PaymentStrategy paymentStrategy : paymentStrategies) {
            for (String channelName : paymentStrategy.getSupportChannelNames()) {
                channels.add(channelName);
            }
        }

        supportChannelNames = channels.toArray(new String[channels.size()]);
    }

    @Override
    public String[] getSupportChannelNames() {
        String[] ret = new String[supportChannelNames.length];
        System.arraycopy(supportChannelNames, 0, ret, 0, supportChannelNames.length);
        return ret;
    }

    /**
     * 通过支付渠道名称获取支付策略
     *
     * @param channelName
     *         渠道名称
     * @return 策略
     */
    private PaymentStrategy getPaymentStrategyByChannelName(String channelName) {
        for (PaymentStrategy paymentStrategy : paymentStrategies) {
            for (String name : paymentStrategy.getSupportChannelNames()) {
                if (channelName.equals(name)) {
                    return paymentStrategy;
                }
            }
        }

        return null;
    }

    @Override
    public CommonOperationResultWidthData<ChannelOperationResult> createPayOrder(CreatePayOrderParameter parameter, Map<String, Object> extendedParamters) {
        return getPaymentStrategyByChannelName(parameter.getChannelName()).createPayOrder(parameter, extendedParamters);
    }

    @Override
    public CommonOperationResultWidthData<ChannelOperationResult> cancelPayOrder(String channelName, String orderNo, String channelOrderNo, Map<String, Object> extendedParamters) {
        return getPaymentStrategyByChannelName(channelName).cancelPayOrder(channelName, orderNo, channelOrderNo, extendedParamters);
    }

    @Override
    public CommonOperationResultWidthData<ChannelOperationResult> refund(String channelName, String orderNo, String refundNo, String channelOrderNo, String channelRefundNo, Map<String, Object> extendedParamters) {
        return getPaymentStrategyByChannelName(channelName).refund(channelName, orderNo, refundNo, channelOrderNo, channelRefundNo, extendedParamters);
    }

    @Override
    public boolean isGenerateRefundNo(String channelName) {
        return getPaymentStrategyByChannelName(channelName).isGenerateRefundNo(channelName);
    }
}
