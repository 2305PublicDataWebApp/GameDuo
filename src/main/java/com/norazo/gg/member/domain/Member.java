package com.norazo.gg.member.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class Member {
	
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private int memberAge;
	private String memberGender;
	private String memberEmail;
	private String memberPhone;
	private String memberAddress;
	private Date memberCreateDate;
	private String memberBlackStauts;
	private String memberAdminStatus;
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public Date getMemberCreateDate() {
		return memberCreateDate;
	}

	public void setMemberCreateDate(Date memberCreateDate) {
		this.memberCreateDate = memberCreateDate;
	}

	public String getMemberBlackStauts() {
		return memberBlackStauts;
	}

	public void setMemberBlackStauts(String memberBlackStauts) {
		this.memberBlackStauts = memberBlackStauts;
	}

	public String getMemberAdminStatus() {
		return memberAdminStatus;
	}

	public void setMemberAdminStatus(String memberAdminStatus) {
		this.memberAdminStatus = memberAdminStatus;
	}

	@Override
	public String toString() {
		return "회원가입 [회원번호=" + memberNo + ", 회원아이디=" + memberId + ", 회원비밀번호=" + memberPwd + ", 회원이름" + memberName + ", 회원나이="
				+ memberAge + ", 회원성별=" + memberGender + ", 회원이메일=" + memberEmail + ", 회원전화번호=" + memberPhone
				+ ", 회원주소=" + memberAddress + ", 회원생성날짜=" + memberCreateDate + ", 회원블랙여부="
				+ memberBlackStauts + ", 회원관리자여부=" + memberAdminStatus + "]";
	}
	
	
	
	
}
