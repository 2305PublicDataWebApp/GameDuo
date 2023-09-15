<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="/notice/write.gg" method="post" enctype="multipart/form-data">
			<ul>
				<!-- <li>
					<label>번호</label>
					<input type = "text" name="noticeNo">
				</li> -->
				<li>
					<label>제목</label>
					<input type = "text" name="noticeTitle">
				</li>
				<li>
					<label>내용</label>
					<textarea rows="4" cols="50" name="noticeContent"></textarea>
				</li>
				<li>
					<label>작성자</label>
					<span>${noticeAdmin }</span>
				</li>
			</ul> 
			<div>
				<input type="submit" value="등록">
			</div>
	</form>
</body>
</html>