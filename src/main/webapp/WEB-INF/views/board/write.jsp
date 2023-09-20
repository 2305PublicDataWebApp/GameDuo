<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<!-- head 파일 -->
		<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
	<body>
		<!-- 헤더 -->
		<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
		<main class="main board board_write" id="board_write">
      <div class="container">
        <div class="board_insert_wrap">
          <h1>듀오찾기 글쓰기</h1>
          <form action="/board/write.gg" method="post" enctype="multipart/form-data">
            <ul>
              <li>
                <label>제목</label>
                <input type="text" name="boardTitle">
              </li>
              <li>
                <label>작성자</label>
                <span>${memberName }</span>
              </li>
              <li>
                <label>모집게임</label>
                <select id="gameType" name="gameType">
                    <option value="롤">롤</option>
                    <option value="오버워치">오버워치</option>
                    <option value="배틀그라운드">배틀그라운드</option>
                    <option value="로스트아크">로스트아크</option>
                    <option value="던전앤파이터">"던전앤파이터"</option>
                    <option value="기타">기타</option>
                </select>
              </li>
              <li>
                <label>모집인원</label>
                <input type="number" name="teamSize">
              </li>
              <li>
                <label>일정</label>
                <input type="text" name="schedule">
              </li>
              <li>
                <label>내용</label>
                <textarea rows="4" cols="50" name="boardContent"></textarea>
              </li>
              <li>
                <label>첨부파일</label>
                <input type="file" name="uploadFile">
              </li>
            </ul>
            <div>
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