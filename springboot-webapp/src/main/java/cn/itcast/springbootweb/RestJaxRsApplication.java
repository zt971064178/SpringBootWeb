package cn.itcast.springbootweb;

import java.util.HashSet;
import java.util.Set;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class RestJaxRsApplication extends ResourceConfig {
	public RestJaxRsApplication() {
	  // 向jersey框架注册资源类，凡完全限定名是以指定字符串开头的类，都将包含  全能型
	  packages("cn.itcast.springbootweb.jeresy.server");  

	  // 注册DemoServer 上面的包扫描可以将其包含
	  // register(DemoServer.class);
	  register(JacksonFeature.class);  
      // register(RequestContextFilter.class);
      //注册数据转换器 
      // register(JacksonJsonProvider.class); 
      // Logging
      register(LoggingFilter.class); 

      // swagger  
     Set<Class<?>> resources = new HashSet<>();  
     resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);  
     resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);  
     registerClasses(resources);  
	}
}
