package com.norazo.gg.board.service;

import java.util.List;

import com.norazo.gg.board.domain.Board;
import com.norazo.gg.notice.domain.PageInfo;

public interface BoardService {

	/**
	 * 게시글 등록 Service
	 * @param board
	 * @return
	 */
	int insertBoard(Board board);

	
	/**
	 * 전체 게시물 갯수 Service
	 * @return
	 */
	int getListCount();

	/**
	 * 게시글 전체 조회 Service
	 * @param pInfo
	 * @return
	 */
	List<Board> selectBoardList(PageInfo pInfo);

//	/**
//	 * 게시글 상세 조회 Service
//	 * @param boardNo
//	 * @return
//	 */
//	Board selectBoardNo(Integer boardNo);

	/**
	 * 게시글 상세 조회, 수정 페이지 Service
	 * @param boardNo
	 * @return
	 */
	Board selectBoardByNo(Integer boardNo);


	/**
	 * 게시글 수정 Service
	 * @param board
	 * @return
	 */
	int updateBoard(Board board);

	
	/**
	 * 게시글 삭제 Service
	 * @param board
	 * @return
	 */
	int deleteBoard(Board board);
}
