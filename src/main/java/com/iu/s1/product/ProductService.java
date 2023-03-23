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
	public int setProductOptionAdd(ProductOptionDTO[] productOptionDTOs,ProductOptionDTO productOptionDTO1)throws Exception{
		int result = 0;
		Long j=0L;
		Long k=0L;
		Long h;
		for(ProductOptionDTO productOptionDTO : productOptionDTOs) {
			ProductOptionDTO optionDTO=new ProductOptionDTO();


				productOptionDTO.setDepth(0L);
				productOptionDTO.setProductNum(productOptionDTO1.getProductNum());
				productOptionDTO.setProductPrice(0L);
				
				productOptionDTO.setRef(0L);
				result = productDAO.setProductOptionAdd(productOptionDTO);
				System.out.println("Num :"+productOptionDTO.getOptionNum());
				optionDTO.setOptionNum(productOptionDTO.getOptionNum());
				System.out.println("Num2 :"+optionDTO.getOptionNum());
				System.out.println(productOptionDTO.getOptionValue());
				if(productOptionDTO.getSub() != null) {
					for(ProductOptionDTO dto : productOptionDTO.getSub()) {
						dto.setDepth(1L);
						
						dto.setProductPrice(0L);
						
						dto.setProductNum(productOptionDTO1.getProductNum());
						optionDTO.setOptionNum(productDAO.getProductOptionNum(productOptionDTO));
						dto.setRef(productOptionDTO.getOptionNum());
						result = productDAO.setProductOptionAdd(dto);
						
						Long a=dto.getSub()[0].getProductPrice();
						if(dto.getSub() !=null) {
							for(ProductOptionDTO dto2 :dto.getSub()) {
								
								if(a>dto2.getProductPrice()) {
									a=dto2.getProductPrice();
								}
								optionDTO.setOptionNum(productDAO.getProductOptionNum(dto));
								dto2.setProductNum(productOptionDTO1.getProductNum());
								dto2.setDepth(2L);
								
								dto2.setRef(dto.getOptionNum());
								optionDTO.setRef(dto2.getRef());
								result = productDAO.setProductOptionAdd(dto2);
							}
						}
						optionDTO.setProductPrice(a);
						
						productDAO.setProductOptionUpdate(optionDTO);
						optionDTO.setRef(dto.getRef());
						
					}
					
				}
				productDAO.setProductOptionUpdate(optionDTO);
				
				
				
			
//				else if(optionDTO.getDepth() ==0){
//				productOptionDTO.setRef(optionDTO.getOptionNum());
//				productOptionDTO.setDepth(optionDTO.getDepth()+1);
//				
//			}else {
//				productOptionDTO.setRef(optionDTO.getOptionNum());
//				productOptionDTO.setDepth(optionDTO.getDepth()+1);
//				
//			}
			
			
		}
		return result;
	}
}
