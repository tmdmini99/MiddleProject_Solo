package com.iu.s1.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberJoin")
	public ModelAndView setMemberAdd() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("./member/memberJoin");
		return mv;
	}
	
	@PostMapping("memberJoin")
	public ModelAndView setMemberAdd(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memberService.setMemberJoin(memberDTO);
		
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping("memberDetail")
	public ModelAndView getMemberDetail(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO=new MemberDTO();
		memberDTO=(MemberDTO)session.getAttribute("member");
		System.out.println(memberDTO.getId());
		memberDTO=memberService.getMemberDetail(memberDTO);
		
		mv.addObject("dto", memberDTO);
		mv.setViewName("./member/memberDetail");
		return mv;
	}
	@GetMapping("memberLogin")
	public ModelAndView getMemberLogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("./member/memberLogin");
		return mv;
	}
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberDTO memberDTO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO=memberService.getMemberLogin(memberDTO);
		System.out.println(memberDTO.getId());
		session.setAttribute("member", memberDTO);
		mv.setViewName("redirect:../");
		return mv;
	}
	@GetMapping("memberUpdate")
	public ModelAndView setMemberUpdate(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO=new MemberDTO();
		memberDTO=(MemberDTO)session.getAttribute("member");
		memberDTO=memberService.getMemberDetail(memberDTO);
		
		mv.addObject("dto", memberDTO);
		mv.setViewName("./member/memberUpdate");
		return mv;
	}
	@PostMapping("memberUpdate")
	public ModelAndView setMemberUpdate(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO=memberService.getMemberDetail(memberDTO);
		
		mv.addObject("dto", memberDTO);
		mv.setViewName("redirect:./memberDetail");
		return mv;
	}
	
}
