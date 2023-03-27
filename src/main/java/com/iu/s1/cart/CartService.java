package com.iu.s1.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CartService {

	@Autowired
	private CartDAO cartDAO;
	
	public int setCartAdd(ProductOrderDTO productOrderDTO) throws Exception{
		return cartDAO.setCartAdd(productOrderDTO);
	}
}
