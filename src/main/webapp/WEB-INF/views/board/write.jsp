<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>듀오찾기 글쓰기</title>
	</head>
	<body>
		<h1>듀오찾기 글쓰기</h1>
		<form action="/board/write.gg" method="post" enctype="multipart/form-data">
			<ul>
				<li>
					<label>제목</label>
					<input type="text" name="boardTitle">
				</li>
				<li>
					<label>작성자</label>
					<input type="text" name="boardWriter">
				</li>
				<li>
					<label>모집게임</label>
					<select>
						<option>롤</option>
						<option>오버워치</option>
						<option>배틀그라운드</option>
						<option>로스트아크</option>
						<option>기타</option>
					</select>
				</li>
				<li>
					<label>모집인원</label>
					<select>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
					</select>
				</li>
				<li>
					<label>내용</label>
					<textarea rows="4" cols="50" name="boardContent"></textarea>
				</li>
				<li>
					<label>첨부파일</label>
					<!-- String으로 받을 수 없고 변환작업이 필요함 -->
					<input type="file" name="uploadFile">
				</li>
			</ul>
			<div>
				<input type="submit" value="등록">
			</div>
		</form>
	</body>
</html>