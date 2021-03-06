package com.ych.core.mybatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import com.ych.core.model.AbstractIntValueHolder;
import com.ych.core.model.IntValueHolder;

@MappedTypes(IntValueHolder.class)
@MappedJdbcTypes(JdbcType.NUMERIC)
public class IntValueHolderTypeHandler<T extends Enum<T>> extends BaseTypeHandler<T> {

	/**
	 * 类型
	 */
	private Class<? extends IntValueHolder<T>> type;

	/**
	 * 构造方法
	 * 
	 * @param type
	 *            处理的类型
	 */
	public IntValueHolderTypeHandler(Class<? extends IntValueHolder<T>> type) {
		if (type == null) {
			throw new IllegalArgumentException("Type argument cannot be null");
		}
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.ibatis.type.BaseTypeHandler#setNonNullParameter(java.sql.
	 * PreparedStatement, int, java.lang.Object,
	 * org.apache.ibatis.type.JdbcType)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, ((IntValueHolder) parameter).getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.
	 * ResultSet, java.lang.String)
	 */
	@Override
	public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int i = rs.getInt(columnName);

		if (rs.wasNull()) {
			return null;
		}

		return AbstractIntValueHolder.valueOf(type, i);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.
	 * ResultSet, int)
	 */
	@Override
	public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int i = rs.getInt(columnIndex);

		if (rs.wasNull()) {
			return null;
		}

		return AbstractIntValueHolder.valueOf(type, i);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.
	 * CallableStatement, int)
	 */
	@Override
	public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int i = cs.getInt(columnIndex);

		if (cs.wasNull()) {
			return null;
		}

		return AbstractIntValueHolder.valueOf(type, i);
	}

}
