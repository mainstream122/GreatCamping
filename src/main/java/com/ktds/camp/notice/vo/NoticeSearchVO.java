package com.ktds.camp.notice.vo;

import io.github.seccoding.web.pager.annotations.EndRow;
import io.github.seccoding.web.pager.annotations.StartRow;

public class NoticeSearchVO {
	//검색키워드변수
	private String searchKeyword;
	
	//검색키워드 타입변수
	private String searchType;

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	// 현재 내가 보고있는 페이지의 번호
	private String pageNo;
	
	// 페이징의 시작부분 번호
	@StartRow
	private int startNumber;
	
	// 페이징의 끝부분 번호
	@EndRow
	private int endNumber;
	
	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public int getStartNumber() {
		return startNumber;
	}

	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}

	public int getEndNumber() {
		return endNumber;
	}

	public void setEndNumber(int endNumber) {
		this.endNumber = endNumber;
	}

}
