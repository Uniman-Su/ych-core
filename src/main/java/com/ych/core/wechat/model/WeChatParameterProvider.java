package com.ych.core.wechat.model;

import com.ych.core.service.SystemParameterService;
import com.ych.core.wechat.constants.WeChatParameterConstants;

public class WeChatParameterProvider implements ParameterProvider {

	private SystemParameterService systemParameterService;
	
	public void setSystemParameterService(SystemParameterService systemParameterService) {
		this.systemParameterService = systemParameterService;
	}
	
	@Override
	public String getAppID() {
		return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_APP_ID_KEY);
	}

	@Override
	public String getAppSecret() {
		return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_APP_SECRET_KEY);
	}

	@Override
	public String getEncryptionToken() {
		return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_ENCRYPTION_TOKEN_KEY);
	}

	@Override
	public String getShareUrl() {
		return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_SHARE_URL_KEY);
	}

	@Override
	public String getAuthCallbackUrl() {
		return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_AUTH_CALLBACE_URL_KEY);
	}

	@Override
	public String getPayCallbackUrl() {
		return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_PAY_CALLBACK_URL_KEY);
	}

	@Override
	public String getMchId() {
		return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_MCH_ID_KEY);
	}

	@Override
	public String getDeviceInfo() {
		return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_DEVICE_INFO_KEY);
	}

	@Override
	public String getSignKey() {
		return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_SIGN_KEY);
	}

    @Override
    public String getOrderBodyPrefix() {
        return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_PAY_BODY_PREFIX_KEY);
    }

    @Override
    public String getMessageTemplateId() {
        return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_MESSAGE_TEMPLATE_ID_KEY);
    }

    @Override
    public String getPayedMessageContent() {
        return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_PAYED_MESSAGE_CONTENT_KEY);
    }

    @Override
    public String getConfirmedMessageContent() {
        return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_CONFIRMED_MESSAGE_CONTENT_KEY);
    }

    @Override
    public String getServicedMessageContent() {
        return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_SSERVICED_MESSAGE_CONTENT_KEY);
    }
    
    @Override
    public String getNameTemplate() {
        return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_MESSAGE_PUSH_NAME_KRY);
    }

    @Override
    public String getProdAuthCallbackUrl() {
        return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_PROD_AUTH_CALLBACE_URL_KRY);
    }

    @Override
    public String getTestAuthCallbackUrl() {
        return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_TEST_AUTH_CALLBACE_URL_KRY);
    }

    @Override
    public String getDevEnv() {
        return systemParameterService.getStringValue(WeChatParameterConstants.WECHAT_APP_DEV_ENV_KRY);
    }

    

}
