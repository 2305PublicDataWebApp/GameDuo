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
              <a href="https://www.leagueoflegends.com/ko-kr/" class="top_link_area">
                <p class="txt_kor">롤<p>
                <h3 class="txt_eng">LOL</h3>
              </a>
					  </div>
				  </li>
				  <li class="event_banner_item">
				  	<div class="event_txt_wrap">
              <a href="https://df.nexon.com/pg/season9_seon?intro=yes" class="top_link_area">
                <p class="txt_kor">던전앤파이터<p>
                <h3 class="txt_eng">DUNGEON & FIGHER</h3>
              </a>
					 </div>
				  </li>
				  <li class="event_banner_item">
				  	<div class="event_txt_wrap">
				      <a href="https://overwatch.blizzard.com/ko-kr/" class="top_link_area">
                <p class="txt_kor">오버워치<p>
                <h3 class="txt_eng">OVER WATCH</h3>
              </a>
					  </div>
				  </li>
				  <li class="event_banner_item">
				  	<div class="event_txt_wrap">
				      <a href="https://www.pubg.com/ko/" class="top_link_area">
                <p class="txt_kor">배틀그라운드<p>
                <h3 class="txt_eng">BATTLE GROUND</h3>
              </a>
					  </div>
				  </li>
				  <li class="event_banner_item">
				  	<div class="event_txt_wrap">
              <a href="https://lostark.game.onstove.com/Promotion/Update/230913" class="top_link_area">
                <p class="txt_kor">로스트아크<p>
                <h3 class="txt_eng">LOST ARK</h3>
              </a>
					  </div>
				  </li>
				</ul>
		    </ul>
	    	<div class="container">
		    	<div class="content_area">
		    		<c:if test = "${memberId eq null}">
		    			<h2 class="non_session_txt session_txt">추천게임</h2>
		    		</c:if>
		    		<c:if test = "${memberId ne null}">
		    			<h2 class="session_txt"><strong>${memberName }</strong>님 ,환영합니다.</h2>
		    		</c:if>
		    		<p class="hash_txt">#최근 플레이 수 급증한</p>
		    		<div class="gamebox_wrap">
              <ul class="gamebox_cont">
                <li class="gamebox_item gamebox_item_01">
                  <a href="/resources/images/common/main_kv.jpg" class="bot_link_area">
                    <div class="img_area">
                      <img src="/resources/images/common/banner_01.jpg" alt="던전앤파이터">
                    </div>
                    <div class="game_txt_wrap">
                      <h3 class="game_name_txt">DUNGEON & FIGHER</h3>
                      <p class="game_type_txt">ACTION RPG</p>
                    </div>
                  </a>
                </li>
                <li class="gamebox_item gamebox_item_02">
                  <a href="https://www.leagueoflegends.com/ko-kr/" class="bot_link_area">
                    <div class="img_area">
                      <img src="/resources/images/common/banner_02_v3.jpg" alt="롤">
                    </div>
                    <div class="game_txt_wrap">
                      <h3 class="game_name_txt">LEAGUE of LEGENDS</h3>
                      <p class="game_type_txt">AOS</p>
                    </div>
                  </a>
                </li>
                <li class="gamebox_item gamebox_item_03">
                  <a href="https://overwatch.blizzard.com/ko-kr/" class="bot_link_area">
                    <div class="img_area">
                      <img src="/resources/images/common/banner_03.jpg" alt="오버워치">
                    </div>
                    <div class="game_txt_wrap">
                      <h3 class="game_name_txt">OVER WATCH</h3>
                      <p class="game_type_txt">HYPER FPS</p>
                    </div>
                  </a>
                </li>
                <li class="gamebox_item gamebox_item_04">
                  <a href="https://lostark.game.onstove.com/Promotion/Update/230913" class="bot_link_area">
                    <div class="img_area">
                      <img src="/resources/images/common/banner_04.jpg" alt="로스트아크">
                    </div>
                    <div class="game_txt_wrap">
                      <h3 class="game_name_txt">LOST ARK</h3>
                      <p class="game_type_txt">RPG</p>
                    </div>
                  </a>
                </li>
              </ul>
            </div>
       		</div>
			</div>
	    </main>
		<!-- 푸터 -->
    	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>
</html>