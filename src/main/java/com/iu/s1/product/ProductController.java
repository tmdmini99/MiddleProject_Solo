package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("productList")
	public ModelAndView lg() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<ProductDTO> ar = productService.getProductList();
		mv.addObject("dto", ar);
		mv.setViewName("./product/productList");
		
		return mv;
	}
	@GetMapping("productDetail")
	public ModelAndView getProductDetail(ProductDTO productDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		productDTO=productService.getProductDetail(productDTO);
		mv.addObject("dto", productDTO);
		mv.setViewName("./product/productDetail");
		return mv;
	}
}
