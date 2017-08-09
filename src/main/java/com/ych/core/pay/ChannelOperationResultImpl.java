package com.ych.core.pay;

import java.util.Map;

/**
 * 支付渠道操作结果
 *
 * @author U
 */
public class ChannelOperationResultImpl implements ChannelOperationResult {

    /**
     * 流水号
     */
    private String flowNo;

    /**
     * 支付渠道流水号
     */
    private String channelFlowNo;

    /**
     * 某些渠道创建订单时返回的是预支付单号
     */
    private String prepayChannelFlowNo;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 视图名称
     */
    private String viewName;

    /**
     * 视图属性
     */
    private Map<String, Object> viewAtrributes;

    /**
     * 渠道扩展属性
     */
    private Map<String, Object> extendedParameters;

    /*
     * (non-Javadoc)
     * 
     * @see com.ych.core.pay.ChannelOperationResult#getFlowNo()
     */
    @Override
    public String getFlowNo() {
        return flowNo;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ych.core.pay.ChannelOperationResult#getChannelFlowNo()
     */
    @Override
    public String getChannelFlowNo() {
        return channelFlowNo;
    }

    @Override
    public String getPrepayChannelFlowNo() {
        return prepayChannelFlowNo;
    }

    public void setPrepayChannelFlowNo(String prepayChannelFlowNo) {
        this.prepayChannelFlowNo = prepayChannelFlowNo;
    }

    /*
         * (non-Javadoc)
         *
         * @see com.ych.core.pay.ChannelOperationResult#getErrorCode()
         */
    @Override
    public String getErrorCode() {
        return errorCode;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ych.core.pay.ChannelOperationResult#getViewName()
     */
    @Override
    public String getViewName() {
        return viewName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ych.core.pay.ChannelOperationResult#getViewAtrributes()
     */
    @Override
    public Map<String, Object> getViewAtrributes() {
        return viewAtrributes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ych.core.pay.ChannelOperationResult#getExtendedParameters()
     */
    @Override
    public Map<String, Object> getExtendedParameters() {
        return extendedParameters;
    }

    /**
     * @return 流水号
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @param errorMsg
     *         错误消息
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * @param flowNo
     *         流水号
     */
    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }

    /**
     * @param channelFlowNo
     *         支付渠道流水号
     */
    public void setChannelFlowNo(String channelFlowNo) {
        this.channelFlowNo = channelFlowNo;
    }

    /**
     * @param errorCode
     *         错误码
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @param viewName
     *         视图名称
     */
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    /**
     * @param viewAtrributes
     *         视图属性
     */
    public void setViewAtrributes(Map<String, Object> viewAtrributes) {
        this.viewAtrributes = viewAtrributes;
    }

    /**
     * @param extendedParameters
     *         渠道扩展属性
     */
    public void setExtendedParameters(Map<String, Object> extendedParameters) {
        this.extendedParameters = extendedParameters;
    }

}
