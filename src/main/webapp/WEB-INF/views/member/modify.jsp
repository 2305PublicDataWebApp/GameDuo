<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<!-- head 파일 -->
	<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
	<body>
		<!-- 헤더 -->
	    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
		<!-- 메인 -->
		<main class="main member member member_update" id="member_update">
			<div class="container">
				<form action="/member/update.gg" method="post">
					<h2 class="main_txt">정보수정</h2>
					<ul>
						<li>
							<label>아이디</label>
							<input type="text" name="memberId" value="${member.memberId}" readonly>
						</li>
						<li>
							<label>비밀번호</label>
							<input type="password" name="memberPwd" value="${member.memberPwd}">
						</li>
						<li>
							<label>나이</label>
							<input type="text" name="memberAge" value="${member.memberAge}" readonly>
						</li>
						<li>
							<label>이름</label>
							<input type="text" name="memberName" value="${member.memberName}" readonly>
						</li>
						<li>
							<label>성별</label>
							남자<input type="radio" id="member-gender" name="memberGender" value="M" <c:if test="${member.memberGender eq 'M' }">checked</c:if>>
    	           			여자<input type="radio" id="member-gender" name="memberGender" value="F" <c:if test="${member.memberGender eq 'F' }">checked</c:if>>
						</li>
						<li>
							<label>이메일</label>
							<input type="text" name="memberEmail" value="${member.memberEmail}">
						</li>
						<li>
							<label>전화번호</label>
							<input type="text" name="memberPhone" value="${member.memberPhone}">
						</li>
						<li>
							<label>주소</label>
							<input type="text" id="member-address" name="memberAddress" value="${member.memberAddress}">
							<input type="button" class="address_btn" onclick="sample4_execDaumPostcode();" value="주소 검색">
						</li>
					</ul>
					<div class="btn_wrap">
			            <button type="submit" class="btn_update">수정하기</button>
			            <a href="/member/delete.gg?memberId=${member.memberId}" class="btn_delete">탈퇴하기</a>
			            <a href="/member/mypage.gg?memberId=${member.memberId}" class="btn_prev">이전페이지로 이동</a>
			         </div>
				</form>
			</div>
		</main>
		<!-- 푸터 -->
    	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>
</html>