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
	Member memberLoginCheck(Member member);

}
