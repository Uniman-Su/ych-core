package com.ych.core.spring.web.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.HttpMessageConverterExtractor;

import com.ych.core.spring.http.converter.Jackson2JsonOnlyConverter;
import com.ych.core.spring.http.converter.Jackson2XmlOnlyConverter;

/**
 * 只讲报文当成XML处理的提取器
 *
 * @param <T>
 */
public class Jackson2XmlOnlyResponseExtractor<T> extends HttpMessageConverterExtractor<T> {

    private static final List<HttpMessageConverter<?>> converters;

    private static final WeakHashMap<Class<?>, Jackson2XmlOnlyResponseExtractor<?>> maps = new WeakHashMap<>();

    static {
        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(Jackson2XmlOnlyConverter.DEFAULT);
        converters = Collections.unmodifiableList(list);
    }

    public Jackson2XmlOnlyResponseExtractor(Class<T> responseType) {
        super(responseType, converters);
    }

    /**
     * 获取实例
     *
     * @param responseType
     *         响应类型
     * @return 实例
     */
    public static <T> Jackson2XmlOnlyResponseExtractor<T> getInstance(Class<T> responseType) {
        Jackson2XmlOnlyResponseExtractor extractor = maps.get(responseType);
        if (extractor == null) {
            extractor = new Jackson2XmlOnlyResponseExtractor(responseType);
            maps.put(responseType, extractor);
        }
        return extractor;
    }

}
