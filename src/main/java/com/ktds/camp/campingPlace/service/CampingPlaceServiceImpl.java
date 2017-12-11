package com.ktds.camp.campingPlace.service;

import java.util.List;

import com.ktds.camp.campingPlace.dao.CampingPlaceDao;
import com.ktds.camp.campingPlace.vo.CampingPlaceSearchVO;
import com.ktds.camp.campingPlace.vo.CampingPlaceVO;
import com.ktds.camp.notice.vo.NoticeVO;

import io.github.seccoding.web.pager.Pager;
import io.github.seccoding.web.pager.PagerFactory;
import io.github.seccoding.web.pager.explorer.ClassicPageExplorer;
import io.github.seccoding.web.pager.explorer.PageExplorer;

public class CampingPlaceServiceImpl implements CampingPlaceService{
	
	private CampingPlaceDao campingPlaceDao;
	
	public void setCampingPlaceDao(CampingPlaceDao campingPlaceDao) {
		this.campingPlaceDao = campingPlaceDao;
	}


	public CampingPlaceVO readOneCampingPlace(int campingPlaceId) {
		return campingPlaceDao.selectOneCampingPlace(campingPlaceId);
	}


	@Override
	public List<CampingPlaceVO> readAllCampingPlace() {
		return campingPlaceDao.selectAllCampingPlace();
	}


	@Override
	public PageExplorer readCampingPlaceByRegionId(CampingPlaceSearchVO campingPlaceSearchVo) {
		
		Pager pager = PagerFactory.getPager(Pager.ORACLE, campingPlaceSearchVo.getPageNo(), campingPlaceDao.selectCampingPlaceByRegionIdAllCount(campingPlaceSearchVo), 12, 10);

        // 페이지 정보를 가지는 객체 생성
        PageExplorer pageExplorer = pager.makePageExplorer(ClassicPageExplorer.class, campingPlaceSearchVo);
        if ( pager.getTotalArticleCount() > 0 ) {
            // 리스트 조회
            List<CampingPlaceVO> noticeList = campingPlaceDao.selectCampingPlaceByRegionId(campingPlaceSearchVo);
            // 페이지 객체에 리스트 셋팅
            pageExplorer.setList(noticeList);
        }
        
		return pageExplorer;
	}

}
