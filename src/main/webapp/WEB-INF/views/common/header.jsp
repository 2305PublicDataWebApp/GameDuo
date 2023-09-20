<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <header id="header">
	  <div class="container">
	    <h1 class="logo"><a href="/index.jsp">로고</a></h1>
	    <ul class="menu_right">
	    	<c:if test = "${memberId eq null}">
	    		<li class="menu_right_item"><a href="/member/register.gg">회원가입</a></li>
	    		<li class="menu_right_item"><a href="/member/login.gg">로그인</a></li>
	    		<li class=menu_right_item><a href="/notice/list.gg">공지사항</a></li>
	    		<li class=menu_right_item><a href="/board/list.gg">게시글</a></li>
	    	</c:if>
	    	
	    	<c:if test = "${memberId ne null}">
<%-- 				<strong class="session">${memberName }</strong>님 환영합니다.<br> --%>
				<li class="menu_right_item"><a href="/member/logout.gg">로그아웃</a></li>
				<li class="menu_right_item"><a href="/member/mypage.gg">마이페이지</a></li>
				<li class=menu_right_item><a href="/notice/list.gg">공지사항</a></li>
				<li class=menu_right_item><a href="/board/list.gg">게시글</a></li>
			</c:if>
	    </ul>
	  </div>
 </header>