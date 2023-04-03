package com.iu.s1.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.member.MemberDTO;
import com.iu.s1.product.ProductDAO;
import com.iu.s1.product.ProductOptionDTO;
@Service
public class CartService {

	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private ProductDAO productDAO;
	
	public int setCartAdd(CartDTO cartDTO,Long [] orderNum,Long [] count) throws Exception{
		
			int result=0;
			int a =orderNum.length-1;
			
			Long aa=cartDAO.getCartPrice(cartDTO);
			
			for(int i=0; i<count.length; i++) {
				
				cartDTO.setOptionNum(orderNum[i]);
				cartDTO.setPrice(aa);
				result = cartDAO.setCartAdd(cartDTO);
				
		}
		
		
		
		return result;
	}
	public Long getCartPrice(CartDTO cartDTO) throws Exception{
		return cartDAO.getCartPrice(cartDTO);
	}
	public Long getCartCount(MemberDTO memberDTO) throws Exception{
		return cartDAO.getCartCount(memberDTO);
	}
	public List<CartDTO> getCartList(MemberDTO memberDTO) throws Exception{
		List<CartDTO> arr = cartDAO.getCartList(memberDTO);
		int result=0;
		for(int i =0; i<arr.size(); i++) {
			System.out.println("optionNum :"+arr.get(i).getOptionNum());
			
			Long num = cartDAO.setCartOptionRef(arr.get(i).getOptionNum());
			System.out.println("optionNum2 :"+num);
			String name=cartDAO.setCartOptionName(arr.get(i).getOptionNum());
			System.out.println("name1 :"+name);
			name=cartDAO.setCartOptionName(num)+"-"+name;
			num=cartDAO.setCartOptionRef(num);
			System.out.println("name2 :"+name);
			name=cartDAO.setCartOptionName(num)+"-"+name;
			num=cartDAO.setCartOptionRef(num);
			System.out.println("name3 :"+name);
			arr.get(i).setOptionName(name);
		}
		
		return arr;
	}
	public int setCartDelete(Long num) throws Exception{
		return cartDAO.setCartDelete(num);
	}
	public int setCartDeletes(Long [] nums) throws Exception{
		int result =0;
		for(Long num : nums) {
			result = cartDAO.setCartDelete(num);
		}
		
		
		return result;
	}
	public int setCartUpdate(CartDTO cartDTO) throws Exception{
		return cartDAO.setCartUpdate(cartDTO);
	}
	public List<CartDTO> getCartOrderList(Long [] nums) throws Exception{
		List<CartDTO> ar = new ArrayList<CartDTO>();
		for(Long num : nums){
			ar.add(cartDAO.getCartOrderList(num));
		}
		return ar;
	}
	public int setProductOrderAdd(Long [] nums) throws Exception{
	
		List<CartDTO> ar = new ArrayList<CartDTO>();
		int result = 0;
		for(Long num : nums) {
			CartDTO cartDTO = cartDAO.getCartOrderList(num);
			ar.add(cartDTO);
		}
		for(int i=0; i<ar.size(); i++) {
			ProductOrderDTO productOrderDTO = new ProductOrderDTO();
			productOrderDTO.setId(ar.get(i).getId());
			productOrderDTO.setBuyCheck(1L);
			productOrderDTO.setProductNum(ar.get(i).getProductNum());
			productOrderDTO.setPayMentCheck(1L);
			productOrderDTO.setNum(ar.get(i).getNum());
			productOrderDTO.setOptionNum(ar.get(i).getOptionNum());
			productOrderDTO.setProductEa(ar.get(i).getCount());
			productOrderDTO.setTotalPrice(ar.get(i).getCount()*ar.get(i).getPrice());
			result = cartDAO.setProductOrderAdd(productOrderDTO);
			if(result>0) {
				ProductOptionDTO optionDTO = new ProductOptionDTO();
				optionDTO = cartDAO.setProductOption(ar.get(i).getOptionNum());
				if(optionDTO.getProductStock()<1) {
					
					return 0;
				}
				optionDTO.setProductStock(optionDTO.getProductStock()-ar.get(i).getCount());
				
				result = cartDAO.setproductOptionStock(optionDTO);
				result = cartDAO.setCartDelete(ar.get(i).getNum());
				Long num = cartDAO.setCartOptionRef(ar.get(i).getOptionNum());
				optionDTO = cartDAO.setProductOption(num);
				optionDTO.setProductStock(optionDTO.getProductStock()-ar.get(i).getCount());
				result = cartDAO.setproductOptionStock(optionDTO);
				num=cartDAO.setCartOptionRef(num);
				optionDTO = cartDAO.setProductOption(num);
				optionDTO.setProductStock(optionDTO.getProductStock()-ar.get(i).getCount());
				result = cartDAO.setproductOptionStock(optionDTO);
			}
			
		}
		return result;
	}
	
}
