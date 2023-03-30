package com.iu.s1.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Jsr330ScopeMetadataResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iu.s1.member.MemberDTO;
import com.iu.s1.util.Pager;

import oracle.net.aso.j;

@Controller
@RequestMapping(value="/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("productList")
	public ModelAndView lg(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<ProductDTO> ar = productService.getProductList(pager);
		mv.addObject("dto", ar);
		mv.setViewName("./product/productList");
		
		return mv;
	}
	@GetMapping("productDetail")
	public ModelAndView getProductDetail(ProductDTO productDTO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		productDTO=productService.getProductDetail(productDTO);
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		MemberDTO memberDTO2 = new MemberDTO();
		memberDTO2.setId("d");
		Long a = productService.getCartCount(memberDTO2);
		System.out.println("a : "+a);
		if( a == null) {
			a = 0L;
		}
		List<ProductOptionDTO> ar = productService.getProductOptionListDelete(productDTO);
		mv.addObject("dto", productDTO);
		mv.addObject("dto2", a);
		mv.addObject("dto3", ar);
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
	public ModelAndView setProductAdd(ProductDTO productDTO,Long [] categoryNum,MultipartFile [] files,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = productService.setProductAdd(productDTO,categoryNum,files,session);
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
	@PostMapping("productOptionList")
	public ModelAndView getProductOptionList(ProductOptionDTO productOptionDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<ProductOptionDTO> ar = productService.getProductOptionList(productOptionDTO);
		
		mv.addObject("list", ar);
		mv.setViewName("common/productOptionList");
		return mv;
	}
	@PostMapping("productDelete")
	public ModelAndView setProductDelete(Long productNum) throws Exception{
		ModelAndView mv = new ModelAndView();
		productService.setProductDelete(productNum);
		mv.setViewName("redirect:./productList");
		return mv;
	}
	@GetMapping("productUpdate")
	public ModelAndView setProductUpdate(ProductDTO productDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		productDTO=productService.getProductDetail(productDTO);
	
		mv.addObject("dto", productDTO);
		mv.setViewName("./product/productUpdate");
		return mv;
	}
	//beforeCategoryNums는 예전 categoryNum
	@PostMapping("productUpdate")
	public ModelAndView setProductUpdate(ProductDTO productDTO,MultipartFile [] files,HttpSession session,Long [] categoryNum) throws Exception{
		ModelAndView mv = new ModelAndView();
		int a = productService.setProductUpdate(productDTO, files, session,categoryNum);
		
		mv.setViewName("redirect:./productList");
		return mv;
	}
	@GetMapping("productOptionDelete")
	public ModelAndView setProductOptionDelete(ProductDTO productDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	@PostMapping("productOptionDelete")
	public ModelAndView setProductOptionDelete(Long [] optionNum, Long productNum) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("productNum :"+productNum);
		productService.setProductOptionDelete(optionNum);
		mv.setViewName("redirect:./productDetail?productNum="+productNum);
		return mv;
	}
	@PostMapping("productFileDelete")
	public ModelAndView setProductFileDelete(Long fileNum) throws Exception{
		ModelAndView mv = new ModelAndView();
		int a = productService.setProductFileDelete(fileNum);
		
		mv.addObject("dto", a);
		mv.setViewName("/common/ajaxResult");
		return mv;
	}
	
}
