package cn.itcast.springbootweb;

import java.util.HashSet;
import java.util.Set;

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
      //register(JacksonJsonProvider.class); 
      // Logging. 
      //register(LoggingFilter.class); 
      
      register(CORSResponseFilter.class);
      register(JacksonFeature.class);
      
    //swagger  
     Set<Class<?>> resources = new HashSet<>();  
     resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);  
     resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);  
     registerClasses(resources);  

	}
}
