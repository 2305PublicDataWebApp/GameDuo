package com.norazo.gg.member.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.norazo.gg.member.service.MemberService;
import com.norazo.gg.member.store.MemberStore;

public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	private MemberStore mStore;
	
	
}
