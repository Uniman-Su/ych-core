package com.ych.core.fasterxml.jackson.databind.deser;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * 数字型Boolean值的反序列化器
 * <p>
 * Created by U on 2017/7/13.
 */
public class YNStrBooleanDeserializer extends StdDeserializer<Boolean> {

    /**
     * 构造方法
     */
    public YNStrBooleanDeserializer() {
        super(Boolean.class);
    }

    private boolean getBooleanValue(String value) {
        return "Y".equals(value);
    }

    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        switch (p.getCurrentTokenId()) {
            case JsonTokenId.ID_STRING:
                // let's allow Strings to be converted too
                // !!! 05-Jan-2009, tatu: Should we try to limit value space, JDK is too lenient?
                String text = p.getText().trim();

                if (StringUtils.isBlank(text)) {
                    return null;
                }

                try {
                    return getBooleanValue(text);
                } catch (NumberFormatException iae) {
                }
                return (Boolean) ctxt.handleWeirdStringValue(_valueClass, text,
                        "not a valid Unix timestamp value");

            case JsonTokenId.ID_NULL:
                return null;

            default:
                return (Boolean) ctxt.handleUnexpectedToken(_valueClass, p);
        }
    }
}
