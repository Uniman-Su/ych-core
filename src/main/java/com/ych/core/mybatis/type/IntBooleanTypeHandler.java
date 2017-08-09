package com.ych.core.mybatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

/**
 * Boolean值的类型处理器
 * 
 * @author U
 *
 */
@MappedTypes(Boolean.class)
@MappedJdbcTypes(value = { JdbcType.NUMERIC, JdbcType.INTEGER, JdbcType.BIGINT })
public class IntBooleanTypeHandler extends BaseTypeHandler<Boolean> {

	/**
	 * true的数值
	 */
	public static final int TRUE = 1;

	/**
	 * false的数值
	 */
	public static final int FALSE = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.ibatis.type.BaseTypeHandler#setNonNullParameter(java.sql.
	 * PreparedStatement, int, java.lang.Object,
	 * org.apache.ibatis.type.JdbcType)
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType)
			throws SQLException {
		if (parameter == null) {
			ps.setNull(i, JdbcType.NUMERIC.TYPE_CODE);
		} else if (parameter == true) {
			ps.setInt(i, TRUE);
		} else {
			ps.setInt(i, FALSE);
		}
	}

	/**
	 * 获取对应的Boolean值
	 * 
	 * @param number
	 *            数据
	 * @return Boolean值
	 * @throws SQLException
	 *             取值范围错误
	 */
	private Boolean getBoolean(Number number) throws SQLException {
		if (number == null) {
			return null;
		}

		int value = number.intValue();

		if (value == TRUE) {
			return Boolean.TRUE;
		} else if (value == FALSE) {
			return Boolean.FALSE;
		} else {
			throw new SQLException("Unsupported boolean value:" + value);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.
	 * ResultSet, java.lang.String)
	 */
	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return getBoolean(rs.getBigDecimal(columnName));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.
	 * ResultSet, int)
	 */
	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return getBoolean(rs.getBigDecimal(columnIndex));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.
	 * CallableStatement, int)
	 */
	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return getBoolean(cs.getBigDecimal(columnIndex));
	}

}
