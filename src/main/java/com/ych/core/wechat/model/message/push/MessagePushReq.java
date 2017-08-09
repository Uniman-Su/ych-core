package com.ych.core.wechat.model.message.push;

import java.io.Serializable;
import java.util.Map;

public class MessagePushReq implements Serializable {

    private static final long serialVersionUID = 57531569248591460L;
    /** 推送目标openid */
    private String touser;
    /** 消息模板ID */
    private String template_id;
    /** 跳转地址 */
    private String url;
    /** 消息框顶部颜色 */
    private String topcolor;
    /** 消息数据项 */
    private Map<String, MessageItem> data;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public Map<String, MessageItem> getData() {
        return data;
    }

    public void setData(Map<String, MessageItem> data) {
        this.data = data;
    }

}
