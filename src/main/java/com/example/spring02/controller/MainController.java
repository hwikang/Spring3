package com.example.spring02.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.dto.ProductDTO;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	
	@RequestMapping("/")
	public String main(Model model) { //메소드이름 상관없음
		//데이터저장역할, MAP 구조임, (변수명,값)
		model.addAttribute("message","hello welcome to my page");
		return "main";
	}
	
	@RequestMapping(value="gugu.do" , method=RequestMethod.GET)
	public String gugu(@RequestParam(defaultValue="3") int dan, Model model) { 
		//dan parameter 변수똑같이하면 들어옴 , requestParam 을 뺴도 실행은됨
		
		String result="";
		for(int i =1; i<=9; i++) {
			result += dan + "x" +i + "=" +dan*i+ "<br/>";
		}
		model.addAttribute("result",result);
		return "test/gugu";
	
	}
	//이름 똑같으면 .do 안해도됨 리턴타입 void해도딤 test.jsp 를 찾음
	@RequestMapping(value="test")
	public void test() {
		
	}
	
	@RequestMapping(value="test/doA")
	public String doA(Model model) {
		logger.info("doA called");
		model.addAttribute("message", "hello DoA");
		return "test/doB";
	}
	
	@RequestMapping(value="test/doB")
	public void test2() {
		logger.info("doB called...");
	}
	
	@RequestMapping(value="test/doC")
	public ModelAndView doC() {
		//
		logger.info("doC called...");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("product", new ProductDTO("샤프",1000)); //map 안에 product 넣음
		
		return new ModelAndView("test/doC","map",map);
		//하나밖에 못보냄, doC 로가고 변수이름map 임
		
		
	}
	
	@RequestMapping(value="test/doD")
	public String doD() {
		//
		logger.info("doD called...");
		
		return "redirect:/test/doE";
		//doE로보냄 , JSP 팽페이지로 보내징낳음 , doD 로가는게아니라 doE 로감 , doA 는 A로가지만 B르 보여주는거임
		
	}
	
	@RequestMapping(value="test/doE")
	public void doE() {
		//
		logger.info("doE called...");		
	}
	
	
	
	
	
	
	
}
