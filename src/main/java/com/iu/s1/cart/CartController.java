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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//db에 저장
	@PostMapping("cartAdd")
	public ModelAndView setCartAdd(Long [] count,Long [] optionNum,CartDTO cartDTO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();


		MemberDTO memberDTOs= new MemberDTO();
		memberDTOs.setId("d");
		//session의 ID값이 들어가야함
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		cartDTO.setId(memberDTOs.getId());

		cartService.setCartAdd(cartDTO,optionNum,count);
		Long a = cartService.getCartCount(memberDTOs);
		
		mv.addObject("dto", a);
		mv.setViewName("/common/sessionList");
		

		return mv;
	}
	
	@GetMapping("cartList")
	public ModelAndView getCartList(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTOs= new MemberDTO();
		memberDTOs.setId("d");
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		List<CartDTO> ar = cartService.getCartList(memberDTOs);
		mv.addObject("cartAdd", ar);
		mv.setViewName("./cart/cartListDB");
		return mv;
	}
	@PostMapping("cartDelete")
	public ModelAndView setCartDelete(Long num, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int a=cartService.setCartDelete(num);
		
			MemberDTO memberDTOs= new MemberDTO();
			memberDTOs.setId("d");
			MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
			List<CartDTO> ar = cartService.getCartList(memberDTOs);
			mv.addObject("cartAdd", ar);
		
		
		mv.setViewName("./common/cartDB");
		return mv;
	}
	@PostMapping("cartDeletes")
	public ModelAndView setCartDeletes(Long [] nums, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int a = cartService.setCartDeletes(nums);
		MemberDTO memberDTOs= new MemberDTO();
		memberDTOs.setId("d");
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		List<CartDTO> ar = cartService.getCartList(memberDTOs);
		
		mv.addObject("cartAdd", ar);
		mv.setViewName("./common/cartDB");
		return mv;
	}
	@PostMapping("cartUpdate")
	public ModelAndView setCartUpdate(CartDTO cartDTO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		MemberDTO memberDTOs= new MemberDTO();
		memberDTOs.setId("d");
		
		
		int a =cartService.setCartUpdate(cartDTO);
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		List<CartDTO> ar = cartService.getCartList(memberDTOs);
		mv.addObject("cartAdd", ar);
		mv.setViewName("./common/cartDB");
		return mv;
	}
	
	@GetMapping("cartOrder")
	public ModelAndView setCartBuy(Long [] nums,Long [] optinNums,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		MemberDTO memberDTOs= new MemberDTO();
		memberDTOs.setId("d");
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		List<CartDTO> ar = cartService.getCartOrderList(nums);
		System.out.println(ar.get(0).getCount());
		Long total = 0L;
		for(int i=0;i<ar.size();i++) {
			total +=(ar.get(i).getCount()*ar.get(i).getPrice());
		}
		mv.addObject("total", total);
		mv.addObject("list", ar);
		mv.setViewName("./cart/cartOrder");
		
		
		return mv;
	}
	
	@PostMapping("cartOrder")
	public ModelAndView setCartBuy(Long [] nums, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		MemberDTO memberDTOs= new MemberDTO();
		memberDTOs.setId("d");
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		 int result=cartService.setProductOrderAdd(nums);
		
		mv.addObject("dto", result);
		mv.setViewName("common/sessionList");
		return mv;
	}
	@PostMapping("cartM")
	public ModelAndView setCartM(CartDTO cartDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int a =cartService.setCartUpdate(cartDTO);
		
		mv.setViewName("common/sessionList");
		return mv;
	}
	@PostMapping("cartP")
	public ModelAndView setCartP(CartDTO cartDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		
		
		int a =cartService.setCartUpdate(cartDTO);
		mv.setViewName("common/sessionList");
		return mv;
	}
	
	
	
	//------------------------------------------------------------------------------------------
	//session에 저장
	
	
	
//	@PostMapping("cartAdd")
//	@SuppressWarnings("unchecked")
//	public ModelAndView setCartAdd(Long [] count,Long [] optionNum,CartDTO cartDTO,HttpSession session) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		
//		
//		MemberDTO memberDTOs= new MemberDTO();
//		memberDTOs.setId("d");
//		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
//		List<CartDTO> ar;
//		if(session.getAttribute("cartAdd") !=null) {
//		ar = (List<CartDTO>)session.getAttribute("cartAdd");
//		}else {
//			ar= new ArrayList<CartDTO>();
//		}
//		
//		
//		
//		cartDTO.setId(memberDTOs.getId());
//		for(int i=0; i<count.length; i++) {
//			cartDTO.setCount(count[i]);
//			cartDTO.setOptionNum(optionNum[i]);
//			cartDTO.setPrice(cartService.getCartPrice(cartDTO)*cartDTO.getCount());
//			ar.add(cartDTO);
//		}
//		
//		session.setAttribute("cartAdd", ar);
//		
//		
//		
//		//cartService.setCartAdd(cartDTO);
//		
//		mv.addObject("dto", ar.size());
//		mv.setViewName("/common/sessionList");
//		
//		return mv;
//	}
//	@GetMapping("cartList")
//	public ModelAndView getCartList() throws Exception{
//		ModelAndView mv = new ModelAndView();
//		
//		mv.setViewName("./cart/cartList");
//		return mv;
//	}
	
//	@PostMapping("cartDelete")
//	//session 안에 CartDTO list가 들어가지는 불분명할때 나오는 경고를 지워주는 Annotation
//	@SuppressWarnings("unchecked")
//	public ModelAndView setCartDelete(int index, HttpSession session) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		
//		List<CartDTO> ar = (List<CartDTO>)session.getAttribute("cartAdd");
//		for(int i=0; i<ar.size();i++) {
//			System.out.println(ar.get(i).getCount());
//			System.out.println("index : "+index);
//		}
//		ar.remove(index);
//		session.setAttribute("cartAdd", ar);
//		mv.setViewName("./common/cart");
//		return mv;
//	}
//	@PostMapping("cartDeletes")
//	//session 안에 CartDTO list가 들어가지는 불분명할때 나오는 경고를 지워주는 Annotation
//	@SuppressWarnings("unchecked")
//	public ModelAndView setCartDeletes(int [] index, HttpSession session) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		
//		List<CartDTO> ar = (List<CartDTO>)session.getAttribute("cartAdd");
//		for(int i=0; i<ar.size();i++) {
//			System.out.println(ar.get(i).getCount());
//			System.out.println("index : "+index);
//		}
//		for(int i : index) {
//			ar.remove(i);
//		}
//		session.setAttribute("cartAdd", ar);
//		mv.setViewName("./common/cart");
//		return mv;
//	}
}
