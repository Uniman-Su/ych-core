package com.ych.core.wechat.model.notify;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ych.core.map.utils.MapUtils;
import com.ych.core.model.CommonOperationResult;
import com.ych.core.wechat.constants.WeChatRespCode;
import com.ych.core.wechat.model.ParameterProvider;

public class NotifySupport implements Notify {
	
	private Logger logger = LoggerFactory.getLogger(NotifySupport.class);

	private NotifyHandler notifyHandler;
	
	private NotifyRecord notifyRecord;
	
	private ParameterProvider parameterProvider;
	
	
	public void setNotifyHandler(NotifyHandler notifyHandler) {
		this.notifyHandler = notifyHandler;
	}

	public void setNotifyRecord(NotifyRecord notifyRecord) {
		this.notifyRecord = notifyRecord;
	}

	public void setParameterProvider(ParameterProvider parameterProvider) {
		this.parameterProvider = parameterProvider;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String notify(String xml) {
		XmlMapper mapper = new XmlMapper();
		NotifyReq req = null;
		try {
		   Assert.notNull(xml);
			req = mapper.readValue(xml, NotifyReq.class);
			if(req.isSuccess()){
				Map<String,Object> map = mapper.readValue(xml, Map.class);
				if(map.containsKey("sign")){
				    map.remove("sign");
				}
				String signKey = parameterProvider.getSignKey();
				Assert.notNull(signKey, "signKey can not be null");
				String signTemp = MapUtils.toSortQueryString(map)+"&key="+signKey;
				String sign = DigestUtils.md5Hex(signTemp).toUpperCase();
				if(sign.equals(req.getSign())){
				    if(notifyRecord!=null){
				        notifyRecord.record(req.getOut_trade_no(), xml);
				    }
				    
					if(notifyHandler!=null){
					    CommonOperationResult result = notifyHandler.handle(req);
					    if(result == CommonOperationResult.Succeeded){
					        return getResult(true, "OK");
					    }else{
					        return getResult(false, "handle failure");
					    }
					}else{
					    return getResult(false, "no handler");
					}
				}else{
					logger.info("wechat notify sign vaild failure");
					return getResult(false, "sign vaild failure");
				}
			}else{
				return getResult(false, null);
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
		    e.printStackTrace();
        }
		return getResult(false, null);
	}
	
	private String getResult(boolean success,String msg){
		StringBuffer result = new StringBuffer();
		result.append("<xml>");
		result.append("<return_code>");
		if(success){
			result.append(WeChatRespCode.SUCCESS);
		}else{
			result.append(WeChatRespCode.FAIL);
		}
		result.append("</return_code>");
		result.append("<return_msg>");
		if(!StringUtils.isEmpty(msg)){
			result.append(msg);
		}
		result.append("</return_msg>");
		result.append("</xml>");
		return result.toString();
	}

}
