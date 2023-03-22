package com.iu.s1.product;

public class ProductOptionDTO {
	private Long optionNum;
	private Long productNum;
	private String optionName;
	private String optionValue;
	private Long productPrice;
	private Long productStock;
	private Long ref;
	private Long depth;
	private Long step;
	private ProductOptionDTO sub;
	private String [] optionValues;
	
	
	
	
	
	
	public String[] getOptionValues() {
		return optionValues;
	}
	public void setOptionValues(String[] optionValues) {
		this.optionValues = optionValues;
	}
	
	public ProductOptionDTO getSub() {
		return sub;
	}
	public void setSub(ProductOptionDTO sub) {
		this.sub = sub;
	}
	public Long getRef() {
		return ref;
	}
	public void setRef(Long ref) {
		this.ref = ref;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	public Long getStep() {
		return step;
	}
	public void setStep(Long step) {
		this.step = step;
	}
	public String getOptionValue() {
		return optionValue;
	}
	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}
	public Long getOptionNum() {
		return optionNum;
	}
	public void setOptionNum(Long optionNum) {
		this.optionNum = optionNum;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public Long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}
	public Long getProductStock() {
		return productStock;
	}
	public void setProductStock(Long productStock) {
		this.productStock = productStock;
	}
	
	
}
