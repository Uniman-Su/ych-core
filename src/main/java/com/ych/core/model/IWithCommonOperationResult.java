package com.ych.core.model;

/**
 * 带操作结果的数据
 *
 * @author U
 */
public interface IWithCommonOperationResult {

    /**
     * @return 操作结果
     */
    CommonOperationResult getResult();

    /**
     * @param result
     *         操作结果
     */
    void setResult(CommonOperationResult result);

    /**
     * @return 结果描述
     */
    String getDescription();

    /**
     * @param description
     *         结果描述
     */
    void setDescription(String description);

}
