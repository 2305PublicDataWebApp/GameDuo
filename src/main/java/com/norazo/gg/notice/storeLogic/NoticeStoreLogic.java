package com.norazo.gg.notice.storeLogic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.norazo.gg.notice.domain.Notice;
import com.norazo.gg.notice.domain.PageInfo;
import com.norazo.gg.notice.store.NoticeStore;


@Repository
public class NoticeStoreLogic implements NoticeStore {
	
	@Override
	public int insertNotice(SqlSession sqlSession, Notice notice) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("NoticeMapper.insertNotice",notice);
		return result;
	}

	@Override
	public int selectListCount(SqlSession sqlSession) {
		// TODO Auto-generated method stub
		int result = sqlSession.selectOne("NoticeMapper.selectListCount");
		return result;
	}

	@Override
	public List<Notice> selectNotice(SqlSession sqlSession, PageInfo pInfo) {
		// TODO Auto-generated method stub
		List<Notice> nList = sqlSession.selectOne("NoticeMapper.selectNotice",pInfo);
		return nList;
	}

	@Override
	public Notice selectNoticeByNo(SqlSession sqlSession, Integer noticeNo) {
		// TODO Auto-generated method stub
		Notice noticeOne = sqlSession.selectOne("NoticeMapper.selectNoticeByNo",noticeNo);
		return noticeOne;
	}

	@Override
	public int updateNotice(SqlSession sqlSession, Notice notice) {
		// TODO Auto-generated method stub
		int result = sqlSession.update("NoticeMapper.updateNotice" ,notice);
		return result;
	}

//	@Override
//	public int insertNotice(Notice notice) {
//		// TODO Auto-generated method stub
//		int result = insertNotice("noticeMapper.insertNotice",notice);
//		
//		return result;
//	}
}
