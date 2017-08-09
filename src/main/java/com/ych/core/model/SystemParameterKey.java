package com.ych.core.model;

/**
 * 系统参数的Key
 * 
 * @author U
 *
 */
public interface SystemParameterKey {

	/**
	 * jQuery easyUI的主题URL
	 */
	String EASYUI_THEME_URL = "easyUIThemeURL";

	/**
	 * 上传文件正式目录的URL前缀
	 */
	String UPLOAD_URL_PREFIX = "uploadUrlPrefix";

	/**
	 * 上传文件的临时目录的URL前缀
	 */
	String UPLOAD_URL_TEMP_PREFIX = "uploadFileTempUrlPrefix";
	
	/**
	 * 监听跨系统事件的事件列表前缀
	 */
	String EVENT_QUEUE_PREFIX = "EventQueues";

}
