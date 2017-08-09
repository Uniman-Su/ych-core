package com.ych.core.wechat.model.message.push;

import com.ych.core.wechat.model.BaseResponseEntity;

public class MessagePushResp extends BaseResponseEntity {

    private static final long serialVersionUID = 2993648232324651124L;

    /**消息ID*/
    private String msgid;

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }
    
    
    
}
