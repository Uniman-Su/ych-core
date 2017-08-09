package com.ych.core.wechat.model.message.push;

import java.io.Serializable;
/**
 * 消息item
 * @author sunny
 *
 */
public class MessageItem implements Serializable {

    private static final long serialVersionUID = -5926022727656617703L;

    private String value;
    
    private String color;
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
