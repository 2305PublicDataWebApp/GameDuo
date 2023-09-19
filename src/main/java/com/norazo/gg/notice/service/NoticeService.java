package com.norazo.gg.notice.service;

import java.util.List;

import com.norazo.gg.notice.domain.Notice;
import com.norazo.gg.notice.domain.PageInfo;


public interface NoticeService {

		int insertNotice(Notice notice);


		List<Notice> selectNotice(PageInfo pInfo);


		int getListCount();

		Notice selectNoticeByNo(Integer noticeNo);



		int updateNotice(Notice notice);


		int deleteNotice(Notice notice);


}
