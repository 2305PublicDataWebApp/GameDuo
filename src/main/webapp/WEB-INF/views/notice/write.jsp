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
	<main class="main notice notice_write" id="notice_write">
    	<div class="container">
        <div class="notice_insert_wrap">
          <form action="/notice/write.gg" method="post" enctype="multipart/form-data">
            <h1 class="main_txt">게시글 등록</h1>
            <ul>
              <li>
                <label>제목</label>
                <input type = "text" name="noticeTitle">
              </li>
              <li>
                <label>내용</label>
                <textarea rows="4" cols="50" name="noticeContent"></textarea>
              </li>
              <li>
                <label>작성자</label>
                <span>${memberName }</span>
              </li>
            </ul>
            <div class="btn_wrap">
              <input type="submit" value="등록">
            </div>
          </form>
        </div>
		  </div>
    </main>
    <!-- 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>