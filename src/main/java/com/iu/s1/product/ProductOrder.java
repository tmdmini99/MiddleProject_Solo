package com.iu.s1.product;

import oracle.sql.DATE;

public class ProductOrder {
	private Long orderNum;
	private Long productNum;
	private String id;
	private Long totalPrice;
	private Long productEa;
	private DATE orderDate;
	private Long buyCheck;
	private Long payMentCheck;
	public Long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Long getProductEa() {
		return productEa;
	}
	public void setProductEa(Long productEa) {
		this.productEa = productEa;
	}
	public DATE getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(DATE orderDate) {
		this.orderDate = orderDate;
	}
	public Long getBuyCheck() {
		return buyCheck;
	}
	public void setBuyCheck(Long buyCheck) {
		this.buyCheck = buyCheck;
	}
	public Long getPayMentCheck() {
		return payMentCheck;
	}
	public void setPayMentCheck(Long payMentCheck) {
		this.payMentCheck = payMentCheck;
	}
	
	
}
