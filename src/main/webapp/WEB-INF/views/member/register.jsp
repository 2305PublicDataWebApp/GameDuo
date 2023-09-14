<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<form action="/member/register.gg" method="post">
					<h2>회원가입</h2>
				</form>
			</div>
		</main>
		<!-- 푸터 -->
    	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>
</html>