package com.norazo.gg.board.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.norazo.gg.board.domain.Board;
import com.norazo.gg.notice.domain.PageInfo;

public interface BoardStore {

	/**
	 * 게시글 등록 Store
	 * @param sqlSession
	 * @param board
	 * @return
	 */
	int insertBoard(SqlSession session, Board board);

	/**
	 * 게시글 전체 갯수 Store
	 * @param sqlSession
	 * @return
	 */
	int selectListCount(SqlSession sqlSession);

	/**
	 * 게시글 전체 조회 Store
	 * @param sqlSession
	 * @param pInfo
	 * @return
	 */
	List<Board> selectBoardList(SqlSession sqlSession, PageInfo pInfo);

	/**
	 * 게시글 상세조회, 수정페이지 Store
	 * @param sqlSession
	 * @param boardNo
	 * @return
	 */
	Board selectBoardByNo(SqlSession sqlSession, Integer boardNo);

	/**
	 * 게시글 수정 Store
	 * @param sqlSession
	 * @param board
	 * @return
	 */
	int updateBoard(SqlSession sqlSession, Board board);

	/**
	 * 게시글 삭제 Store
	 * @param sqlSession
	 * @param board
	 * @return
	 */
	int deleteBoard(SqlSession sqlSession, Board board);

	/**
	 * 게시글 검색 전체 갯수 Store
	 * @param sqlSession
	 * @param paramMap
	 * @return
	 */
	int selectListCount(SqlSession sqlSession, Map<String, String> paramMap);

	/**
	 * 게시글 조건에 따라 키워드로 조회 Store
	 * @param sqlSession
	 * @param pInfo
	 * @param paramMap
	 * @return
	 */
	List<Board> searchBoardsByKeyword(SqlSession sqlSession, PageInfo pInfo, Map<String, String> paramMap);

}
