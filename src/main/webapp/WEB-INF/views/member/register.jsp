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
		<main class="main member member_register" id="member_register">
			<div class="container">
				<div class="register_wrap">
          <form action="/member/register.gg" method="post">
            <h2 class="main_txt">회원가입</h2>
            <ul>
              <li class="info_line">
                <label for="memberId">아이디</label>
                <input type="text" id="memberId" name="memberId">
              </li>
              <li class="info_line">
                <label for="memberPw">비밀번호</label>
                <input type="password" id="memberPw" name="memberPwd">
              </li>
              <li class="info_line">
                <label for="memberAge">나이</label>
                <input type="text" id="memberAge" name="memberAge">
              </li>
              <li class="info_line">
                <label for="memberName">이름</label>
                <input type="text" id="memberName" name="memberName">
              </li>
              <li class="info_line info_gender">
                <label>성별</label>
                <div class="check_radio">
                남<input type="radio" id="member-gender" name="memberGender" value="남" checked>
                여<input type="radio" id="member-gender" name="memberGender" value="여">
                </div>
              </li>
              <li class="info_line">
                <label for="memberEmail">이메일</label>
                <input type="text" id="memberEmail" name="memberEmail">
              </li>
              <li class="info_line">
                <label for="memberPhone">전화번호</label>
                <input type="text" id="memberPhone" name="memberPhone">
              </li>
              <li class="info_line info_address">
                <label for="member-address">주소</label>
                <input type="text" id="member-address" name="memberAddress">
                <input type="button" class="address_btn" onclick="sample4_execDaumPostcode();" value="주소 검색">
              </li>
            </ul>
            <div class="btn_wrap">
	             <input type="submit" value="가입하기" class="btn btn_submit">
	             <input type="reset" value="초기화" class="btn btn_reset">
	           </div>
          </form>
        </div>
			</div>
		</main>
		<!-- 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>
</html>