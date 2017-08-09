package com.ych.core.wechat.model.verify;

/**
 * URL有效性验证
 * <p>
 * 开发者提交信息后，微信服务器将发送GET请求到填写的URL上,开发者通过检验signature对请求进行校验
 * 若确认此次GET请求来自微信服务器，请原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败,返回null。
 * </p>
 * <p>
 * 加密/校验流程如下：
 * </p>
 * <p>
 * 1.将token、timestamp、nonce三个参数值进行字典序排序
 * </p>
 * <p>
 * 2. 将三个参数字符串拼接成一个字符串进行sha1加密
 * </p>
 * <p>
 * 3.开发者获得加密后的字符串,若与signature相同，则该请求来源于微信
 * </p>
 * 
 * @author SUNCHUANLIN
 * @since 1.0.0
 *
 */
public interface ServerAddrVerify {
	/**
	 * 处理微信发起的服务器地址验证请求
	 * 
	 * @param signature
	 *            微信加密签名
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @param echostr
	 *            随机字符串
	 * @param token
	 *            与微信约定好的token
	 * @return 验证通过返回echostr,否则返回null
	 */
	public String verify(String signature, String timestamp, String nonce, String echostr,String token);

}
