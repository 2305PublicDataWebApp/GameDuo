package com.norazo.gg.member.domain;

import java.sql.Date;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private int memberAge;
	private char memberGender;
	private String memberEmail;
	private String memberPhone;
	private String memberAddress;
	private Date memberCreateDate;
	private char memberBlackStauts;
	private char memberAdminStatus;
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
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	public char getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(char memberGender) {
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
	public char getMemberBlackStauts() {
		return memberBlackStauts;
	}
	public void setMemberBlackStauts(char memberBlackStauts) {
		this.memberBlackStauts = memberBlackStauts;
	}
	public char getMemberAdminStatus() {
		return memberAdminStatus;
	}
	public void setMemberAdminStatus(char memberAdminStatus) {
		this.memberAdminStatus = memberAdminStatus;
	}
	@Override
	public String toString() {
		return "ȸ������ [ȸ����ȣ=" + memberNo + ", ȸ�����̵�=" + memberId + ", ȸ����й�ȣ=" + memberPwd + ", ȸ������="
				+ memberAge + ", ȸ������=" + memberGender + ", ȸ���̸���=" + memberEmail + ", ȸ����ȭ��ȣ=" + memberPhone
				+ ", ȸ���ּ�=" + memberAddress + ", ȸ��������¥=" + memberCreateDate + ", ȸ��������="
				+ memberBlackStauts + ", ȸ�������ڿ���=" + memberAdminStatus + "]";
	}
	
	
}
