package com.iu.s1.board;

import java.sql.Date;

public class BbsDTO {
	private Long numum;
	private String id;
	private String title;
	private String contents;
	private Date regDate;
	private Long depth;
	public Long getNumum() {
		return numum;
	}
	public void setNumum(Long numum) {
		this.numum = numum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	
	
}
