package com.ych.core.spring.web.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.HttpMessageConverterExtractor;

import com.ych.core.spring.http.converter.Jackson2JsonOnlyConverter;

/**
 * 只讲报文当成JSON处理的提取器
 *
 * @param <T>
 */
public class Jackson2JsonOnlyResponseExtractor<T> extends HttpMessageConverterExtractor<T> {

    private static final List<HttpMessageConverter<?>> converters;

    private static final WeakHashMap<Class<?>, Jackson2JsonOnlyResponseExtractor<?>> maps = new WeakHashMap<>();

    static {
        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(Jackson2JsonOnlyConverter.DEFAULT);
        converters = Collections.unmodifiableList(list);
    }

    public Jackson2JsonOnlyResponseExtractor(Class<T> responseType) {
        super(responseType, converters);
    }

    /**
     * 获取实例
     *
     * @param responseType
     *         响应类型
     * @return 实例
     */
    public static <T> Jackson2JsonOnlyResponseExtractor<T> getInstance(Class<T> responseType) {
        Jackson2JsonOnlyResponseExtractor extractor = maps.get(responseType);
        if (extractor == null) {
            extractor = new Jackson2JsonOnlyResponseExtractor(responseType);
            maps.put(responseType, extractor);
        }
        return extractor;
    }

}
