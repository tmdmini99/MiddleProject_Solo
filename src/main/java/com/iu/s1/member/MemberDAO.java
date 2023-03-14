package com.iu.s1.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.member.MemberDAO.";
	
	public int setMemberJoin(MemberDTO memberDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setMemberJoin",memberDTO);
	}
	
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getMemberLogin", memberDTO);
	}
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setMemberUpdate", memberDTO);
	}
	public List<String> getMemberIdFind(String email)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getMemberIdFind", email);
	}
	public int setMemberPwChange(MemberDTO memberDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setMemberPwChange", memberDTO);
	}
	
}
