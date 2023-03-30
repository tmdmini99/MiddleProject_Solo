package com.iu.s1.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.member.MemberDTO;
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
	public Long getCartCount(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCartCount",memberDTO);
	}
	
	public List<CartDTO> getCartList(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getCartList", memberDTO);
	}
	//매개변수의 변수명을 Mapper의 변수명으로 그대로 적어야 받을수 있음
	public int setCartDelete(Long num) throws Exception{
		return sqlSession.delete(NAMESPACE+"setCartDelete", num);
	}
	public int setCartUpdate(CartDTO cartDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setCartUpdate", cartDTO);
	}
	public String setCartOptionName(Long optionNum) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"setCartOptionName", optionNum);
	}
	public Long setCartOptionRef(Long optionNum) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"setCartOptionRef", optionNum);
	}
}
