package cn.itcast.springbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

/*
 * Demo测试
 */
@RestController
@RequestMapping("/spring/web/")
public class DemoController {

	@RequestMapping(value="demo", method=RequestMethod.GET)
	public String demoTest() {
		JSONObject jsonObject = new JSONObject() ;
		jsonObject.put("username", "张田") ;
		jsonObject.put("address", "苏州金鸡湖大道国际科技园三期") ;
		jsonObject.put("other", "风云科技服务有限公司") ;
		
		return jsonObject.toJSONString() ;
	}
	
}
