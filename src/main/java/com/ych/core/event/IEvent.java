package com.ych.core.event;

/**
 * 事件定义
 *
 * Created by U on 2017/3/6.
 */
public interface IEvent {

    /**
     * @return 是否为未经过转发的原始事件
     */
    boolean isOriginal();

}
