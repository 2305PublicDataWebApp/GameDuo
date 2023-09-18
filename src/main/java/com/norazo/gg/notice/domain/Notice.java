package com.norazo.gg.notice.domain;

import java.sql.Date;

	public class Notice {
		private Integer noticeNo;
		private String noticeTitle;
		private String noticeContent;
		private String noticeAdmin;
		private Date nCreateDate;
		
		public int getNoticeNo() {
			return noticeNo;
		}
		public void setNoticeNo(Integer noticeNo) {
			this.noticeNo = noticeNo;
		}
		public String getNoticeTitle() {
			return noticeTitle;
		}
		public void setNoticeTitle(String noticeTitle) {
			this.noticeTitle = noticeTitle;
		}
		public String getNoticeContent() {
			return noticeContent;
		}
		public void setNoticeContent(String noticeContent) {
			this.noticeContent = noticeContent;
		}
		public String getNoticeAdmin() {
			return noticeAdmin;
		}
		public void setNoticeAdmin(String noticeAdmin) {
			this.noticeAdmin = noticeAdmin;
		}
		public Date getnCreateDate() {
			return nCreateDate;
		}
		public void setnCreateDate(Date nCreateDate) {
			this.nCreateDate = nCreateDate;
		}
		@Override
		public String toString() {
			return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
					+ ", noticeAdmin=" + noticeAdmin + ", nCreateDate=" + nCreateDate + "]";
		}
		
		public Notice(Integer noticeNo, String noticeTitle, String noticeContent, String noticeAdmin, Date nCreateDate) {
			super();
			this.noticeNo = noticeNo;
			this.noticeTitle = noticeTitle;
			this.noticeContent = noticeContent;
			this.noticeAdmin = noticeAdmin;
			this.nCreateDate = nCreateDate;
		}

}
