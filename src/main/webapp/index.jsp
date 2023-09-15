<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
		<h1>메인페이지</h1>
		<c:if test = "${memberId ne null}">
			<strong>${memberName }님</strong> 환영합니다. <a href="/member/logout.gg">로그아웃</a><br>
			 
		</c:if>
	</body>
</html>