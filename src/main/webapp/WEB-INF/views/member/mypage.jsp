<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<body>
		<!-- head 파일 -->
		<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
		<!-- 헤더 -->
	    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
		<!-- 메인 -->
		<main class="main" id="main_register">
			<div class="container">
				<form action="/member/mypage.gg" method="post">
					<h2>마이페이지</h2>
					<ul>
						<li>
							<label>아이디</label>
							<input type="text" name="memberId" value="${member.memberId}" readonly>
						</li>
						<li>
							<label>비밀번호</label>
							<input type="password" name="memberPwd" value="${member.memberPwd}" readonly>
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
							남<input type="radio" id="member-gender" name="memberGender" value="M"><c:if test="${member.memberGender eq 'M' }">checked</c:if>
							여<input type="radio" id="member-gender" name="memberGender" value="F"><c:if test="${member.memberGender eq 'F' }">checked</c:if>
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
			            <input type="submit" value="수정하기" class="btn_update">
			            <input type="reset" value="삭제하기" class="btn_delete">
			         </div>
				</form>
			</div>
		</main>
		<!-- 푸터 -->
    	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>
</html>