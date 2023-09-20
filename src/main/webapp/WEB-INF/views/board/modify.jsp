<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<!-- head 파일 -->
		<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
	<body>
    <!-- 헤더 -->
		<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
		<main class="main board board_modify" id="board_modify">
      <div class="container">
        <div class="board_modify_wrap">
          <h1 class="main_txt">듀오찾기 수정페이지</h1>
          <form action="/board/modify.gg" method="post" enctype="multipart/form-data">
            <!-- 수정할 때, 리다이렉트 될 때 사용된다  -->
            <input type="hidden" name="boardNo" value="${board.boardNo }">
            <!-- 기존 업로드 파일 체크할 때 사용 (mybatis-config.xml 에 null되있으나 이거되있으나 노상관?) -->
            <input type="hidden" name="boardFilename" value="${board.boardFilename }">
            <input type="hidden" name="boardFileRename" value="${board.boardFileRename }">
            <input type="hidden" name="boardFilepath" value="${board.boardFilepath }">
            <input type="hidden" name="boardFileLength" value="${board.boardFileLength }">
            <ul>
              <li>
                <label>제목</label>
                <input type="text" name="boardTitle" value="${board.boardTitle }">
              </li>
              <li>
                <label>작성자</label>
                <input type="text" name="boardWriter" value="${board.boardWriter }" readonly>
              </li>
              <li>
                <label>모집게임</label>
                <input type="text" name="gameType" value="${board.gameType }" readonly>
              </li>
              <li>
                <label>모집인원</label>
                <input type="number" name="teamSize" value="${board.teamSize }">
              </li>
              <li>
                <label>일정</label>
                <input type="text" name="schedule" value="${board.schedule }">
              </li>
              <li>
                <label>내용</label>
                <textarea rows="4" cols="50" name="boardContent">${board.boardContent }</textarea>
              </li>
              <li>
                <label>첨부파일</label>
                <a href="../resources/buploadFiles/${board.boardFilename }" class="a_tag" download>${board.boardFilename }</a>
                <button type="button" class="btn_delete" onclick="deleteAttachment();">파일 삭제</button>
                <input type="file" name="uploadFile">
              </li>
            </ul>
            <div class="btn_wrap">
              <input type="submit" value="수정완료">
              <input type="button" value="취소하기" onclick="goBack();">
            </div>
          </form>
        </div>
      </div>
    </main>
    <!-- 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
		<script>
		
		function goBack() {
		    window.history.back();
		}	
		
		function deleteAttachment() {
		    // 첨부 파일 링크 및 파일 삭제 버튼 요소 가져오기
		    var fileLink = document.querySelector("a[href='../resources/buploadFiles/${board.boardFilename }']");
		    var deleteButton = document.querySelector("button[type='button'][onclick='deleteAttachment();']");

		    // 파일 삭제 여부 확인
		    if (confirm("첨부 파일을 삭제하시겠습니까?")) {
		        // 첨부 파일을 제거하고 파일 삭제 버튼 숨기기
		        fileLink.parentNode.removeChild(fileLink);
		        deleteButton.style.display = "none";

		        // 파일 삭제를 서버에 전달하기 위해 관련 hidden input 필드 값 업데이트
		        var uploadFileInput = document.querySelector("input[type='file'][name='uploadFile']");
		        var fileDeleteInput = document.createElement("input");
		        fileDeleteInput.type = "hidden";
		        fileDeleteInput.name = "deleteFile";
		        fileDeleteInput.value = "true";
		        uploadFileInput.parentNode.appendChild(fileDeleteInput);
		    }
		}
		</script>
	</body>
</html>