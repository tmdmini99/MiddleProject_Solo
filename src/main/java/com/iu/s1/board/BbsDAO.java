package com.iu.s1.board;

import java.util.List;

import com.iu.s1.util.Pager;

public interface BbsDAO {
	
	public List<BbsDTO> getBoardList(Pager pager)throws Exception;
	
	public BbsDTO getBoardDetail()throws Exception;
	
	public int setBoardAdd()throws Exception;
	
	public int setBoardUpdate() throws Exception;
	
	public int setBoardDelete() throws Exception;
}
