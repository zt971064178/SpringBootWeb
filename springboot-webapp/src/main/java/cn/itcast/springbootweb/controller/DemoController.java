package cn.itcast.springbootweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.itcast.springbootweb.properties.HttpClientProperties;

/*
 * Demo测试
 */
@RestController
@RequestMapping("/spring/web/")
public class DemoController {
	
	@Autowired
	private HttpClientProperties httpClientProperties ;

	@RequestMapping(value="demo", method=RequestMethod.GET)
	public String demoTest() {
		JSONObject jsonObject = new JSONObject() ;
		jsonObject.put("username", "张田") ;
		jsonObject.put("address", "苏州金鸡湖大道国际科技园三期") ;
		jsonObject.put("other", "风云科技服务有限公司") ;
		
		return jsonObject.toJSONString() ;
	}
	
	@RequestMapping(value="prop", method=RequestMethod.GET)
	public String propTest() {
		return JSONObject.toJSONString(httpClientProperties) ;
	}
	
}
