package com.norazo.gg.member.store;

import org.apache.ibatis.session.SqlSession;

import com.norazo.gg.member.domain.Member;

public interface MemberStore {

	/**
	 * 회원 등록 Store
	 * @param session
	 * @param member
	 * @return
	 */
	int insertMember(SqlSession session, Member member);

	/**
	 * 회원 로그인 Store
	 * @param session
	 * @param member
	 * @return
	 */
	Member selectMemberLogin(SqlSession session, Member member);

	/**
	 * 회원 상세조회 Store
	 * @param session
	 * @param memberId
	 * @return
	 */
	Member selectOneById(SqlSession session, String memberId);

}
