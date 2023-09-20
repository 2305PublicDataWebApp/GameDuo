package com.norazo.gg.report.domain;

import java.sql.Date;

public class Report {
	
	private int reportNo;
	private String reportTitle;
	private String reportContent;
	private String reportWriter;
	private Date rCreateDate;
	private Date rUpdateDate;
	
	
	
	
	public int getReportNo() {
		return reportNo;
	}




	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}




	public String getReportTitle() {
		return reportTitle;
	}




	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}




	public String getReportContent() {
		return reportContent;
	}




	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}




	public String getReportWriter() {
		return reportWriter;
	}




	public void setReportWriter(String reportWriter) {
		this.reportWriter = reportWriter;
	}




	public Date getrCreateDate() {
		return rCreateDate;
	}




	public void setrCreateDate(Date rCreateDate) {
		this.rCreateDate = rCreateDate;
	}




	public Date getrUpdateDate() {
		return rUpdateDate;
	}




	public void setrUpdateDate(Date rUpdateDate) {
		this.rUpdateDate = rUpdateDate;
	}




	@Override
	public String toString() {
		return "신고 [번호=" + reportNo + ", 제목=" + reportTitle + ", 내용=" + reportContent + ", 작성자=" + reportWriter
				+ ", 작성일=" + rCreateDate + ", 수정일=" + rCreateDate + "]";
	}
	
	
}
