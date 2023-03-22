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
		for(ProductOptionDTO productOptionDTO : productOptionDTOs) {
			ProductOptionDTO optionDTO=new ProductOptionDTO();


				productOptionDTO.setDepth(0L);
				productOptionDTO.setProductNum(productOptionDTO1.getProductNum());
				productOptionDTO.setProductPrice(0L);
				productOptionDTO.setProductStock(0L);
				productOptionDTO.setRef(0L);
				result = productDAO.setProductOptionAdd(productOptionDTO);
				System.out.println("Num :"+productOptionDTO.getOptionNum());
				optionDTO.setOptionNum(productOptionDTO.getOptionNum());
				System.out.println(optionDTO.getOptionNum());
				if(productOptionDTO.getSub() != null&&productOptionDTO.getSub().getOptionValues().length >0) {
					ProductOptionDTO dto = new ProductOptionDTO();
					dto.setOptionName(productOptionDTO.getSub().getOptionName());
					dto.setDepth(1L);
					dto.setProductStock(0L);
					dto.setProductPrice(0L);
					optionDTO=productDAO.getProductOptionNum(productOptionDTO);
					int c= 0;
					for(String s : productOptionDTO.getSub().getOptionValues()) {
						dto.setRef(optionDTO.getOptionNum());
						dto.setOptionValue(s);
						dto.setProductNum(productOptionDTO1.getProductNum());
						dto.setProductStock(0L);
						dto.setProductPrice(0L);
						result = productDAO.setProductOptionAdd(dto);
						if(c !=0) {
						optionDTO.setOptionNum(dto.getOptionNum());;
						c++;
						}
					}
					
					dto.setDepth(2L);
					dto.setOptionName(productOptionDTO.getSub().getSub().getOptionName());
					if(productOptionDTO.getSub().getSub() != null&&productOptionDTO.getSub().getSub().getOptionValues().length >0) {
						for(String y: productOptionDTO.getSub().getSub().getOptionValues()) {
							dto.setRef(optionDTO.getOptionNum());
							dto.setOptionValue(y);
							dto.setProductNum(productOptionDTO1.getProductNum());
							result = productDAO.setProductOptionAdd(dto);
							
						}
					}
					
				}
				
				
			
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
