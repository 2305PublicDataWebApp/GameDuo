package com.norazo.gg.notice.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.norazo.gg.board.domain.Board;
import com.norazo.gg.notice.domain.Notice;
import com.norazo.gg.notice.domain.PageInfo;
import com.norazo.gg.notice.service.NoticeService;
import com.norazo.gg.notice.store.NoticeStore;

@Service
public class NoticeServiceImpl implements NoticeService{

	//의존성 주입
		@Autowired
		private NoticeStore nStore;
		
		@Autowired
		private SqlSession sqlSession;

		@Override
		public int insertNotice(Notice notice) {
			int result = nStore.insertNotice(sqlSession, notice);
			return result;
		}

		@Override
		public int getListCount() {
			// TODO Auto-generated method stub
			int result = nStore.selectListCount(sqlSession);
			return result;
		}

		@Override
		public List<Notice> selectNotice(PageInfo pInfo) {
			// TODO Auto-generated method stub
			List<Notice> nList = nStore.selectNotice(sqlSession,pInfo);
			return nList;
		}

		@Override
		public Notice selectNoticeByNo(Integer noticeNo) {
			// TODO Auto-generated method stub
			Notice noticeOne = nStore.selectNoticeByNo(sqlSession,noticeNo);
			return noticeOne;
		}

		@Override
		public int updateNotice(Notice notice) {
			// TODO Auto-generated method stub
			int result = nStore.updateNotice(sqlSession,notice);
			return result;
		}

		@Override
		public int deleteNotice(Notice notice) {
			// TODO Auto-generated method stub
			int result = nStore.deleteNotice(sqlSession,notice);
			return result;
		}

		@Override
		public int getListCount(Map<String, String> paramMap) {
			// TODO Auto-generated method stub
			int result = nStore.selectListCount(sqlSession, paramMap);
			return result;
		}

		
		@Override
		public List<Notice> searchNoticesByKeyword(PageInfo pInfo, Map<String, String> paramMap){
			// TODO Auto-generated method stub
		 List<Notice> searchList = nStore.searchNoticesByKeyword(sqlSession,pInfo, paramMap );
		 return searchList;
		}

	
}
	
	
	

