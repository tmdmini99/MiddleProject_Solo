package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("add")
	public ModelAndView setMemberAdd() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("./member/memberAdd");
		return mv;
	}
}
