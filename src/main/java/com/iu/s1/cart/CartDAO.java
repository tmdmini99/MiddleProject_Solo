package com.iu.s1.cart;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.product.ProductOptionDTO;
@Repository
public class CartDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.cart.cartDAO.";
	
	public int setCartAdd(CartDTO cartDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setCartAdd", cartDTO);
	}
	public Long getCartPrice(CartDTO cartDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCartPrice", cartDTO);
	}
}
