package com.iu.s1.product;

import java.util.List;

public class ProductDTO {
	private Long productNum;
	private String productName;
	private Long discount;
	private Long dicountPercent;
	private Long productSales;
	private Long categoryNum;
	private List<ProductOptionDTO> productOptionDTOs;
	private List<ProductFileDTO> productFileDTOs;
	
	
	
	
	
	
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
	public Long getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(Long categoryNum) {
		this.categoryNum = categoryNum;
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
	public Long getDicountPercent() {
		return dicountPercent;
	}
	public void setDicountPercent(Long dicountPercent) {
		this.dicountPercent = dicountPercent;
	}
	public Long getProductSales() {
		return productSales;
	}
	public void setProductSales(Long productSales) {
		this.productSales = productSales;
	}
	
	
}
	
