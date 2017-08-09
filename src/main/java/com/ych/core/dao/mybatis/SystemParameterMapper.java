package com.ych.core.dao.mybatis;

import java.util.HashMap;

import org.springframework.cache.annotation.Cacheable;

import com.ych.core.dao.BaseSqlSessionDaoSupport;
import com.ych.core.dao.SystemParameterDao;
import com.ych.core.model.SystemParameter;

/**
 * 系统参数
 * 
 * @author U
 *
 */
public class SystemParameterMapper extends BaseSqlSessionDaoSupport implements SystemParameterDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.dao.SystemParameterDao#selectAppParam(java.lang.String,
	 * java.lang.String)
	 */
	@Cacheable(cacheNames = SYSTEM_PARAMETER_CACHE_NAME, key = "new org.springframework.cache.interceptor.SimpleKey(#p0, #p1).toString()")
	public SystemParameter selectAppParam(String appKey, String key) {
		HashMap<String, String> param = new HashMap<>();
		param.put("appKey", appKey);
		param.put("key", key);
		SystemParameter ret = getSqlSession().selectOne("com.ych.core.dao.mybatis.SystemParameterMapper.selectAppParam", param);
		if (ret != null) {
			ret.initTransferedValue();
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ych.core.dao.SystemParameterDao#selectGlobalParam(java.lang.String)
	 */
	@Cacheable("SystemParameter")
	public SystemParameter selectGlobalParam(String key) {
		SystemParameter ret = getSqlSession().selectOne("com.ych.core.dao.mybatis.SystemParameterMapper.selectGlobalParam", key);
		if (ret != null) {
			ret.initTransferedValue();
		}
		return ret;
	}

}
