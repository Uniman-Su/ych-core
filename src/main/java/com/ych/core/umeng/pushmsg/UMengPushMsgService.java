package com.ych.core.umeng.pushmsg;

import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.ClientProtocolException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ych.core.fasterxml.jackson.MapperUtils;
import com.ych.core.httpclient.HttpClientHelper;
import com.ych.core.umeng.pushmsg.android.AndroidSendRequest;
import com.ych.core.umeng.pushmsg.ios.IOSSendRequest;

/**
 * 友盟推送消息服务
 * 
 * @author U
 *
 */
public class UMengPushMsgService {

	/**
	 * 上传文件的最大长度
	 */
	public static long FILE_MAX_LENGTH = 1024 * 1024 * 10;

	/**
	 * HTTP客户端
	 */
	private HttpClientHelper httpClientHelper;

	/**
	 * Android使用的AppKey
	 */
	private String androidAppKey;

	/**
	 * 发送的URL
	 */
	private String sendApiUrl;

	/**
	 * 上传文件的URL
	 */
	private String uploadApiUrl;

	/**
	 * Android使用的加密秘钥
	 */
	private String androidAppMasterSecret;

	/**
	 * iOS使用的Appkey
	 */
	private String iosAppKey;

	/**
	 * iOS使用的加密秘钥
	 */
	private String iosAppMasterSecret;

	/**
	 * 是否生产模式
	 */
	private boolean productionMode;

	/**
	 * 发送Android的推送消息
	 * 
	 * @param request
	 *            请求对象
	 * @return 响应消息
	 * @throws ClientProtocolException
	 *             客户端协议异常
	 * @throws IOException
	 *             发生I/O异常
	 */
	public ResponseMessage<PushMsgResponseData> sendPushMsg(AndroidSendRequest request) throws ClientProtocolException, IOException {
		request.setAppKey(androidAppKey);
		request.setTimestamp(System.currentTimeMillis());
		request.setProductionMode(productionMode);

		String sign = DigestUtils.md5Hex("POST" + sendApiUrl + MapperUtils.MAPPER.get().writeValueAsString(request) + androidAppMasterSecret);

		return httpClientHelper.executeJSON(sendApiUrl + "?sign=" + sign, request, new TypeReference<ResponseMessage<PushMsgResponseData>>() {
		}, true);
	}

	/**
	 * 发送iOS的推送消息
	 * 
	 * @param request
	 *            请求对象
	 * @return 响应消息
	 * @throws ClientProtocolException
	 *             客户端协议异常
	 * @throws IOException
	 *             发生I/O异常
	 */
	public ResponseMessage<PushMsgResponseData> sendPushMsg(IOSSendRequest request) throws ClientProtocolException, IOException {
		request.setAppKey(iosAppKey);
		request.setTimestamp(System.currentTimeMillis());
		request.setProductionMode(productionMode);

		String sign = DigestUtils.md5Hex("POST" + sendApiUrl + MapperUtils.MAPPER.get().writeValueAsString(request) + iosAppMasterSecret);

		return httpClientHelper.executeJSON(sendApiUrl + "?sign=" + sign, request, new TypeReference<ResponseMessage<PushMsgResponseData>>() {
		}, true);
	}

	/**
	 * 上传Android的文件
	 * 
	 * @param content
	 *            文件内容
	 * @return 响应消息
	 * @throws ClientProtocolException
	 *             客户端协议异常
	 * @throws IOException
	 *             发生I/O异常
	 */
	public ResponseMessage<UploadResponseData> uploadForAndroid(String content) throws ClientProtocolException, IOException {
		UploadRequest request = new UploadRequest();
		request.setAppKey(androidAppKey);
		request.setTimestamp(System.currentTimeMillis());
		request.setContent(content);

		String sign = DigestUtils.md5Hex("POST" + uploadApiUrl + MapperUtils.MAPPER.get().writeValueAsString(request) + androidAppMasterSecret);

		return httpClientHelper.executeJSON(uploadApiUrl + "?sign=" + sign, request, new TypeReference<ResponseMessage<UploadResponseData>>() {
		}, true);
	}

	/**
	 * @param content
	 *            文件内容
	 * @return 响应消息
	 * @throws ClientProtocolException
	 *             客户端协议异常
	 * @throws IOException
	 *             发生I/O异常
	 */
	public ResponseMessage<UploadResponseData> uploadForIOS(String content) throws ClientProtocolException, IOException {
		UploadRequest request = new UploadRequest();
		request.setAppKey(iosAppKey);
		request.setTimestamp(System.currentTimeMillis());
		request.setContent(content);

		String sign = DigestUtils.md5Hex("POST" + uploadApiUrl + MapperUtils.MAPPER.get().writeValueAsString(request) + iosAppMasterSecret);

		return httpClientHelper.executeJSON(uploadApiUrl + "?sign=" + sign, request, new TypeReference<ResponseMessage<UploadResponseData>>() {
		}, true);
	}

	/**
	 * @param httpClientHelper
	 *            HTTP客户端
	 */
	public void setHttpClientHelper(HttpClientHelper httpClientHelper) {
		this.httpClientHelper = httpClientHelper;
	}

	/**
	 * @param androidAppKey
	 *            Android使用的AppKey
	 */
	public void setAndroidAppKey(String androidAppKey) {
		this.androidAppKey = androidAppKey;
	}

	/**
	 * @param sendApiUrl
	 *            发送的URL
	 */
	public void setSendApiUrl(String sendApiUrl) {
		this.sendApiUrl = sendApiUrl;
	}

	/**
	 * @param androidAppMasterSecret
	 *            Android使用的加密秘钥
	 */
	public void setAndroidAppMasterSecret(String androidAppMasterSecret) {
		this.androidAppMasterSecret = androidAppMasterSecret;
	}

	/**
	 * @param iosAppKey
	 *            iOS使用的Appkey
	 */
	public void setIosAppKey(String iosAppKey) {
		this.iosAppKey = iosAppKey;
	}

	/**
	 * @param iosAppMasterSecret
	 *            iOS使用的加密秘钥
	 */
	public void setIosAppMasterSecret(String iosAppMasterSecret) {
		this.iosAppMasterSecret = iosAppMasterSecret;
	}

	/**
	 * @param productionMode
	 *            是否生产模式
	 */
	public void setProductionMode(boolean productionMode) {
		this.productionMode = productionMode;
	}

	/**
	 * @param uploadApiUrl
	 *            上传文件的URL
	 */
	public void setUploadApiUrl(String uploadApiUrl) {
		this.uploadApiUrl = uploadApiUrl;
	}

	/**
	 * @return 上传文件的URL
	 */
	public String getUploadApiUrl() {
		return uploadApiUrl;
	}

}
