package com.example.spring02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring02.model.dto.ProductDTO;

@RestController
public class SampleRestController {

	
	@ResponseBody //rESTCONTROLLER쓰면 생략가능(4.0부터 사용가능(
	@RequestMapping("test/doF")
	public ProductDTO doF() {
		return new ProductDTO("냉장고",400000); //데이터, 뷰가아님
	}
}
