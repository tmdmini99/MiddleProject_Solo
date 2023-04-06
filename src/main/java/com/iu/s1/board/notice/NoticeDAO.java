package com.iu.s1.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.util.Pager;

@Repository
public class NoticeDAO implements BbsDAO{
	
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.iu.s1.board.notice.NoticeDAO.";

	
	
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
	}
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"getBoardList",pager);
	}

	@Override
	public BbsDTO getBoardDetail() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setBoardAdd() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardUpdate() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardDelete() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
