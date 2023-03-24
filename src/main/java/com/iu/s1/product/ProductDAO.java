package com.iu.s1.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.Pager;
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
	public int setProductOptionAdd(ProductOptionDTO productOptionDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setProductOptionAdd", productOptionDTO);
	}
	public int setProductAdd(ProductDTO productDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setProductAdd", productDTO);
	}
	public int setProductCategoryAdd(CategoryDTO productCategoryDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setProductCategoryAdd", productCategoryDTO);
	}
	public Long getProductOptionNum(ProductOptionDTO productOptionDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getProductOptionNum", productOptionDTO);
	}
	public int setProductOptionUpdate(ProductOptionDTO productOptionDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setProductOptionUpdate", productOptionDTO);
	}
	
	public int setProductOptionRefUpdate(ProductOptionDTO productOptionDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setProductOptionRefUpdate", productOptionDTO);
	}
	public int setProductFileAdd(ProductFileDTO productFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setProductFileAdd", productFileDTO);
	}
	public List<ProductOptionDTO> getProductOptionList(ProductOptionDTO productOptionDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getProductOptionList", productOptionDTO);
	}
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
	}
 }
