<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 detail</title>
<link rel="stylesheet" href="../resources/css/main.css">
</head>
<body>
	<h1>게시글 상세 </h1>
		<ul>
			<li>
				<label>제목</label>
				<p>${notice.noticeTitle }</p>
			</li>
			<li>
				<label>내용</label>
				<p>${notice.noticeContent }</p>
			</li>
			<li>
				<label>작성자</label>
				<p>${notice.noticeWriter }</p>
			</li>
		</ul>
			<div>
				<button type="button" onclick="showModifyPage();">수정하기</button>
				<button>삭제하기</button>
				<a href="/notice/list.gg">목록으로</a>
			</div>
			<script>
				function showModifyPage() {
					const noticeNo = "${notice.noticeNo}";
					location.href="/notice/modify.gg?noticeNo="+noticeNo;
				}
			</script>
</body>
</html>