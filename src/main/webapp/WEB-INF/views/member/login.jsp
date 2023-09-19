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
		<main class="main member member_login" id="member_login">
			<div class="container">
				<div class="login_section">
          <form action="/member/login.gg" method="post">
            <div class="login_wrap">
            	<input type="text" placeholder="듀오GG (아이디입력)" name="memberId" class="login_id">
              <input type="password" placeholder="비밀번호입력" name="memberPwd" class="login_pwd">
            </div>
            <div class="btn_wrap">
              <input type="submit" value="듀오 ID 로그인" class="btn_submit">
            </div>
          </form>
        </div>
			</div>
		</main>
		<!-- 푸터 -->
    	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>
</html>