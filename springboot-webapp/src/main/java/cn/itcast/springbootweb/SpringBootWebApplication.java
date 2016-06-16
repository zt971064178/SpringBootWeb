package cn.itcast.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * 启动入口
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
// 发布war包继承
public class SpringBootWebApplication extends SpringBootServletInitializer {
	// 重写configure方法
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootWebApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args) ;
	}
}
