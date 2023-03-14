package com.iu.s1.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/product/*")
public class ProductController {
	
	@GetMapping("productList")
	public ModelAndView lg() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("./product/productList");
		
		return mv;
	}
}
