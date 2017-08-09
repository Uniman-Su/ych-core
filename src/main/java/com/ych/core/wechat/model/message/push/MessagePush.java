package com.ych.core.wechat.model.message.push;
/**
 * 微信公众号模板消息推送接口
 * @author sunny
 *
 */
public interface MessagePush {

    static final String REQUEST_ADDRESS = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token={token}";
    /**
     * 推送模板消息
     * @param req
     * @return
     */
    MessagePushResp push(MessagePushReq req);
}
