package com.ych.core.httpclient;

import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.FactoryBean;

public class HttpClientFactoryBean implements FactoryBean<CloseableHttpClient> {

	/**
	 * 连接接管理器
	 */
	private PoolingHttpClientConnectionManager connectionManager;

	/**
	 * 等待数据超时的时间
	 */
	private int soTimeout;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 */
	@Override
	public CloseableHttpClient getObject() throws Exception {

		if (soTimeout != 0) {
			connectionManager.setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(soTimeout).build());
		}

		return HttpClients.custom().setConnectionManager(connectionManager).build();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	@Override
	public Class<CloseableHttpClient> getObjectType() {
		return CloseableHttpClient.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

	/**
	 * @return 连接
	 */
	public PoolingHttpClientConnectionManager getConnectionManager() {
		return connectionManager;
	}

	/**
	 * @param connectionManager
	 *            连接
	 */
	public void setConnectionManager(PoolingHttpClientConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	/**
	 * @return 等待数据超时的时间
	 */
	public int getSoTimeout() {
		return soTimeout;
	}

	/**
	 * @param soTimeout
	 *            等待数据超时的时间
	 */
	public void setSoTimeout(int soTimeout) {
		this.soTimeout = soTimeout;
	}

}
