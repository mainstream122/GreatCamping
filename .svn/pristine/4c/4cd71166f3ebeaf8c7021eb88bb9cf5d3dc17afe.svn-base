package com.ktds.camp.notice.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.camp.notice.vo.NoticeSearchVO;
import com.ktds.camp.notice.vo.NoticeVO;

public class NoticeDaoImpl extends SqlSessionDaoSupport implements NoticeDao {

	/*@Override
	public NoticeVO selectAllNotice() {
		return getSqlSession().selectOne("NoticeDao.selectAllNotice");
	}*/

	@Override
	public List<NoticeVO> selectAllNotice(NoticeSearchVO noticeSearchVO) {
		return getSqlSession().selectList("NoticeDao.selectAllNotice", noticeSearchVO);
	}

	@Override
	public int selectAllNoticeCount(NoticeSearchVO noticeSearchVO) {
		return getSqlSession().selectOne("NoticeDao.selectAllNoticeCount", noticeSearchVO);
	}

	/*@Override
	public int updateNotice(NoticeVO noticeVO) {
		return getSqlSession().update("NoticeDao.updateNotice", noticeVO);
	}*/
	
	@Override
	public int deleteNotice(int noticeId) {
		return getSqlSession().delete("NoticeDao.deleteNotice", noticeId);
	}


	/*@Override
	public int insertNewNotice(NoticeVO noticeVO) {
		return getSqlSession().insert("NoticeDao.insertNewNotice", noticeVO);
	}*/

}
