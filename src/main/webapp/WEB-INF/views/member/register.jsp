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
		<main class="main member member_register" id="member_register">
			<div class="container">
				<form action="/member/register.gg" method="post">
					<h2 class="main_txt">회원가입</h2>
					<ul>
						<li>
							<label>아이디</label>
							<input type="text" name="memberId">
						</li>
						<li>
							<label>비밀번호</label>
							<input type="password" name="memberPwd">
						</li>
						<li>
							<label>나이</label>
							<input type="text" name="memberAge">
						</li>
						<li>
							<label>이름</label>
							<input type="text" name="memberName">
						</li>
						<li>
							<label>성별</label>
							남<input type="radio" id="member-gender" name="memberGender" value="M">
							여<input type="radio" id="member-gender" name="memberGender" value="F">
						</li>
						<li>
							<label>이메일</label>
							<input type="text" name="memberEmail">
						</li>
						<li>
							<label>전화번호</label>
							<input type="text" name="memberPhone">
						</li>
						<li>
							<label>주소</label>
							<input type="text" id="member-address" name="memberAddress">
							<input type="button" class="address_btn" onclick="sample4_execDaumPostcode();" value="주소 검색">
						</li>
					</ul>
					<div class="btn_wrap">
			            <input type="submit" value="가입하기" class="btn_submit">
			            <input type="reset" value="초기화" class="btn_reset">
			         </div>
				</form>
			</div>
		</main>
		<!-- 푸터 -->
    	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>
</html>