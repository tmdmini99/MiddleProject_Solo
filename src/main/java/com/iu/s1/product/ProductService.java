package com.iu.s1.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private FileManager fileManager;
	
	public List<ProductDTO> getProductList(Pager pager) throws Exception{
		pager.makeRow();
		pager.makeNum(productDAO.getTotalCount(pager));
		return productDAO.getProductList();
	}
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		
		return productDAO.getProductDetail(productDTO);
	}
	public int setProductAdd(ProductDTO productDTO,Long [] categoryNums, MultipartFile [] files,HttpSession session)throws Exception{
		
		int result=productDAO.setProductAdd(productDTO);
		if(result>0) {
			CategoryDTO productCategoryDTO =new CategoryDTO();
			productCategoryDTO.setProductNum(productDTO.getProductNum());
			for(Long categoryNum : categoryNums) {
				productCategoryDTO.setCategoryNum(categoryNum);
				result =productDAO.setProductCategoryAdd(productCategoryDTO);
			}
			String realPath = session.getServletContext().getRealPath("/resources/upload/product/");
			for(MultipartFile file : files) {
				if(file.isEmpty()) {
					continue;
				}
				
				String name = fileManager.fileSave(realPath, file);
				ProductFileDTO productFileDTO = new ProductFileDTO();
				productFileDTO.setOriName(file.getOriginalFilename());
				productFileDTO.setFileName(name);
				productFileDTO.setProductNum(productDTO.getProductNum());
				result = productDAO.setProductFileAdd(productFileDTO);
				
			}
		}
		return result;
	}
	public int setProductOptionAdd(ProductOptionDTO[] productOptionDTOs,ProductOptionDTO productOptionDTO1)throws Exception{
		int result = 0;
		Long j=0L;
		Long k=0L;
		List<Long> h = new ArrayList<Long>();
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
				//첫번째 옵션
				if(productOptionDTO.getSub() != null) {
					Long a=productOptionDTO.getSub()[0].getSub()[0].getProductPrice();
					for(ProductOptionDTO dto : productOptionDTO.getSub()) {
						dto.setDepth(1L);
						
						dto.setProductPrice(0L);
						
						dto.setProductNum(productOptionDTO1.getProductNum());
						
							
							optionDTO.setOptionNum(productDAO.getProductOptionNum(productOptionDTO));
						
						dto.setRef(productOptionDTO.getOptionNum());
						result = productDAO.setProductOptionAdd(dto);
						
						
						
						//2번째 옵션
						if(dto.getSub() !=null) {
							for(ProductOptionDTO dto2 :dto.getSub()) {
								
								if(a>dto2.getProductPrice()) {
									a=dto2.getProductPrice();
									h.add(a);
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
					for(Long as : h) {
						if(a > as) {
							optionDTO.setProductPrice(as);
						}
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
	public List<ProductOptionDTO> getProductOptionList(ProductOptionDTO productOptionDTO) throws Exception{
		return productDAO.getProductOptionList(productOptionDTO);
	}
}
