<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<link rel="stylesheet" href="/resources/css/board/board.css">
<link rel="stylesheet" href="/resources/css/notice/notice.css?after">
</head>
<body>
	<h1>공지사항 목록</h1>
		<table>
			<h1><a href="/index.jsp">Home</a></h1>
				<colgroup>
					<col width="10%"></col>
					<col width="10$"></col>
					<col width="40$"></col>
					<col width="10$"></col>
					<col width="10$"></col>
				</colgroup>
				<thead>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>내용</td>
						<td>작성자</td>
						<td>등록일</td>
					</tr>	
				</thead>
				<tbody>
						<c:forEach var = "notice" items="${NList}" varStatus="i">    
							<tr>
								<td>${i.count }</td>
								<c:url var = "detailUrl" value="/notice/detail.gg">
									<c:param name = "noticeNo" value = "${notice.noticeNo }"></c:param>
								</c:url>
								<td><a href="${detailUrl }">${notice.noticeTitle }</a></td>
								<td>${notice.noticeWrite }</td>
								<td>
									<fmt:formatDate pattern="yyyy-MM-dd" value="${notice.nCreateDate }"/>
								</td>
							</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr align="center">
						<td colspan="5">
							<c:if test="${pInfo.startNavi !=1}">
								<c:url var = "prevUrl" value="/notice/list.gg">
									<c:param name="page" value="${pInfo.startNavi-1 }"></c:param>
								</c:url> 
									 <a href="${prevUrl }">[이전]</a>
								</c:if>
								<c:forEach begin="${pInfo.startNavi }" end="${pInfo.endNavi }" var="p">
									<c:url var = "pageUrl" value="/notice/list.gg">
										<c:param name="page" value="${p }"></c:param>
									</c:url>
									<a href ="${pageUrl }">${p }&nbsp;</a>
								</c:forEach>
								<c:if test ="${pInfo.endNavi != naviTotalCount }">
									<c:url var = "nextUrl" value= "/notice/list.gg">
										<c:param name="page" value="${pInfo.endNavi+1 }"></c:param>
									</c:url>
									<a href = "${nextUrl }">[다음]</a>
								</c:if>
						</td>
					</tr>
					<tr>
						<td colspan="4">
								<form action="/notice/search.gg"  method="get">
									<select name="searchCondition">
										<option value="all">전체</option>
										<option value="writer">작성자</option>
										<option value="title">제목</option>
										<option value="content">내용</option>
									</select>
										<input type="text" name="searchKeyword" placeholder="검색어를 입력하세요">
										<input type="submit" value="검색">
								</form>
							</td>
				
				
						<td>
							<button type="button"
								onClick="location.href='/notice/write.gg'">글쓰기</button>
						</td>
					</tr>
				</tfoot>
		</table>
</body>
</html>