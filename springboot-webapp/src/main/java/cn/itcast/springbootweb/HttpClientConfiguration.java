package cn.itcast.springbootweb;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.alibaba.fastjson.JSONObject;

import cn.itcast.springbootweb.http.client.IdleConnectionEvictor;
import cn.itcast.springbootweb.properties.HttpClientProperties;

/*
 * HttpClient配置
 */
@Configuration
public class HttpClientConfiguration {

	@Autowired
	private HttpClientProperties httpClientProperties ;
	
	@Bean(destroyMethod="close")
	public PoolingHttpClientConnectionManager getPoolingHttpClientConnectionManager() {
		System.out.println("-------------------------------------");
		System.out.println(JSONObject.toJSON(httpClientProperties));
		PoolingHttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager() ;
		httpClientConnectionManager.setMaxTotal(httpClientProperties.getMaxTotal());
		httpClientConnectionManager.setDefaultMaxPerRoute(httpClientProperties.getDefaultMaxPerRoute());
		return httpClientConnectionManager ;
	}
	
	@Bean
	public HttpClientBuilder getHttpClientBuilder(PoolingHttpClientConnectionManager httpClientConnectionManager) {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create() ;
		httpClientBuilder.setConnectionManager(httpClientConnectionManager) ;
		return httpClientBuilder ;
	}
	
	@Bean
	@Scope("prototype")
	public CloseableHttpClient getCloseableHttpClient(HttpClientBuilder httpClientBuilder) {
		return httpClientBuilder.build() ;
	}
	
	@Bean(destroyMethod="shutdown")
	public IdleConnectionEvictor getIdleConnectionEvictor(PoolingHttpClientConnectionManager httpClientConnectionManager) {
		return new IdleConnectionEvictor(httpClientConnectionManager) ;
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public Builder getBuilder() {
		RequestConfig.Builder builder = RequestConfig.custom() ;
		builder.setConnectTimeout(httpClientProperties.getConnectTimeout()) ;
		builder.setConnectionRequestTimeout(httpClientProperties.getConnectionRequestTimeout()) ;
		builder.setSocketTimeout(httpClientProperties.getSocketTimeout()) ;
		builder.setStaleConnectionCheckEnabled(httpClientProperties.isStaleConnectionCheckEnabled()) ;
		return builder ;
	}
	
	@Bean
	public RequestConfig getRequestConfig(Builder builder) {
		RequestConfig requestConfig = builder.build() ;
		return requestConfig ;
	}
}
