package com.ych.core.fasterxml.jackson.databind.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ych.core.fasterxml.jackson.MapperUtils;

/**
 * 数字类型转换为JSON字符串的序列化器
 * 
 * @author U
 *
 */
public class ObjectJSONSerializer extends StdSerializer<Object> {

	private static final long serialVersionUID = 4789818865395456012L;

	/**
	 * 构造方法
	 */
	public ObjectJSONSerializer() {
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
		gen.writeString(MapperUtils.MAPPER.get().writeValueAsString(value));
	}

}
