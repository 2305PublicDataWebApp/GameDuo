package com.norazo.gg.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.norazo.gg.member.domain.Member;
import com.norazo.gg.member.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore {

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member); 
		return result;
	}

	@Override
	public Member selectMemberLogin(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectMemberLogin", member);
		return mOne;
	}

	@Override
	public Member selectOneById(SqlSession session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}

}
