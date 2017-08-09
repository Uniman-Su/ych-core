package com.ych.core.wechat.model.message.push;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ych.core.wechat.model.ParameterProvider;
import com.ych.core.wechat.model.comm.token.AccessToken;
import com.ych.core.wechat.model.comm.token.CommonAccessToken;


public class MessagePushSupport implements MessagePush {

    private RestTemplate restTemplate;
    
    private CommonAccessToken commonAccessToken;
    
    private ParameterProvider parameterProvider;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setCommonAccessToken(CommonAccessToken commonAccessToken) {
        this.commonAccessToken = commonAccessToken;
    }

    public void setParameterProvider(ParameterProvider parameterProvider) {
        this.parameterProvider = parameterProvider;
    }

    @Override
    public MessagePushResp push(MessagePushReq req) {
        String appId = parameterProvider.getAppID();
        String secret = parameterProvider.getAppSecret();
        AccessToken token = commonAccessToken.getAccessToken(appId, secret);
        ResponseEntity<MessagePushResp> resp =  restTemplate.postForEntity(REQUEST_ADDRESS, req, MessagePushResp.class,token.getAccess_token());
         return resp.getBody();
    }

}
