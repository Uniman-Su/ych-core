package com.ych.core.fasterxml.jackson.databind.deser;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * 将Unix时间戳转换为Date对象
 * <p>
 * Created by U on 2017/6/30.
 */
public class DateUnixTimestampDeserializer extends StdDeserializer<Date> {

    /**
     * 构造方法
     */
    public DateUnixTimestampDeserializer() {
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        switch (p.getCurrentTokenId()) {
            case JsonTokenId.ID_NUMBER_INT:
                return new Date(p.getLongValue() * 1000);

            case JsonTokenId.ID_NUMBER_FLOAT:
                if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                    _failDoubleToIntCoercion(p, ctxt, "Long");
                }

                return new Date(p.getLongValue() * 1000);

            case JsonTokenId.ID_STRING:
                // let's allow Strings to be converted too
                // !!! 05-Jan-2009, tatu: Should we try to limit value space, JDK is too lenient?
                String text = p.getText().trim();

                if (StringUtils.isBlank(text)) {
                    return null;
                }

                try {
                    return new Date(Long.valueOf(text) * 1000);
                } catch (NumberFormatException iae) {
                }
                return (Date) ctxt.handleWeirdStringValue(_valueClass, text,
                        "not a valid Unix timestamp value");

            case JsonTokenId.ID_NULL:
                return null;

            default:
                return (Date) ctxt.handleUnexpectedToken(_valueClass, p);
        }
    }
}
