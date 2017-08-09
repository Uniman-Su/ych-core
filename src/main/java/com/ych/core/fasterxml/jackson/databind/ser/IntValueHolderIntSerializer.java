package com.ych.core.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ych.core.model.IntValueHolder;

import java.io.IOException;

/**
 * Created by mxp on 2016/5/17.
 */
@SuppressWarnings("rawtypes")
public class IntValueHolderIntSerializer extends StdSerializer<IntValueHolder> {


    private static final long serialVersionUID = -1981999206057956772L;

    protected IntValueHolderIntSerializer() {
        super(IntValueHolder.class);
    }

    @Override
    public void serialize(IntValueHolder value, JsonGenerator gen, SerializerProvider provider) throws IOException {
       gen.writeNumber(value.getValue());
    }
}
