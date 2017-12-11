package com.ktds.camp.campDetail.dao;

import java.util.List;
import java.util.Map;

import com.ktds.camp.campDetail.vo.CampDetailImageReadVO;
import com.ktds.camp.campDetail.vo.CampDetailVO;

public interface CampDetailDao {
	
	public	List<Map<String, Object>> selectAllCampMap(int regionId);
	public CampDetailVO selectOneCampMap(int campingPlaceId);
	
	public List<CampDetailImageReadVO> selectListImage(int campingPlaceId); 

}
