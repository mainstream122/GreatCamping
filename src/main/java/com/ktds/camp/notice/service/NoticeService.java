package com.ktds.camp.notice.service;

import java.util.List;

import com.ktds.camp.notice.vo.NoticeSearchVO;
import com.ktds.camp.notice.vo.NoticeVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

public interface NoticeService {
	//public NoticeVO readAllNotice();
	//public boolean createNewNotice(NoticeVO noticeVO);
	
	//public List<NoticeVO> readAllNotice();
	public PageExplorer readAllNotice(NoticeSearchVO noticeSearchVO);
	//public int readAllNoticeCount();
	
	//public boolean updateNotice(NoticeVO noticeVO);
	public boolean deleteNotice(int noticeId);

}
