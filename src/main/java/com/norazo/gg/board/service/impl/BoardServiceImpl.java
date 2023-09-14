package com.norazo.gg.board.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.norazo.gg.board.domain.Board;
import com.norazo.gg.board.service.BoardService;
import com.norazo.gg.board.store.BoardStore;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardStore bStore;
	@Autowired
	private SqlSession session;

	@Override
	public int insertBoard(Board board) {
		int result = bStore.insertBoard(session, board);
		return result;
	}

}
