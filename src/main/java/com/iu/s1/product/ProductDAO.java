package com.iu.s1.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.product.ProductDAO.";
	
	public List<ProductDTO> getProductList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getProductList");
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getProductDetail", productDTO);
	}
	public int setProductOptionAdd(ProductDTO productDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"ProductDTO productDTO", productDTO);
	}
	public int setProductAdd(ProductDTO productDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setProductAdd", productDTO);
	}
	public int setProductCategoryAdd(CategoryDTO productCategoryDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setProductCategoryAdd", productCategoryDTO);
	}
 }
