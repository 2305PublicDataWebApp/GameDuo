package com.norazo.gg.board.service;

import com.norazo.gg.board.domain.Board;

public interface BoardService {

	/**
	 * 게시글 등록 Service
	 * @param board
	 * @return
	 */
	int insertBoard(Board board);

}
