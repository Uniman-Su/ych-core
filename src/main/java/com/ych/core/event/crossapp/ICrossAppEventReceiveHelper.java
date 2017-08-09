package com.ych.core.event.crossapp;

/**
 * 跨应用时间接收首助手
 * <p>
 * Created by U on 2017/3/6.
 */
public interface ICrossAppEventReceiveHelper {

    /**
     * 接受跨应用事件并在本应用内广播
     *
     * @param event
     *         跨应用事件
     */
    void receiveEvent(ICrossAppEvent event);

}
