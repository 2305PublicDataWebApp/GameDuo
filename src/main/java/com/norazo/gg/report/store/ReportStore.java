package com.norazo.gg.report.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.norazo.gg.notice.domain.PageInfo;
import com.norazo.gg.report.domain.Report;

public interface ReportStore {

	int insertReport(SqlSession sqlSession, Report report);

	List<Report> selectReport(SqlSession sqlSession, PageInfo pInfo);

	int selectListCount(SqlSession sqlSession);

	Report selectReportByNo(SqlSession sqlSession, Integer reportNo);

	int updateReport(SqlSession sqlSession, Report report);

	int deleteReport(SqlSession sqlSession, Report report);
}
