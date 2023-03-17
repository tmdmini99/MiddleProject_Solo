package com.iu.s1.product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getProductList() throws Exception{
		return productDAO.getProductList();
	}
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		return productDAO.getProductDetail(productDTO);
	}
	public int setProductAdd(ProductDTO productDTO,Long [] categoryNums)throws Exception{
		
		int result=productDAO.setProductAdd(productDTO);
		if(result>0) {
			CategoryDTO productCategoryDTO =new CategoryDTO();
			productCategoryDTO.setProductNum(productDTO.getProductNum());
			for(Long categoryNum : categoryNums) {
				productCategoryDTO.setCategoryNum(categoryNum);
				result =productDAO.setProductCategoryAdd(productCategoryDTO);
			}
		}
		return result;
	}
	public int setProductOptionAdd(ProductDTO productDTO)throws Exception{
		return productDAO.setProductOptionAdd(productDTO);
	}
}
