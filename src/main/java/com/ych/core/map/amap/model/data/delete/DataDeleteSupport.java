package com.ych.core.map.amap.model.data.delete;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import com.ych.core.map.amap.model.AmapCore;
import com.ych.core.map.amap.model.KeyProvider;

public class DataDeleteSupport implements DataDelete {

	private KeyProvider keyProvider;

	private AmapCore amapCore;
	
	public void setKeyProvider(KeyProvider keyProvider) {
		this.keyProvider = keyProvider;
	}

	public void setAmapCore(AmapCore amapCore) {
		this.amapCore = amapCore;
	}
	
	@Override
	public DataDeleteResp delete(String tableId, String... ids) {
		Assert.notNull(keyProvider, "the instance of KeyProvider didn't inject");
		Assert.notNull(amapCore, "the instance of AmapCore didn't inject");
		Map<String,Object> params = new HashMap<>();
		String key = keyProvider.getKey();
		params.put("key", key);
		params.put("tableid", tableId);
		StringBuffer buffer = new StringBuffer();
		if(ids!=null){
			for(String id:ids){
				buffer.append(id);
				buffer.append(",");
			}
			
			if(buffer.length()>0){
				buffer = buffer.deleteCharAt(buffer.length()-1);
			}
			params.put("ids", buffer.toString());
		}
		return amapCore.postForObject(RELATIVE_URL, DataDeleteResp.class, params);
	}

}
