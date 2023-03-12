package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int setMemberJoin(MemberDTO memberDTO)throws Exception{
		return memberDAO.setMemberJoin(memberDTO);
	}
	
	public MemberDTO getMemberDetail(MemberDTO memberDTO) throws Exception{
		return memberDAO.getMemberLogin(memberDTO);
	}
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception{
		MemberDTO loginDTO=memberDAO.getMemberLogin(memberDTO);
		System.out.println(loginDTO.getPw()==memberDTO.getPw());
		System.out.println(loginDTO.getPw()==memberDTO.getPw());
		if(loginDTO!=null &&loginDTO.getPw().equals(memberDTO.getPw())) {
			System.out.println("들어와?");
			memberDTO.setPw(null);
			return memberDTO;
		}
		return null;
	}
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.setMemberUpdate(memberDTO);
	}
}
