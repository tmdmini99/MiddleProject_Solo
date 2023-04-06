package com.iu.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		
		pager.makeNum(noticeDAO.getTotalCount(pager));
		pager.makeRow();
		return noticeDAO.getBoardList(pager);
	}
}
