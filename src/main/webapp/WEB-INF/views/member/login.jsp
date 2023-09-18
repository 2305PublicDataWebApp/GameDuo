<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<!-- head 파일 -->
	<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
	<body>
		<!-- 헤더 -->
	    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
		<!-- 메인 -->
		<main class="main member member_login" id="member_login">
			<div class="container">
				<form action="/member/login.gg" method="post">
					<ul>
						<li>
							<label>아이디</label>
							<input type="text" name="memberId">
						</li>
						<li>
							<label>비밀번호</label>
							<input type="password" name="memberPwd">
						</li>
						
					</ul>
					<div class="btn_wrap">
			            <input type="submit" value="로그인" class="btn_submit">
			         </div>
				</form>
			</div>
		</main>
		<!-- 푸터 -->
    	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>
</html>