package com.ych.core.model.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import com.ych.core.model.SystemParameterType;
import com.ych.core.mybatis.type.IntValueHolderTypeHandler;

/**
 * 系统参数类型处理器
 * 
 * @author U
 *
 */
@MappedTypes(SystemParameterType.class)
@MappedJdbcTypes(JdbcType.NUMERIC)
public class SystemParameterTypeHandler extends IntValueHolderTypeHandler<SystemParameterType> {

	public SystemParameterTypeHandler(Class<SystemParameterType> type) {
		super(type);
	}

}
