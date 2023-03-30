package com.iu.s1.product;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class productTest {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void test() throws Exception{
//		List<ProductDTO> ar = productDAO.getProductList();
//		assertNotNull(ar);
		System.out.println("yes");
	
	}
}
