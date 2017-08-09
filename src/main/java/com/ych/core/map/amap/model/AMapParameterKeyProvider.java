package com.ych.core.map.amap.model;

import org.springframework.util.Assert;

import com.ych.core.map.amap.constants.AMapParameterConstans;
import com.ych.core.service.SystemParameterService;

public class AMapParameterKeyProvider implements KeyProvider {

	private SystemParameterService systemParameterService;

	public void setSystemParameterService(SystemParameterService systemParameterService) {
		this.systemParameterService = systemParameterService;
	}

	@Override
	public String getKey() {
		Assert.notNull(systemParameterService, "the instance of SystemParameterService didn't inject");
		return systemParameterService.getStringValue(AMapParameterConstans.AMAP_KEY);
	}

	@Override
	public String getPrivateKey() {
		Assert.notNull(systemParameterService, "the instance of SystemParameterService didn't inject");
		return systemParameterService.getStringValue(AMapParameterConstans.AMAP_PRIVATE_KEY);
	}

	@Override
	public String getDomain() {
		Assert.notNull(systemParameterService, "the instance of SystemParameterService didn't inject");
		return systemParameterService.getStringValue(AMapParameterConstans.AMAP_DOMAIN_KEY);
	}

}
