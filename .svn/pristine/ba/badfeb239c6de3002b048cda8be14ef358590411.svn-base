package com.ktds.camp.campingPlace.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.camp.campingPlace.vo.CampingPlaceSearchVO;
import com.ktds.camp.campingPlace.vo.CampingPlaceVO;


public class CampingPlaceDaoImpl extends SqlSessionDaoSupport implements CampingPlaceDao {

	@Override
	public CampingPlaceVO selectOneCampingPlace(int campingPlaceId) {
		return getSqlSession().selectOne("CampingPlaceDao.selectOneCampingPlace", campingPlaceId);
	}

	@Override
	public List<CampingPlaceVO> selectAllCampingPlace() {
		return getSqlSession().selectList("CampingPlaceDao.selectAllCampingPlace");
	}

	@Override
	public List<CampingPlaceVO> selectCampingPlaceByRegionId(CampingPlaceSearchVO campingPlaceSearchVo) {
		return getSqlSession().selectList("CampingPlaceDao.selectCampingPlaceByRegionId", campingPlaceSearchVo);
	}

	@Override
	public int selectCampingPlaceByRegionIdAllCount(CampingPlaceSearchVO campingPlaceSearchVo) {
		return getSqlSession().selectOne("CampingPlaceDao.selectCampingPlaceByRegionIdAllCount", campingPlaceSearchVo);
	}

}
