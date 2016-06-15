package cn.itcast.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * SpringBootWeb配置java配置
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SpringBootWebConfiguration extends WebMvcConfigurerAdapter {

}
