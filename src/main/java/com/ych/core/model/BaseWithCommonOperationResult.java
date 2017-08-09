package com.ych.core.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 基础带操作结果的数据
 *
 * @author U
 */
public class BaseWithCommonOperationResult implements IWithCommonOperationResult {

    /**
     * 操作结果
     */
    private CommonOperationResult result;

    /**
     * 结果描述
     */
    private String description;

    /**
     * 构造方法
     */
    public BaseWithCommonOperationResult() {
    }

    /**
     * 构造方法
     *
     * @param result
     *         操作结果
     */
    public BaseWithCommonOperationResult(CommonOperationResult result) {
        this.result = result;
    }

    /**
     * 构造方法
     *
     * @param result
     *         操作结果
     * @param description
     *         结果描述
     */
    public BaseWithCommonOperationResult(CommonOperationResult result, String description) {
        this.result = result;
        this.description = description;
    }

    /*
         * (non-Javadoc)
         *
         * @see com.ych.core.model.IWithCommonOperationResult#getResult()
         */
    @Override
    public CommonOperationResult getResult() {
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.ych.core.model.IWithCommonOperationResult#setResult(com.ych.core.
     * model.CommonOperationResult)
     */
    @Override
    public void setResult(CommonOperationResult result) {
        this.result = result;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
