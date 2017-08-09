package com.ych.core.wechat.model.notify;

import com.ych.core.model.CommonOperationResult;

/**
 * 支付回调业务处理接口
 * @author sunny
 *
 */
public interface NotifyHandler {

	CommonOperationResult handle(NotifyReq req);
	
}
