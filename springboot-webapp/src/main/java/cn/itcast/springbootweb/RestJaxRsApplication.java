package cn.itcast.springbootweb;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import cn.itcast.springbootweb.jeresy.server.DemoServer;

public class RestJaxRsApplication extends ResourceConfig {
	public RestJaxRsApplication() {
	  // 注册DemoServer
	  register(DemoServer.class);
      register(RequestContextFilter.class);
      //注册数据转换器 
      register(JacksonJsonProvider.class); 
      // Logging. 
      register(LoggingFilter.class); 
      
      //register(CORSResponseFilter.class);
      //register(JacksonFeature.class);

	}
}
