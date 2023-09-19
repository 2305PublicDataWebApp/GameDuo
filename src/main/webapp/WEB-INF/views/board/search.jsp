<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>듀오찾기 목록</title>
		<link rel="stylesheet" href="../resources/css/board/board.css">
	</head>
	<body>
		<table>
			<colgroup>
				<col width="10%"></col>
				<col width="40%"></col>
				<col width="10%"></col>
				<col width="15%"></col>
				<col width="10%"></col>
			</colgroup>
			<thead>
				<tr>
					<th>게임종류</th>
					<th>제목</th>
					<th>작성자</th>
					<th>모집인원</th>
					<th>일정</th>
					<th>등록일시</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${sList}">
                    <tr>
                        <td>${board.gameType}</td>
                        <td>${board.boardTitle}</td>
                        <td>${board.boardWriter}</td>
                        <td>${board.teamSize} 명</td>
                        <td>${board.schedule}</td>
                        <td>${board.bCreateDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
			<tfoot>	
				<tr align="center">
					<td colspan="5">
						<c:forEach begin="${pInfo.startNavi }" end="${pInfo.endNavi }" var="p">
							<c:url var="pageUrl" value="/board/search.gg">
								<c:param name="page" value="${p }"></c:param>
								<c:param name="searchCondition" value="${searchCondition }"></c:param>
								<c:param name="searchKeyword" value="${searchKeyword }"></c:param>
							</c:url>
							<a href="${pageUrl }">${p }</a>&nbsp;
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<form action="/board/search.gg"  method=get>
							<select name="searchCondition">
								<option value="all" <c:if test="${searchCondition == 'all' }">selected</c:if>>전체</option>
								<option value="game" <c:if test="${searchCondition == 'game' }"></c:if>>게임종류</option>
								<option value="writer" <c:if test="${searchCondition == 'writer' }">selected</c:if>>작성자</option>
								<option value="title" <c:if test="${searchCondition == 'title' }">selected</c:if>>제목</option>
								<option value="content" <c:if test="${searchCondition == 'content' }"></c:if>>내용</option>
							</select>
							<input type="text" name="searchKeyword" placeholder="검색어를 입력하세요" value="${searchKeyword }">
							<input type="submit" value="검색">
						</form>
					</td>
					<td>
						<button type="button" onClick="location.href='/board/write.gg'">글쓰기</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</body>
</html>