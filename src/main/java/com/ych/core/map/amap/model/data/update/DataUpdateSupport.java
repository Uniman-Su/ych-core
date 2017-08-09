package com.ych.core.map.amap.model.data.update;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ych.core.map.amap.model.AmapCore;
import com.ych.core.map.amap.model.KeyProvider;
import com.ych.core.map.amap.model.RespBase;
import com.ych.core.map.amap.model.data.create.DataCreateResp;
import com.ych.core.map.amap.model.data.create.LocType;

public class DataUpdateSupport implements DataUpdate {

	private KeyProvider keyProvider;
	
	private AmapCore amapCore;
	
	public void setKeyProvider(KeyProvider keyProvider) {
		this.keyProvider = keyProvider;
	}
	
	public void setAmapCore(AmapCore amapCore) {
		this.amapCore = amapCore;
	}

	@Override
	public RespBase update(String tableId, String id, String name, String location, Map<String, Object> columns) {
		Assert.notNull(keyProvider, "the instance of KeyProvider didn't inject");
		Assert.notNull(amapCore, "the instance of AmapCore didn't inject");
		Map<String,Object> params = new HashMap<>();
		String key = keyProvider.getKey();
		params.put("key", key);
		params.put("tableid", tableId);
		params.put("loctype",LocType.LOCATION.getValue());
		ObjectMapper mapper = new ObjectMapper();  
	    ObjectNode rootNode = mapper.createObjectNode();
	    rootNode.put("_id", id);
	    rootNode.put("_name", name);
	    rootNode.put("_location", location);
		if(columns!=null){
			Set<String> keys = columns.keySet();
			for(String k:keys){
				rootNode.put(k, columns.get(k).toString());
			}
		}
		params.put("data", rootNode.toString());
		return amapCore.postForObject(RELATIVE_URL, DataCreateResp.class, params);
	}

}
