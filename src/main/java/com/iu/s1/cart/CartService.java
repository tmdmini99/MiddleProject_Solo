package com.iu.s1.cart;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.product.ProductOptionDTO;
@Service
public class CartService {

	@Autowired
	private CartDAO cartDAO;
	
	public int setCartAdd(CartDTO cartDTO, Long [] orderNum) throws Exception{
		
			int result=0;
			int a =orderNum.length-1;
			ProductOptionDTO productOptionDTO=new ProductOptionDTO();
			productOptionDTO.setOptionNum(orderNum[a]);
			Long aa=cartDAO.getCartPrice(productOptionDTO);
			
			System.out.println("aa :"+aa);
			cartDTO.setPrice(aa);
			for(Long or : orderNum) {
				
				cartDTO.setOptionNum(or);
				result=cartDAO.setCartAdd(cartDTO);
				
				
		}
		
		
		return result;//
	}
}
