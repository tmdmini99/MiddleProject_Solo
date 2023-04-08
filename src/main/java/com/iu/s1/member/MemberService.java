package com.iu.s1.member;

import java.util.List;

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
		
		
		if(loginDTO!=null &&loginDTO.getPw().equals(memberDTO.getPw())) {
			memberDTO.setRoleDTO(loginDTO.getRoleDTO());
			memberDTO.setPw(null);
			return memberDTO;
//			loginDTO.setPw(null);
//			return loginDTO;
		}
		return null;
	}
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.setMemberUpdate(memberDTO);
	}
	public boolean getMemberCheck(MemberDTO memberDTO)throws Exception{
		boolean check = true;
		memberDTO=memberDAO.getMemberLogin(memberDTO);
		if(memberDTO != null) {
			check=false;
		}
		
		return check;
		
	}
	public List<String> getMemberIdFind(String email)throws Exception{
		return memberDAO.getMemberIdFind(email);
	}
	
	public String setMemberPwChange(MemberDTO memberDTO)throws Exception{
		MemberDTO loginDTO=memberDAO.getMemberLogin(memberDTO);
		
		String s="";
		if(loginDTO!=null &&loginDTO.getEmail().equals(memberDTO.getEmail())) {
			
			int result=memberDAO.setMemberPwChange(memberDTO);
			System.out.println("re"+result);
		}
		return s;
	}
	
	public int setMemberAuto(MemberDTO memberDTO)throws Exception{
		return memberDAO.setMemberAuto(memberDTO);
	}
	public List<MemberDTO> getMemberAuto() throws Exception{
		return memberDAO.getMemberAuto();
	}
	public int setMemberRole(String [] ids) throws Exception{
		int result = 0;
		for(String id : ids) {
			MemberDTO memberDTO=new MemberDTO();
			memberDTO.setId(id);
			result = memberDAO.setMemberRole(memberDTO);
		}
		return result;
	}
	public int setKakaoLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.setKakaoLogin(memberDTO);
	}
	
}
