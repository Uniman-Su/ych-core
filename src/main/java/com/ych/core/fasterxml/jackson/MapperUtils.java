package com.ych.core.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 映射工具
 * 
 * @author U
 *
 */
public class MapperUtils {
	
	private MapperUtils(){};
	
	/**
	 * JSON对象映射器的线程变量
	 */
	public static final ThreadLocal<ObjectMapper> MAPPER = new ThreadLocal<ObjectMapper>() {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.ThreadLocal#initialValue()
		 */
		@Override
		protected ObjectMapper initialValue() {
			ObjectMapper mapper = new ObjectMapper();
			
			mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
			
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
			
			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
			mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
			
			return mapper;
		}

	};

    /**
     * XML对象映射器的线程变量
     */
	public static final ThreadLocal<XmlMapper> XML_MAPPER = new ThreadLocal<XmlMapper>() {

        @Override
        protected XmlMapper initialValue() {
            JacksonXmlModule module = new JacksonXmlModule();
            module.setDefaultUseWrapper(false);;

            XmlMapper mapper = new XmlMapper(module);

            mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

            return mapper;
        }
    };

}
