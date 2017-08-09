package com.ych.core.spring.http.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 不管任何数据类型都认为是XML的转换器
 */
public class Jackson2XmlOnlyConverter extends AbstractJackson2HttpMessageConverter {

    public static final Jackson2XmlOnlyConverter DEFAULT = new Jackson2XmlOnlyConverter();

    public Jackson2XmlOnlyConverter() {
        this(Jackson2ObjectMapperBuilder.xml().build());
    }

    public Jackson2XmlOnlyConverter(ObjectMapper objectMapper) {
        super(objectMapper, MediaType.ALL);
    }

}
