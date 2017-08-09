package com.ych.core.fasterxml.jackson.databind.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * 数字类型转换为字符串的序列化器
 * 
 * @author U
 *
 */
public class ObjectStringSerializer extends StdSerializer<Object> {

	private static final long serialVersionUID = -4707186691836839335L;

	/**
	 * 构造方法
	 */
	public ObjectStringSerializer() {
		super(Object.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fasterxml.jackson.databind.ser.std.StdSerializer#serialize(java.lang.
	 * Object, com.fasterxml.jackson.core.JsonGenerator,
	 * com.fasterxml.jackson.databind.SerializerProvider)
	 */
	@Override
	public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(String.valueOf(value));
	}

}
