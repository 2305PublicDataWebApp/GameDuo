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
	<main class="main notice notice_modify" id="notice_modify">
		<div class="container">
			<h1>공지사항 수정 modify</h1>
			<form action="/notice/modify.gg" method="post" enctype="multipart/form-data">
				<input type ="hidden" name = "noticeNo" value="${notice.noticeNo }">
				<ul>
					<li>
						<label>제목</label>
						<input type="text" name="noticeTitle" value="${notice.noticeTitle }">
					</li>
					<li>
						<label>내용</label>
						<textarea rows="4" cols="50" name="noticeContent">${notice.noticeContent }</textarea>
					</li>
					<li>
						<label>작성자</label>
						<input type="text" name="noticeAdmin" value="${notice.noticeAdmin }" readonly>
					</li>
					
				</ul>
				<div>
					<input type="submit" value="등록">
				</div>
			</form>
		</div>
	</main>
	<!-- 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>