package com.norazo.gg.notice.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.norazo.gg.notice.domain.Notice;
import com.norazo.gg.notice.domain.PageInfo;


public interface NoticeStore {

	int insertNotice(SqlSession sqlSession, Notice notice);

	int selectListCount(SqlSession sqlSession);

	List<Notice> selectNotice(SqlSession sqlSession, PageInfo pInfo);

	Notice selectNoticeByNo(SqlSession sqlSession, Integer noticeNo);
}
