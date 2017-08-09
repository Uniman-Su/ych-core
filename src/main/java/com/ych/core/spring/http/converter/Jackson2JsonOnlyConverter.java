package com.ych.core.spring.http.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 不管任何数据类型都认为是JSON的转换器
 */
public class Jackson2JsonOnlyConverter extends AbstractJackson2HttpMessageConverter {

    public static final Jackson2JsonOnlyConverter DEFAULT = new Jackson2JsonOnlyConverter();

    public Jackson2JsonOnlyConverter() {
        this(Jackson2ObjectMapperBuilder.json().build());
    }

    public Jackson2JsonOnlyConverter(ObjectMapper objectMapper) {
        super(objectMapper, MediaType.ALL);
    }
}
