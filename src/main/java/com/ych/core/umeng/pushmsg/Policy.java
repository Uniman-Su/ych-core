package com.ych.core.umeng.pushmsg;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ych.core.fasterxml.jackson.databind.ser.DateStringSerializer;

/**
 * 发送策略
 * 
 * @author U
 *
 */
@JsonInclude(value = Include.NON_NULL)
public class Policy {

	/**
	 * 可选 定时发送时间，若不填写表示立即发送。<br>
	 * 定时发送时间不能小于当前时间<br>
	 * 格式: "YYYY-MM-DD HH:mm:ss"。<br>
	 * 注意, start_time只对任务生效。
	 */
	@JsonProperty("start_time")
	@JsonSerialize(using = DateStringSerializer.class)
	private Date startTime;

	/**
	 * 可选 消息过期时间,其值不可小于发送时间或者 start_time(如果填写了的话),
	 * 如果不填写此参数，默认为3天后过期。格式同start_time
	 */
	@JsonProperty("expire_time")
	@JsonSerialize(using = DateStringSerializer.class)
	private Date expireTime;

	/**
	 * 可选 发送限速，每秒发送的最大条数。 开发者发送的消息如果有请求自己服务器的资源，可以考虑此参数。
	 */
	@JsonProperty("max_send_num")
	private Integer maxSendNum;

	/**
	 * @return 可选 定时发送时间，若不填写表示立即发送。<br>
	 *         定时发送时间不能小于当前时间<br>
	 *         格式: "YYYY-MM-DD HH:mm:ss"。<br>
	 *         注意, start_time只对任务生效。
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            可选 定时发送时间，若不填写表示立即发送。<br>
	 *            定时发送时间不能小于当前时间<br>
	 *            格式: "YYYY-MM-DD HH:mm:ss"。<br>
	 *            注意, start_time只对任务生效。
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return 可选 消息过期时间,其值不可小于发送时间或者 start_time(如果填写了的话),
	 *         如果不填写此参数，默认为3天后过期。格式同start_time
	 */
	public Date getExpireTime() {
		return expireTime;
	}

	/**
	 * @param expireTime
	 *            可选 消息过期时间,其值不可小于发送时间或者 start_time(如果填写了的话),
	 *            如果不填写此参数，默认为3天后过期。格式同start_time
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	/**
	 * @return 可选 发送限速，每秒发送的最大条数。 开发者发送的消息如果有请求自己服务器的资源，可以考虑此参数。
	 */
	public Integer getMaxSendNum() {
		return maxSendNum;
	}

	/**
	 * @param maxSendNum
	 *            可选 发送限速，每秒发送的最大条数。 开发者发送的消息如果有请求自己服务器的资源，可以考虑此参数。
	 */
	public void setMaxSendNum(Integer maxSendNum) {
		this.maxSendNum = maxSendNum;
	}

}
