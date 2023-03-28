package com.iu.s1.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CartService {

	@Autowired
	private CartDAO cartDAO;
	
	public int setCartAdd(CartDTO cartDTO) throws Exception{
		
			int result=0;
//			int a =orderNum.length-1;
//			ProductOptionDTO productOptionDTO=new ProductOptionDTO();
//			productOptionDTO.setOptionNum(orderNum[a]);
//			Long aa=cartDAO.getCartPrice(productOptionDTO);
//			
//			System.out.println("aa :"+aa);
//			cartDTO.setPrice(aa);
//			
//			
//			for(Long or : orderNum) {
//				
//				cartDTO.setOptionNum(or);
//				result=cartDAO.setCartAdd(cartDTO);
//				
//				
//		}
		
		
		
		return result;//
	}
	public Long getCartPrice(CartDTO cartDTO) throws Exception{
		return cartDAO.getCartPrice(cartDTO);
	}
}
