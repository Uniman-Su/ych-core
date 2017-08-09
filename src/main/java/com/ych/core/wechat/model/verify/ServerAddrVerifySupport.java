package com.ych.core.wechat.model.verify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.ych.core.wechat.utils.ArraysUtils;
import com.ych.core.wechat.utils.SHA1Utils;

public class ServerAddrVerifySupport implements ServerAddrVerify {

	private static Logger logger = LoggerFactory.getLogger(ServerAddrVerifySupport.class);

	@Override
	public String verify(String signature, String timestamp, String nonce, String echostr, String token) {

		String result = null;
		String localSignature = null;
		try {
			Assert.notNull(signature, "Wechat request paramter error");
			Assert.notNull(timestamp, "Wechat request paramter error");
			Assert.notNull(nonce, "Wechat request paramter error");
			Assert.notNull(echostr, "Wechat request paramter error");
			Assert.notNull(token, "Wechat Server verify error,not provide token");

			// 加密参数
			String[] arr = new String[] { token, timestamp, nonce };
			// 待加密字符串(参数值字典排序后连接成字符串)
			String encStr = ArraysUtils.join(arr);
			localSignature = SHA1Utils.encrypt(encStr);
			result = localSignature.equalsIgnoreCase(signature) ? echostr : result;

		} catch (Exception e) {
			logger.error(
					String.format(
							"Wechat Server Verify[signature=%s,timestamp=%s,nonce=%s,echostr=%s,token=%s],local[signature=%s],Response[%s]",
							signature, timestamp, nonce, echostr, token, localSignature, result), e);
		}
		logger.info(String.format(
				"Wechat Server Verify[signature=%s,timestamp=%s,nonce=%s,echostr=%s,token=%s],local[signature=%s],Response[%s]",
				signature, timestamp, nonce, echostr, token, localSignature, result));
		return result;
	}
}
