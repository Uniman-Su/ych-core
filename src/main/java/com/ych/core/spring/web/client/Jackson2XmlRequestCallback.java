package com.ych.core.spring.web.client;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.RequestCallback;

import com.ych.core.fasterxml.jackson.MapperUtils;

/**
 * 生成XML请求的RequestBack
 */
public class Jackson2XmlRequestCallback implements RequestCallback {

    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private Object requestObject;

    private Charset charset;

    /**
     * 构造方法
     *
     * @param requestObject
     *         要发送的请求对象
     */
    public Jackson2XmlRequestCallback(Object requestObject) {
        this(requestObject, DEFAULT_CHARSET);
    }

    /**
     * 构造方法
     *
     * @param requestObject
     *         要发送的请求对象
     * @param charset
     *         字符集
     */
    public Jackson2XmlRequestCallback(Object requestObject, Charset charset) {
        this.requestObject = requestObject;
        this.charset = charset;
    }

    @Override
    public void doWithRequest(ClientHttpRequest request) throws IOException {
        request.getHeaders().setContentType(MediaType.APPLICATION_XML);
        Writer writer = new OutputStreamWriter(request.getBody(), charset);
        writer.write(MapperUtils.XML_MAPPER.get().writeValueAsString(requestObject));
        writer.flush();
    }
}
