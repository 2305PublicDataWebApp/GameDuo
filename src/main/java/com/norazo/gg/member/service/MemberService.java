package com.norazo.gg.member.service;

import com.norazo.gg.member.domain.Member;

public interface MemberService {

	/**
	 * 회원 등록 Service
	 * @param member
	 * @return
	 */
	int registerMember(Member member);

	/**
	 * 회원 로그인 Service
	 * @param member
	 * @return
	 */
	public Member memberLoginCheck(Member member);

	/**
	 * 회원 상세 조회 Service
	 * @param memberId
	 * @return
	 */
	public Member showOneById(String memberId);

}
