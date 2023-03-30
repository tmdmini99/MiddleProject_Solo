package com.iu.s1.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.member.MemberDTO;
import com.iu.s1.product.ProductOptionDTO;
@Service
public class CartService {

	@Autowired
	private CartDAO cartDAO;
	
	public int setCartAdd(CartDTO cartDTO,Long [] orderNum,Long [] count) throws Exception{
		
			int result=0;
			int a =orderNum.length-1;
			
			Long aa=cartDAO.getCartPrice(cartDTO);
			
			for(int i=0; i<count.length; i++) {
				
				cartDTO.setOptionNum(orderNum[i]);
				cartDTO.setPrice(aa);
				result = cartDAO.setCartAdd(cartDTO);
				
		}
		
		
		
		return result;
	}
	public Long getCartPrice(CartDTO cartDTO) throws Exception{
		return cartDAO.getCartPrice(cartDTO);
	}
	public Long getCartCount(MemberDTO memberDTO) throws Exception{
		return cartDAO.getCartCount(memberDTO);
	}
	public List<CartDTO> getCartList(MemberDTO memberDTO) throws Exception{
		return cartDAO.getCartList(memberDTO);
	}
	public int setCartDelete(Long num) throws Exception{
		return cartDAO.setCartDelete(num);
	}
	public int setCartDeletes(Long [] nums) throws Exception{
		int result =0;
		for(Long num : nums) {
			result = cartDAO.setCartDelete(num);
		}
		
		
		return result;
	}
	public int setCartUpdate(CartDTO cartDTO) throws Exception{
		return cartDAO.setCartUpdate(cartDTO);
	}
}
