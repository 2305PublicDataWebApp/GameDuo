package com.norazo.gg.report.service;

import java.util.List;

import com.norazo.gg.notice.domain.PageInfo;
import com.norazo.gg.report.domain.Report;

public interface ReportService {
	int insertReport(Report report);

	List<Report> selectReport(PageInfo pInfo);

	int getListCount();

	Report selectReportByNo(Integer reportNo);

	int updateReport(Report report);

	int deleteReport(Report report);
}
