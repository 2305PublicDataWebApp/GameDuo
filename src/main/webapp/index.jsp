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
	    <main class="main mainpage" id="mainpage">
	    	<div class="container">
		    	<h1>메인페이지</h1>
		    	
<!-- 				<a href="/member/register.gg">회원가입</a> -->
<%-- 				<c:if test = "${memberId ne null}"> --%>
<%-- 					<strong>${memberName }님</strong> 환영합니다.<br> --%>
<!-- 					<a href="/member/logout.gg">로그아웃</a><br> -->
<!-- 					<a href="/member/mypage.gg">마이페이지</a> -->
<%-- 				</c:if> --%>
			</div>
	    </main>
		<!-- 푸터 -->
    	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>
</html>