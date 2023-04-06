package com.iu.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pager;

@Service
public class QnaService {
	@Autowired
	private QnaDAO qnaDAO;
	
	
	public List<QnaDTO> getBoardList(Pager pager) throws Exception {
		pager.makeNum(qnaDAO.getTotalCount(pager));
		pager.makeRow();
		return qnaDAO.getBoardList(pager);
	}
}
