<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 상세</title>
	</head>
	<body>
		<ul>
			<li>
				<label>제목</label>
				<span>${board.boardTitle }</span>
			</li>
			<li>
				<label>작성자</label>
				<span>${board.boardWriter }</span>
			</li>
			<li>
				<label>모집게임</label>
				<span>${board.gameType }</span>
			</li>
			<li>
				<label>모집인원</label>
				<span>${board.teamSize }</span>
			</li>
			<li>
				<label>일정</label>
				<span>${board.schedule }</span>
			</li>
			<li>
				<label>내용</label>
				<p>${board.boardContent }</p>
			</li>
			<li>
				<label>첨부파일</label>
				<a href="${board.boardFilepath }" download>${board.boardFilename }</a>
			</li>
		</ul>
		<br><br>
		<div>
			<button type="button" onclick="showModifyPage();">수정하기</button>
			<button>삭제하기</button>
			<button type="button" onclick="showBoardList();">목록으로</button>
		</div>
		<!-- 댓글 등록 -->
		<hr>
		<form action="/reply/add.gg" method="post">
		<input type="hidden" name="refBoardNo" value="${board.boardNo }">
			<table width="500" border="1">
				<tr>
					<td>
						<textarea rows="3" cols="55" name="replyContent"></textarea>
					</td>
					<td>						
						<input type="submit" value="댓글작성">
					</td>
				</tr>
			</table>
		</form>
		<!-- 댓글 목록 -->
		<table width="550" border="1">
			<c:forEach var="reply" items="${rList }">
			<tr>
				<td>${reply.replyWriter }</td>
				<td>${reply.replyContent }</td>
				<td>${reply.rCreateDate }</td>
				<td>
					<a href="javascript:void(0)" onclick="showReplyModifyForm(this,'${reply.replyContent }');">수정하기</a>
					<a href="javascript:void(0)" onclick="deleteReply();">삭제하기</a>
				</td>
			</tr>
			<tr id="replyModifyForm" style="display:none;">
					<td colspan="3"><input id="replyContent" type="text" size="50" name="replyContent" value=${reply.replyContent }></td>
					<td><input type="button" onclick="replyModify(this,'${reply.replyNo}','${reply.refBoardNo }');" value="완료"></td>
			</tr>
			</c:forEach>
		</table>
		<script>
			function showModifyPage() {
				const boardNo = "${board.boardNo }";
				location.href="/board/modify.gg?boardNo="+boardNo;
			}
			function showBoardList() {
				location.href="/board/list.gg";
			}
			function replyModify(obj, replyNo, refBoardNo){
				const form = document.createElement("form");
				form.action = "/reply/update.gg";
				form.method = "post";
				const input = document.createElement("input");
				input.type = "hidden";
				input.value = replyNo;
				input.name = "replyNo";
				const input2 = document.createElement("input");
				input2.type = "hidden";
				input2.value = refBoardNo;
				input2.name = "refBoardNo";
				const input3 = document.createElement("input");
				input3.type = "text";					
				input3.value = obj.parentElement.previousElementSibling.childNodes[0].value;
				input3.name = "replyContent";
				form.appendChild(input);
				form.appendChild(input2);
				form.appendChild(input3);
				document.body.appendChild(form);
				form.submit();
			}
			function showReplyModifyForm(obj, replyContent){
			obj.parentElement.parentElement.nextElementSibling.style.display="";
			}
		</script>
	</body>
</html>