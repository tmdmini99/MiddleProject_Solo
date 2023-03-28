package com.iu.s1.cart;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	@SuppressWarnings("unchecked")
	public ModelAndView setCartAdd(Long [] count,Long [] optionNum,CartDTO cartDTO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		
		MemberDTO memberDTOs= new MemberDTO();
		memberDTOs.setId("d");
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		List<CartDTO> ar;
		if(session.getAttribute("cartAdd") !=null) {
		ar = (List<CartDTO>)session.getAttribute("cartAdd");
		}else {
			ar= new ArrayList<CartDTO>();
		}
		
		
		
		cartDTO.setId(memberDTOs.getId());
		for(int i=0; i<count.length; i++) {
			cartDTO.setCount(count[i]);
			cartDTO.setOptionNum(optionNum[i]);
			cartDTO.setPrice(cartService.getCartPrice(cartDTO)*cartDTO.getCount());
			ar.add(cartDTO);
		}
		
		session.setAttribute("cartAdd", ar);
		
		
		
		//cartService.setCartAdd(cartDTO);
		
		
		mv.setViewName("../product/list");
		
		return mv;
	}
	@GetMapping("cartList")
	public ModelAndView getCartList() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("./cart/cartList");
		return mv;
	}
	
	@PostMapping("cartDelete")
	//session 안에 CartDTO list가 들어가지는 불분명할때 나오는 경고를 지워주는 Annotation
	@SuppressWarnings("unchecked")
	public ModelAndView setCartDelete(int index, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<CartDTO> ar = (List<CartDTO>)session.getAttribute("cartAdd");
		for(int i=0; i<ar.size();i++) {
			System.out.println(ar.get(i).getCount());
			System.out.println("index : "+index);
		}
		ar.remove(index);
		session.setAttribute("cartAdd", ar);
		mv.setViewName("./common/cart");
		return mv;
	}
}
