package com.ych.core.spring.web.client;

import java.io.IOException;

import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.RequestCallback;

/**
 * RequestCallback接口的适配器
 */
public class RequestCallbackAdapter implements RequestCallback {

    /**
     * 默认适配器
     */
    public static RequestCallbackAdapter DEFAULT = new RequestCallbackAdapter();

    @Override
    public void doWithRequest(ClientHttpRequest request) throws IOException {

    }
}
