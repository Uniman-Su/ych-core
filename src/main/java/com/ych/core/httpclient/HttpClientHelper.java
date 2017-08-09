package com.ych.core.httpclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ych.core.fasterxml.jackson.MapperUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * HTTP客户端
 *
 * @author U
 *
 */
public class HttpClientHelper {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientHelper.class);

	/**
	 * HTTP客户端
	 */
	private CloseableHttpClient httpClient;

	/**
	 * 客户端请求上下文参数
	 */
	private HttpClientContext clientContext;

	/**
	 * 获取连接超时时间
	 */
	private int connectionRequestTimeout;

	/**
	 * 连接超时时间
	 */
	private int connectTimeout;

	/**
	 * @return HTTP客户端
	 */
	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

	/**
	 * @param httpClient
	 *            HTTP客户端
	 */
	public void setHttpClient(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	/**
	 * 调用CloseableHttpClient同名方法
	 *
	 * @param target
	 * @param request
	 * @param context
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public CloseableHttpResponse execute(final HttpHost target, final HttpRequest request, final HttpContext context)
			throws IOException, ClientProtocolException {
		return httpClient.execute(target, request, context);
	}

	/**
	 * 调用CloseableHttpClient同名方法
	 *
	 * @param request
	 * @param context
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public CloseableHttpResponse execute(final HttpUriRequest request, final HttpContext context) throws IOException, ClientProtocolException {
		return httpClient.execute(request, context);
	}

	/**
	 * 调用CloseableHttpClient同名方法
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public CloseableHttpResponse execute(final HttpUriRequest request) throws IOException, ClientProtocolException {
		if (clientContext == null) {
			return httpClient.execute(request);
		} else {
			return httpClient.execute(request, clientContext);
		}
	}

	/**
	 * 调用CloseableHttpClient同名方法
	 *
	 * @param target
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public CloseableHttpResponse execute(final HttpHost target, final HttpRequest request) throws IOException, ClientProtocolException {
		if (clientContext == null) {
			return httpClient.execute(target, request);
		} else {
			return httpClient.execute(target, request, clientContext);
		}
	}

	/**
	 * 将返回内容当做文本读取
	 *
	 * @param is
	 *            输入流
	 * @return 返回的文本
	 * @throws IOException
	 *             发生异常时
	 */
	private String readContentString(InputStream is) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder buffer = new StringBuilder();
		for (String line = reader.readLine(); line != null; line = reader.readLine()) {
			buffer.append(line);
		}

		return buffer.toString();
	}

	/**
	 * 执行请求和响应都是JSON报文的请求
	 *
	 * @param target
	 *            请求的目标URL
	 * @param reqObj
	 *            请求对象
	 * @param valueTypeRef
	 *            JSON解析的类型
	 * @return 返回结果对象
	 * @throws IOException
	 *             发生I/O异常
	 * @throws ClientProtocolException
	 *             客户端协议异常
	 */
	public <T> T executeJSON(String target, Object reqObj, TypeReference<T> valueTypeRef) throws ClientProtocolException, IOException {
		return executeJSON(target, reqObj, valueTypeRef, false);
	}

	/**
	 * 执行请求和响应都是JSON报文的请求
	 *
	 * @param target
	 *            请求的目标URL
	 * @param reqObj
	 *            请求对象
	 * @param valueTypeRef
	 *            JSON解析的类型
	 * @param isForce
	 *            是否强制转换,即使返回码不为200也尝试进行转换
	 * @return 返回结果对象
	 * @throws IOException
	 *             发生I/O异常
	 * @throws ClientProtocolException
	 *             客户端协议异常
	 */
	public <T> T executeJSON(String target, Object reqObj, TypeReference<T> valueTypeRef, boolean isForce) throws ClientProtocolException, IOException {
		ObjectMapper mapper = MapperUtils.MAPPER.get();

		String s = mapper.writeValueAsString(reqObj);

		HttpPost post = new HttpPost(target);
		post.setEntity(new StringEntity(s, ContentType.APPLICATION_JSON));
		CloseableHttpResponse httpResp = null;

		try {
			httpResp = execute(post);
			int statusCode = httpResp.getStatusLine().getStatusCode();

			if (isForce) {
				return mapper.readValue(httpResp.getEntity().getContent(), valueTypeRef);
			} else {
				if (statusCode == HttpStatus.SC_OK) {
					return mapper.readValue(httpResp.getEntity().getContent(), valueTypeRef);
				} else {
					logger.error("HTTP response code:{}, content:{}", statusCode, readContentString(httpResp.getEntity().getContent()));
					throw new IOException("HTTP response code:" + statusCode);
				}
			}
		} finally {
			IOUtils.closeQuietly(httpResp);
		}
	}

	/**
	 * 初始化
	 */
	@PostConstruct
	public void init() {
		RequestConfig requestConfig = null;
		RequestConfig.Builder requestConfigBuilder = null;

		if (connectionRequestTimeout != 0) {
			requestConfigBuilder = RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout);
		}

		if (connectTimeout != 0) {
			if (requestConfigBuilder == null) {
				requestConfigBuilder = RequestConfig.custom();
			}

			requestConfigBuilder.setConnectTimeout(connectTimeout).setSocketTimeout(connectTimeout);
		}

		if (requestConfigBuilder != null) {
			requestConfig = requestConfigBuilder.build();

			clientContext = HttpClientContext.create();
			clientContext.setRequestConfig(requestConfig);
		}
	}

	/**
	 * @return 获取连接超时时间
	 */
	public int getConnectionRequestTimeout() {
		return connectionRequestTimeout;
	}

	/**
	 * @param connectionRequestTimeout
	 *            获取连接超时时间
	 */
	public void setConnectionRequestTimeout(int connectionRequestTimeout) {
		this.connectionRequestTimeout = connectionRequestTimeout;
	}

	/**
	 * @return 连接超时时间
	 */
	public int getConnectTimeout() {
		return connectTimeout;
	}

	/**
	 * @param connectTimeout
	 *            连接超时时间
	 */
	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}
}
