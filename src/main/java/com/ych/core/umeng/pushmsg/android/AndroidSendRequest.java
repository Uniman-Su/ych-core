package com.ych.core.umeng.pushmsg.android;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ych.core.fasterxml.jackson.databind.ser.ObjectStringSerializer;
import com.ych.core.umeng.pushmsg.MsgType;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Android发送请求
 * 
 * @author U
 *
 */
@JsonInclude(value = Include.NON_NULL)
public class AndroidSendRequest {

	/**
	 * 必填,应用唯一标识
	 */
	@JsonProperty("appkey")
	private String appKey;

	/**
	 * 必填,时间戳
	 */
	@JsonSerialize(using = ObjectStringSerializer.class)
	private Long timestamp;

	/**
	 * 必填,消息发送类型
	 */
	private MsgType type;

	/**
	 * 可选,设备唯一表示<br>
	 * 当type=unicast时,必填, 表示指定的单个设备,<br>
	 * 当type=listcast时,必填,要求不超过500个,多个device_token以英文逗号间隔
	 */
	@JsonProperty("device_tokens")
	private String deviceTokens;

	/**
	 * 可选,当type=customizedcast时,必填，alias的类型
	 */
	@JsonProperty("alias_type")
	private String aliasType;

	/**
	 * 可选 当type=customizedcast时,开发者填写自己的alias<br>
	 * 要求不超过50个alias,多个alias以英文逗号间隔。<br>
	 * 
	 */
	private String alias;

	/**
	 * 可选,当type=filecast时，file内容为多条device_token,device_token以回车符分隔<br>
	 * 当type=customizedcast时,file内容为多条alias,alias以回车符分隔，
	 * 注意同一个文件内的alias所对应的alias_type必须和接口参数alias_type一致。
	 */
	@JsonProperty("file_id")
	private String fileId;

	/**
	 * 可选,终端用户筛选条件,如用户标签、地域、应用版本以及渠道等
	 */
	private Object filter;

	/**
	 * 必填,消息内容(Android最大为1840B)
	 */
	private AndroidSendRequestPayload payload;

	/**
	 * 可选,发送策略
	 */
	private AndroidPolicy policy;

	/**
	 * 可选,正式/测试模式.测试模式下,广播/组播只会将消息发给测试设备.
	 */
	@JsonProperty("production_mode")
	@JsonSerialize(using = ObjectStringSerializer.class)
	private Boolean productionMode = Boolean.FALSE;

	/**
	 * 可选,发送消息描述，建议填写
	 */
	private String description;

	/**
	 * 可选,开发者自定义消息标识ID<br>
	 * 开发者可以为同一批发送的多条消息提供同一个thirdparty_id, 便于友盟后台后期合并统计数据.
	 */
	@JsonProperty("thirdparty_id")
	private String thirdPartyId;

	/**
	 * @return 必填,应用唯一标识
	 */
	public String getAppKey() {
		return appKey;
	}

	/**
	 * @param appKey
	 *            必填,应用唯一标识
	 */
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	/**
	 * @return 必填,消息发送类型
	 */
	public MsgType getType() {
		return type;
	}

	/**
	 * @param type
	 *            必填,消息发送类型
	 */
	public void setType(MsgType type) {
		this.type = type;
	}

	/**
	 * @return 可选,当type=customizedcast时,必填，alias的类型
	 */
	public String getAliasType() {
		return aliasType;
	}

	/**
	 * @param aliasType
	 *            可选,当type=customizedcast时,必填，alias的类型
	 */
	public void setAliasType(String aliasType) {
		this.aliasType = aliasType;
	}

	/**
	 * @return 可选 当type=customizedcast时,开发者填写自己的alias<br>
	 *         要求不超过50个alias,多个alias以英文逗号间隔。<br>
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias
	 *            可选 当type=customizedcast时,开发者填写自己的alias<br>
	 *            要求不超过50个alias,多个alias以英文逗号间隔。<br>
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return 必填,消息内容(Android最大为1840B)
	 */
	public AndroidSendRequestPayload getPayload() {
		return payload;
	}

	/**
	 * @param payload
	 *            必填,消息内容(Android最大为1840B)
	 */
	public void setPayload(AndroidSendRequestPayload payload) {
		this.payload = payload;
	}

	/**
	 * @return 可选,发送消息描述，建议填写
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            可选,发送消息描述，建议填写
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return 必填,时间戳
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            必填,时间戳
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return 可选,设备唯一表示<br>
	 *         当type=unicast时,必填, 表示指定的单个设备,<br>
	 *         当type=listcast时,必填,要求不超过500个,多个device_token以英文逗号间隔
	 */
	public String getDeviceTokens() {
		return deviceTokens;
	}

	/**
	 * @param deviceTokens
	 *            可选,设备唯一表示<br>
	 *            当type=unicast时,必填, 表示指定的单个设备,<br>
	 *            当type=listcast时,必填,要求不超过500个,多个device_token以英文逗号间隔
	 */
	public void setDeviceTokens(String deviceTokens) {
		this.deviceTokens = deviceTokens;
	}

	/**
	 * @return 可选,当type=filecast时，file内容为多条device_token,device_token以回车符分隔<br>
	 *         当type=customizedcast时,file内容为多条alias,alias以回车符分隔，
	 *         注意同一个文件内的alias所对应的alias_type必须和接口参数alias_type一致。
	 */
	public String getFileId() {
		return fileId;
	}

	/**
	 * @param fileId
	 *            可选,当type=filecast时，file内容为多条device_token,device_token以回车符分隔
	 *            <br>
	 *            当type=customizedcast时,file内容为多条alias,alias以回车符分隔，
	 *            注意同一个文件内的alias所对应的alias_type必须和接口参数alias_type一致。
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	/**
	 * @return 可选,终端用户筛选条件,如用户标签、地域、应用版本以及渠道等
	 */
	public Object getFilter() {
		return filter;
	}

	/**
	 * @param filter
	 *            可选,终端用户筛选条件,如用户标签、地域、应用版本以及渠道等
	 */
	public void setFilter(Object filter) {
		this.filter = filter;
	}

	/**
	 * @return 可选,发送策略
	 */
	public AndroidPolicy getPolicy() {
		return policy;
	}

	/**
	 * @param policy
	 *            可选,发送策略
	 */
	public void setPolicy(AndroidPolicy policy) {
		this.policy = policy;
	}

	/**
	 * @return 可选,正式/测试模式.测试模式下,广播/组播只会将消息发给测试设备.
	 */
	public Boolean getProductionMode() {
		return productionMode;
	}

	/**
	 * @param productionMode
	 *            可选,正式/测试模式.测试模式下,广播/组播只会将消息发给测试设备.
	 */
	public void setProductionMode(Boolean productionMode) {
		this.productionMode = productionMode;
	}

	/**
	 * @return 可选,开发者自定义消息标识ID<br>
	 *         开发者可以为同一批发送的多条消息提供同一个thirdparty_id, 便于友盟后台后期合并统计数据.
	 */
	public String getThirdPartyId() {
		return thirdPartyId;
	}

	/**
	 * @param thirdPartyId
	 *            可选,开发者自定义消息标识ID<br>
	 *            开发者可以为同一批发送的多条消息提供同一个thirdparty_id, 便于友盟后台后期合并统计数据.
	 */
	public void setThirdPartyId(String thirdPartyId) {
		this.thirdPartyId = thirdPartyId;
	}

}
