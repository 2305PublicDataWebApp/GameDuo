package com.norazo.gg.board.store;

import org.apache.ibatis.session.SqlSession;

import com.norazo.gg.board.domain.Board;

public interface BoardStore {

	/**
	 * 게시글 등록 Store
	 * @param session
	 * @param board
	 * @return
	 */
	int insertBoard(SqlSession session, Board board);

}
