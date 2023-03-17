package com.iu.s1.product;

import java.util.List;

public class ProductDTO {
	private Long productNum;
	private String productName;
	private Long discount;
	private Long discountPercent;
	private Long productSales;
	private List<CategoryDTO> categorieDTOs;
	private List<ProductOptionDTO> productOptionDTOs;
	private List<ProductFileDTO> productFileDTOs;
	private String id;
	
	
	
	
	
	
	
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<CategoryDTO> getCategorieDTOs() {
		return categorieDTOs;
	}
	public void setCategorieDTOs(List<CategoryDTO> categorieDTOs) {
		this.categorieDTOs = categorieDTOs;
	}
	public List<ProductFileDTO> getProductFileDTOs() {
		return productFileDTOs;
	}
	public void setProductFileDTOs(List<ProductFileDTO> productFileDTOs) {
		this.productFileDTOs = productFileDTOs;
	}
	
	public List<ProductOptionDTO> getProductOptionDTOs() {
		return productOptionDTOs;
	}
	public void setProductOptionDTOs(List<ProductOptionDTO> productOptionDTOs) {
		this.productOptionDTOs = productOptionDTOs;
	}
	
	
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getDiscount() {
		return discount;
	}
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	
	public Long getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(Long discountPercent) {
		this.discountPercent = discountPercent;
	}
	public Long getProductSales() {
		return productSales;
	}
	public void setProductSales(Long productSales) {
		this.productSales = productSales;
	}
	
	
}
	
