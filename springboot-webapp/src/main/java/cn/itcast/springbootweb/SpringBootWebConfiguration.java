package cn.itcast.springbootweb;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * SpringBootWeb配置java配置
 * 总体配置
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SpringBootWebConfiguration extends WebMvcConfigurerAdapter {
	
	/*
	 * 强制转换编码
	 */
	/*@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter =new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}*/
}
