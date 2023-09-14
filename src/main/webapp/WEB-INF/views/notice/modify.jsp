<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정 modify</title>
</head>
<body>
		<h1>공지사항 수정 modify</h1>
		<form action="/notice/modify.kh" method="post" enctype="multipart/form-data">
			<input type = "hidden" name = "noticeNo" value="${notice.noticeNo }">

			<ul>
				<li>
					<label>제목</label>
					<input type="text" name="noticeTitle" value="${notice.noticeTitle }">
				</li>
				<li>
					<label>내용</label>
					<textarea rows="4" cols="50" name="noticeContent">${notice.noticeContent }</textarea>
				</li>
				<li>
					<label>작성자</label>
					<input type="text" name="noticeWriter" value="${notice.noticeWriter }" readonly>
				</li>
				
			</ul>
			<div>
				<input type="submit" value="등록">
			</div>
		</form>
</body>
</html>