package com.norazo.gg.notice.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.norazo.gg.board.domain.Board;
import com.norazo.gg.notice.domain.Notice;
import com.norazo.gg.notice.domain.PageInfo;
import com.norazo.gg.notice.store.NoticeStore;

@Repository
public class NoticeStoreLogic implements NoticeStore {

	@Override
	public int insertNotice(SqlSession sqlSession, Notice notice) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public int selectListCount(SqlSession sqlSession) {
		int result = sqlSession.selectOne("NoticeMapper.selectListCount");
		return result;
	}

	@Override
	public List<Notice> selectNotice(SqlSession sqlSession, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = sqlSession.selectList("NoticeMapper.selectNotice", null, rowBounds);
		return nList;
	}

	@Override
	public Notice selectNoticeByNo(SqlSession sqlSession, Integer noticeNo) {
		// TODO Auto-generated method stub
		Notice noticeOne = sqlSession.selectOne("NoticeMapper.selectNoticeByNo", noticeNo);
		return noticeOne;
	}

	@Override
	public int updateNotice(SqlSession sqlSession, Notice notice) {
		// TODO Auto-generated method stub
		int result = sqlSession.update("NoticeMapper.updateNotice", notice);
		return result;
	}

	@Override
	public int deleteNotice(SqlSession sqlSession, Notice notice) {
		// TODO Auto-generated method stub
		int result = sqlSession.delete("NoticeMapper.deleteNotice", notice);
		return result;
	}

	@Override
	public int selectListCount(SqlSession sqlSession, Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		int result = sqlSession.selectOne("NoticeMapper.selectListBykeywordCount", paramMap);
		return result;
	}


	@Override
	public List<Notice> searchNoticesByKeyword(SqlSession sqlSession,PageInfo pInfo, Map<String, String> paramMap) {
				int limit = pInfo.getRecordCountPerPage();
				int offset = (pInfo.getCurrentPage()-1)*limit;
				RowBounds rowBounds = new RowBounds(offset, limit);
				List<Notice> searchList = sqlSession.selectList("NoticeMapper.searchNoticesByKeyword", paramMap, rowBounds);
				return searchList;
			}


	}

//	@Override
//	public int insertNotice(Notice notice) {
//		// TODO Auto-generated method stub
//		int result = insertNotice("noticeMapper.insertNotice",notice);
//		
//		return result;
//	}
