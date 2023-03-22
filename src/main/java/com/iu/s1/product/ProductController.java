package com.iu.s1.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Jsr330ScopeMetadataResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import oracle.net.aso.j;

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
	
	@GetMapping("productAdd")
	public ModelAndView setProductAdd()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("./product/productAdd");
		return mv;
	}
	
	@PostMapping("productAdd")
	public ModelAndView setProductAdd(ProductDTO productDTO,Long [] categoryNum)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = productService.setProductAdd(productDTO,categoryNum);
		mv.setViewName("redirect:./productList");
		return mv;
	}
	@GetMapping("productOptionAdd")
	public ModelAndView setProductOptionAdd(ProductDTO productDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", productDTO);
		mv.setViewName("./product/productOptionAdd");
		return mv;
	}
	
	@PostMapping("productOptionAdd")
	public ModelAndView setProductOptionAdd(ProductOptionDTO productOptionDTO,HttpServletRequest request)throws Exception{
		ModelAndView mv = new ModelAndView();
		String json1 = request.getParameter("json1");
		System.out.println(json1);
		Gson gson = new Gson();
		ProductOptionDTO [] productOptionDTOs =gson.fromJson(json1, ProductOptionDTO[].class);
		System.out.println(productOptionDTO.getProductNum());
		int result = 0;
		if(productOptionDTOs != null) {
			result=productService.setProductOptionAdd(productOptionDTOs,productOptionDTO);
		}
//		ProductOptionDTO [] productOptionDTOs =gson.fromJson(json1, ProductOptionDTO[].class);
//		if(productOptionDTOs != null) {
//		for(ProductOptionDTO productOptionDTO : productOptionDTOs) {
//			System.out.println(productOptionDTO.getOptionName());
//			System.out.println(productOptionDTO.getOptionValue());
//		}
//		}
		//int result = productService.setProductOptionAdd(productDTO);
		mv.setViewName("redirect:./productList");
		return mv;
	}
}
