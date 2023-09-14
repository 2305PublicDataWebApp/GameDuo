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
					<ul>
						<li>
							<label>아이디</label>
							<input type="text" name="memberId">
						</li>
						<li>
							<label>비밀번호</label>
							<input type="text" name="memberId">
						</li>
						<li>
							<label>나이</label>
							<input type="text" name="memberId">
						</li>
					</ul>
					
				</form>
			</div>
		</main>
		<!-- 푸터 -->
    	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>
</html>