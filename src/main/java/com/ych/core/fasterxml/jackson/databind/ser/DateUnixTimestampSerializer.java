package com.ych.core.fasterxml.jackson.databind.ser;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * 将日期格式化为Unix时间戳
 * <p>
 * Created by U on 2017/6/30.
 */
public class DateUnixTimestampSerializer extends StdSerializer<Date> {

    /**
     * 构造方法
     */
    public DateUnixTimestampSerializer() {
        super(Date.class);
    }

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumber(value.getTime() / 1000);
    }
}
