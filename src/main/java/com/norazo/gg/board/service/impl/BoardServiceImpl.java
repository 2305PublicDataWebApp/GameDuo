package com.norazo.gg.board.service.impl;

import java.util.List;

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

	@Override
	public Board selectBoardNo(Integer boardNo) {
		Board board = bStore.selectBoardByNo(sqlSession, boardNo);
		return board;
	}

}
