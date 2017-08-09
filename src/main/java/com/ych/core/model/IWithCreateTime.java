package com.ych.core.model;

import java.util.Date;

/**
 * 带创建时间的对象
 * <p>
 * Created by U on 2017/7/5.
 */
public interface IWithCreateTime {

    /**
     * @return 创建时间
     */
    Date getCreateTime();

    /**
     * @param time
     *         创建时间
     */
    void setCreateTime(Date time);

}
