package com.ych.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ych.core.Constants;
import com.ych.core.model.SystemParameterKey;
import com.ych.core.service.SystemParameterService;

/**
 * 处理主题URL的拦截器
 * 
 * @author U
 *
 */
public class JQEasyUIThemeInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 默认主题的URL
	 */
	private String defaultThemeUrl;

	@Autowired
	private SystemParameterService sysParamSvc;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url = sysParamSvc.getStringValue(SystemParameterKey.EASYUI_THEME_URL);

		if (url == null) {
			url = defaultThemeUrl;
		}

		StringBuilder buffer = new StringBuilder(request.getContextPath());
		if (url.charAt(0) == '/') {
			buffer.append(url);
		} else {
			buffer.append('/').append(url);
		}

		request.setAttribute(Constants.REQ_JQEASYUI_THEME_URL, buffer.toString());
		return true;
	}

	/**
	 * @param defaultThemeUrl
	 *            默认的主题URL
	 */
	public void setDefaultThemeUrl(String defaultThemeUrl) {
		this.defaultThemeUrl = defaultThemeUrl;
	}

	/**
	 * @param sysParamSvc
	 *            系统参数服务
	 */
	public void setSysParamSvc(SystemParameterService sysParamSvc) {
		this.sysParamSvc = sysParamSvc;
	}

}
