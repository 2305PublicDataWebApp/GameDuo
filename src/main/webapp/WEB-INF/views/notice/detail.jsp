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
	<main class="main notice notice_detail" id="notice_detail">
		<div class="container">
			<h1>게시글 상세 </h1>
			<ul>
				<li>
					<label>제목</label>
					<p>${notice.noticeTitle }</p>
				</li>
				<li>
					<label>내용</label>
					<p>${notice.noticeContent }</p>
				</li>
				<li>
					<label>작성자</label>
					<p>${notice.noticeAdmin }</p>
				</li>
			</ul>
			<div>
				<button type="button" onclick="showModifyPage();">수정하기</button>
				<button>삭제하기</button>
				<a href="/notice/list.gg">목록으로</a>
			</div>
		</div>
	</main>
	<!-- 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<script>
		function showModifyPage() {
			const noticeNo = "${notice.noticeNo}";
			location.href="/notice/modify.gg?noticeNo="+noticeNo;
		}
	</script>
</body>
</html>