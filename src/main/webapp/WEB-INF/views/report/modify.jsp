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
	<main class="main report report_modify" id="report_modify">
		<div class="container">
			<div class="report_modify_wrap">
        <h1 class="main_txt">공지사항 수정 modify</h1>
        <form action="/report/modify.gg" method="post" enctype="multipart/form-data">
          <input type ="hidden" name = "reportNo" value="${report.reportNo }">
          <ul>
            <li>
              <label>제목</label>
              <input type="text" name="reportTitle" value="${report.reportTitle }">
            </li>
            <li>
              <label>작성자</label>
              <input type="text" name="reportWriter" value="${report.reportWriter }" readonly>
            </li>
            <li>
              <label>내용</label>
              <textarea rows="4" cols="50" name="reportContent">${report.reportContent }</textarea>
            </li>
          </ul>
          <div class="btn_wrap">
            <input type="submit" value="수정">
          </div>
        </form>
      </div>
		</div>
	</main>
	<!-- 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>