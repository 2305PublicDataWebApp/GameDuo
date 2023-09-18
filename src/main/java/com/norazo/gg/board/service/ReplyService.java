package com.norazo.gg.board.service;

import java.util.List;

import com.norazo.gg.board.domain.Reply;


public interface ReplyService {

	/**
	 * 게시글 등록 Service
	 * @param reply
	 * @return
	 */
	int insertReply(Reply reply);

	/**
	 * 게시글 댓글 수정 Service
	 * @param reply
	 * @return
	 */
	int updateReply(Reply reply);

	/**
	 * 게시판 댓글삭제 Service
	 * @param reply
	 * @return
	 */
	int deleteReply(Reply reply);

	/**
	 * Board CONTROLLER에서옴
	 * 댓글전체 조회 Service
	 * @return
	 */
	List<Reply> selectReplyList(int refBoardNo);

}
