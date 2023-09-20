package com.norazo.gg.report.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.norazo.gg.notice.domain.PageInfo;
import com.norazo.gg.report.domain.Report;
import com.norazo.gg.report.service.ReportService;
import com.norazo.gg.report.store.ReportStore;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private ReportStore rStore;
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertReport(Report report) {
		int result = rStore.insertReport(sqlSession, report);
		return result;
	}

	@Override
	public List<Report> selectReport(PageInfo pInfo) {
		List<Report> rList = rStore.selectReport(sqlSession,pInfo);
		return rList;
	}

	@Override
	public int getListCount() {
		int result = rStore.selectListCount(sqlSession);
		return result;
	}

	@Override
	public Report selectReportByNo(Integer reportNo) {
		Report reportOne = rStore.selectReportByNo(sqlSession,reportNo);
		return reportOne;
	}

	@Override
	public int updateReport(Report report) {
		int result = rStore.updateReport(sqlSession,report);
		return result;
	}

	@Override
	public int deleteReport(Report report) {
		int result = rStore.deleteReport(sqlSession,report);
		return result;
	}
	
}
