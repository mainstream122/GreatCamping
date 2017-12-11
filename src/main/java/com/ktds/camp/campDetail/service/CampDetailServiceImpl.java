package com.ktds.camp.campDetail.service;

import java.util.List;
import java.util.Map;

import com.ktds.camp.campDetail.dao.CampDetailDao;
import com.ktds.camp.campDetail.vo.CampDetailImageReadVO;
import com.ktds.camp.campDetail.vo.CampDetailVO;

public class CampDetailServiceImpl implements CampDetailService{
	
	private CampDetailDao campDetailDao;
	
	public void setCampDetailDao(CampDetailDao campDetailDao) {
		this.campDetailDao = campDetailDao;
	}

	@Override
	public List<Map<String, Object>> readAllCampMap(int regionId) {
		return campDetailDao.selectAllCampMap(regionId);
	}

	@Override
	public CampDetailVO readOneCampMap(int campingPlaceId) {
		return campDetailDao.selectOneCampMap(campingPlaceId);
	}

	@Override
	public List<CampDetailImageReadVO> readListImage(int campingPlaceId) {
		return campDetailDao.selectListImage(campingPlaceId);
	}

}
