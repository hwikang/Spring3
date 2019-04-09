package com.example.spring02.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring02.model.dto.MemberDTO;
import com.example.spring02.service.MemberService;

@Controller //현재클래스를 controller bean으로 등록
public class MemberController {

	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//콘트롤러는 서비스호출
	//서비스는 dao호출
	//dao 는 mybatis mapper 호출
	@Inject
	MemberService memberService;
	
	@RequestMapping("member/list.do")
	public String memberList(Model model) {
		
		List<MemberDTO> list = memberService.memberList();
		logger.info("회원목록="+list);
		model.addAttribute("list",list);
		
		return "member/member_list";
	}
	@RequestMapping("member/write.do")
	public String write(){
		return "member/write";
	}
	
	@RequestMapping("member/insert.do")
	public String insert(@ModelAttribute MemberDTO dto) {  
		//form에서 받은 값을 을 dto에 다 넣어준다.  modelattribute 생략가능
		//단 dto변수와 이름이 같아야한다.
		memberService.insertMember(dto);
		return "redirect:/member/list.do";  //불러와서 리다이렉트함
	}
}
