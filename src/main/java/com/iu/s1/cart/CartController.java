package com.iu.s1.cart;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.member.MemberDTO;

@Controller
@RequestMapping(value = "/cart/*")
public class CartController {
	
	
	
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("cartAdd")
	public ModelAndView setCartAdd(Long [] orderNum,CartDTO cartDTO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		
		MemberDTO memberDTOs= new MemberDTO();
		memberDTOs.setId("d");
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		cartDTO.setId(memberDTOs.getId());
		
		cartService.setCartAdd(cartDTO,orderNum);
		
		
		mv.setViewName("../product/list");
		
		return mv;
	}
}
