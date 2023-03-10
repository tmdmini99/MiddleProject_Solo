package com.iu.s1.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.member.MemberDAO.";
	
	public int setMemberAdd(MemberDTO memberDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setMemberAdd",memberDTO);
	}
}
