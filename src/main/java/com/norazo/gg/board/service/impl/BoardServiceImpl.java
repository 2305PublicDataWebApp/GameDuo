package com.norazo.gg.board.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.norazo.gg.board.domain.Board;
import com.norazo.gg.board.service.BoardService;
import com.norazo.gg.board.store.BoardStore;
import com.norazo.gg.notice.domain.PageInfo;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardStore bStore;
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertBoard(Board board) {
		int result = bStore.insertBoard(sqlSession, board);
		return result;
	}

	@Override
	public int getListCount() {
		int result = bStore.selectListCount(sqlSession);
		return result;
	}

	@Override
	public List<Board> selectBoardList(PageInfo pInfo) {
		List<Board> bList = bStore.selectBoardList(sqlSession, pInfo);
		return bList;
	}

//	@Override
//	public Board selectBoardNo(Integer boardNo) {
//		Board board = bStore.selectBoardByNo(sqlSession, boardNo);
//		return board;
//	}

	@Override
	public Board selectBoardByNo(Integer boardNo) {
		Board board = bStore.selectBoardByNo(sqlSession, boardNo);
		return board;
	}

	@Override
	public int updateBoard(Board board) {
		int result = bStore.updateBoard(sqlSession, board);
		return result;
	}

	@Override
	public int deleteBoard(Board board) {
		int result = bStore.deleteBoard(sqlSession, board);
		return result;
	}

	@Override
	public int getListCount(Map<String, String> paramMap) {
		int result = bStore.selectListCount(sqlSession, paramMap);
		return result;
	}

	@Override
	public List<Board> searchBoardsByKeyword(PageInfo pInfo, Map<String, String> paramMap) {
		List<Board> searchList = bStore.searchBoardsByKeyword(sqlSession, pInfo, paramMap);
		return searchList;
	}

}
