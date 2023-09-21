package com.norazo.gg.board.service;

import java.util.List;
import java.util.Map;

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
	 * 게시글 조건에 따라 키워드로 검색 Service
	 * @param pInfo
	 * @param paramMap
	 * @return
	 */
	List<Board> searchBoardsByKeyword(PageInfo pInfo, Map<String, String> paramMap);


	/**
	 * 게시글 검색 전체 갯수 Service
	 * @param paramMap
	 * @return
	 */
	int getListCount(Map<String, String> paramMap);


	/**
	 * 전체 게시물 갯수 Service
	 * @return
	 */
	int getListCount();
}
