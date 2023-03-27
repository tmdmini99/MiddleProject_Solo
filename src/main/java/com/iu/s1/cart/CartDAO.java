package com.iu.s1.cart;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CartDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.cart.cartDAO.";
	
	public int setCartAdd(ProductOrderDTO productOrderDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setCartAdd", productOrderDTO);
	}
}
