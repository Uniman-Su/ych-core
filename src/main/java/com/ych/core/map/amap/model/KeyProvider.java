package com.ych.core.map.amap.model;

/**
 * 数据签名key获取接口
 * @author sunny
 *
 */
public interface  KeyProvider {

	/**
	 * 获取接口签名Key
	 * @return
	 */
	   String getKey();
	   /**
	    * 获取接口签名私钥
	    * @return
	    */
	   String getPrivateKey();
	   /**
	    * 获取接口域名
	    * @return
	    */
	   String getDomain();
}
