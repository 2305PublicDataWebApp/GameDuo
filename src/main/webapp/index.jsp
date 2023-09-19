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
	    <main class="main mainpage" id="mainpage">
	    	<ul class="main_kv">
		    	<li class="kv_item">
		    		<img src="/resources/images/common/main_kv.jpg" alt="선계업데이트">
		    	</li>
		    	<ul class="event_banner">
				  <li class="event_banner_item">
					  <div class="event_txt_wrap">
					      <p>롤<p>
					      <h3>LOL</h3>
					  </div>
				  </li>
				  <li class="event_banner_item">
				  	<div class="event_txt_wrap">
					      <p>던전앤파이터<p>
					      <h3>Dungeon & Fighter</h3>
					 </div>
				  </li>
				  <li class="event_banner_item">
				  	<div class="event_txt_wrap">
					      <p>오버워치<p>
					      <h3>Over Watch</h3>
					  </div>
				  </li>
				  <li class="event_banner_item">
				  	<div class="event_txt_wrap">
					      <p>배틀그라운드<p>
					      <h3>Battle Ground</h3>
					  </div>
				  </li>
				  <li class="event_banner_item">
				  	<div class="event_txt_wrap">
					      <p>로스트아크<p>
					      <h3>Lost Ark</h3>
					  </div>
				  </li>
				</ul>
		    </ul>
	    	<div class="container">
		    	dd
		    	

			</div>
	    </main>
		<!-- 푸터 -->
    	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>
</html>