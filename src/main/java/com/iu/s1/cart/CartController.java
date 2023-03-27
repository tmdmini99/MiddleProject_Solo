package com.iu.s1.cart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/cart/*")
public class CartController {
	
	
	
	//List<Cookie> ar;
	
	
	@PostMapping("cartAdd")
	public ModelAndView setCartAdd(Long [] orderNum,ProductOrderDTO productOrderDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		Cookie [] cookies = new Cookie[orderNum.length];
		
		return mv;
	}
}
