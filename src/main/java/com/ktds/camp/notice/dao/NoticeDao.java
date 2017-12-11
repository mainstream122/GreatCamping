package com.ktds.camp.notice.dao;

import java.util.List;

import com.ktds.camp.notice.vo.NoticeSearchVO;
import com.ktds.camp.notice.vo.NoticeVO;

public interface NoticeDao {
	//public NoticeVO selectAllNotice();
	//public int insertNewNotice(NoticeVO noticeVO);
	public List<NoticeVO> selectAllNotice(NoticeSearchVO noticeSearchVO);
	public int selectAllNoticeCount(NoticeSearchVO noticeSearchVO);
	
	//public int updateNotice(NoticeVO noticeVO);
	public int deleteNotice(int noticeId);
	
}
