package com.ych.core.map.amap.model.table.create;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import com.ych.core.map.amap.model.AmapCore;
import com.ych.core.map.amap.model.KeyProvider;

public class TableCreateSupport implements TableCreate {

	private KeyProvider keyProvider;
	
	private AmapCore amapCore;
	
	public void setKeyProvider(KeyProvider keyProvider) {
		this.keyProvider = keyProvider;
	}

	public void setAmapCore(AmapCore amapCore) {
		this.amapCore = amapCore;
	}

	@Override
	public TableCreateResp create(String tableName) {
		Assert.notNull(keyProvider, "the instance of KeyProvider didn't inject");
		Assert.notNull(amapCore, "the instance of AmapCore didn't inject");
		Map<String,Object> params =new HashMap<>();
		String key = keyProvider.getKey();
		params.put("key", key);
		params.put("name", tableName);
		return amapCore.postForObject(RELATIVE_URL, TableCreateResp.class, params);
	}

}
