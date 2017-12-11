package com.ktds.camp.qna.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.camp.qna.vo.QnaVO;

public class QnaDaoImpl extends SqlSessionDaoSupport implements QnaDao {

	@Override
	public List<QnaVO> selectAllQnaList() {
		return getSqlSession().selectList("QnaDao.selectAllQnaList");
	}

	@Override
	public int updateViewCount(int qnaId) {
		return getSqlSession().update("QnaDao.updateViewCount", qnaId);
	}

	@Override
	public int insertQna(QnaVO qnaVO) {
		return getSqlSession().insert("QnaDao.insertQna", qnaVO);
	}

}
