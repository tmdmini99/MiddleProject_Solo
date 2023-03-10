package com.iu.s1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iu.s1.member.MemberDAO;
import com.iu.s1.member.MemberDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class test {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void tests() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("test");
		memberDTO.setPw("test");
		memberDTO.setName("name");
		memberDTO.setAddress("addre");
		memberDTO.setPhone("11");
		memberDTO.setEmail("em");
		int result = memberDAO.setMemberAdd(memberDTO);
		assertEquals(1, result);
	}

}
