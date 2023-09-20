package com.norazo.gg.report.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.norazo.gg.notice.domain.PageInfo;
import com.norazo.gg.report.domain.Report;
import com.norazo.gg.report.store.ReportStore;

@Repository
public class ReportStoreLogic implements ReportStore{

	@Override
	public int insertReport(SqlSession sqlSession, Report report) {
		int result = sqlSession.insert("ReportMapper.insertReport", report);
		return result;
	}

	@Override
	public List<Report> selectReport(SqlSession sqlSession, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Report> rList = sqlSession.selectList("ReportMapper.selectReport", null, rowBounds);
		return rList;
	}

	@Override
	public int selectListCount(SqlSession sqlSession) {
		int result = sqlSession.selectOne("ReportMapper.selectListCount");
		return result;
	}

	@Override
	public Report selectReportByNo(SqlSession sqlSession, Integer reportNo) {
		Report reportOne = sqlSession.selectOne("ReportMapper.selectReportByNo", reportNo);
		return reportOne;
	}

	@Override
	public int updateReport(SqlSession sqlSession, Report report) {
		int result = sqlSession.update("ReportMapper.updateReport", report);
		return result;
	}

	@Override
	public int deleteReport(SqlSession sqlSession, Report report) {
		int result = sqlSession.delete("ReportMapper.deleteReport", report);
		return result;
	}
	
}
