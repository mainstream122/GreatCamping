package com.ktds.camp.notice.service;

import java.util.List;

import com.ktds.camp.notice.dao.NoticeDao;
import com.ktds.camp.notice.vo.NoticeSearchVO;
import com.ktds.camp.notice.vo.NoticeVO;

import io.github.seccoding.web.pager.Pager;
import io.github.seccoding.web.pager.PagerFactory;
import io.github.seccoding.web.pager.explorer.ClassicPageExplorer;
import io.github.seccoding.web.pager.explorer.PageExplorer;

public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDao noticeDao;
	

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@Override
	public PageExplorer readAllNotice(NoticeSearchVO noticeSearchVO) {
		Pager pager = PagerFactory.getPager(Pager.ORACLE, noticeSearchVO.getPageNo(), noticeDao.selectAllNoticeCount(noticeSearchVO), 10, 10);

        // 페이지 정보를 가지는 객체 생성
        PageExplorer pageExplorer = pager.makePageExplorer(ClassicPageExplorer.class, noticeSearchVO);
        

        if ( pager.getTotalArticleCount() > 0 ) {
            // 리스트 조회
            List<NoticeVO> noticeList = noticeDao.selectAllNotice(noticeSearchVO);
            // 페이지 객체에 리스트 셋팅
            pageExplorer.setList(noticeList);
        }

        return pageExplorer;
	}

	@Override
	public boolean deleteNotice(int noticeId) {
		return noticeDao.deleteNotice(noticeId) > 0;
	}

	/*@Override
	public boolean updateNotice(NoticeVO noticeVO) {
		return noticeDao.updateNotice(noticeVO) > 0;
	}*/ 

	/*@Override
	public boolean createNewNotice(NoticeVO noticeVO) {
		return noticeDao.insertNewNotice(noticeVO) > 0;
	}*/

}
