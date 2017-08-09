package com.ych.core.fasterxml.jackson.databind.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ych.core.model.IntValueHolder;

/**
 * 数字型Boolean值的序列化器
 * <p>
 * Created by U on 2017/7/13.
 */
public class IntBooleanSerializer extends StdSerializer<Boolean> {

    protected IntBooleanSerializer() {
        super(Boolean.class);
    }

    @Override
    public void serialize(Boolean value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumber(value.booleanValue() ? 1 : 0);
    }
}
