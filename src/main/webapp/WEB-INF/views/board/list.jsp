<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
	<html>
		<!-- head 파일 -->
		<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
	<body>
		<!-- 헤더 -->
		<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
		<main class="main board board_list" id="board_list">
      <div class="container">
        <div class="board_list_wrap">
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
              <c:forEach var="board" items="${bList }" varStatus="i">
                   <tr>
                  <td>${board.gameType }</td>
                  <c:url var="detailUrl" value="/board/detail.gg">
                    <c:param name="boardNo" value="${board.boardNo}"></c:param>
                  </c:url>
                  <td><a href="${detailUrl }">${board.boardTitle }</a></td>
                  <td>${board.boardWriter }</td>
                  <td>
                    ${board.teamSize } 명
                  </td>
                  <td>${board.schedule }</td>
                  <td>
                    <fmt:formatDate pattern="yyyy-MM-dd" value="${board.bCreateDate }"/>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
            <tfoot>
              <tr align="center">
                <td colspan="5">
                  <c:if test="${pInfo.startNavi != 1}">
                    <c:url var="prevUrl" value="/board/list.gg">
                      <c:param name="page" value="${pInfo.startNavi-1}"></c:param>
                    </c:url>
                    <a href="${prevUrl }">[이전]</a>
                  </c:if>
                  <c:forEach begin="${pInfo.startNavi }" end="${pInfo.endNavi }" var="p">
                    <c:url var="pageUrl" value="/board/list.gg">
                      <c:param name="page" value="${p }"></c:param>
                    </c:url>
                    <a href="${pageUrl }">${p }</a>&nbsp;
                  </c:forEach>
                  <c:if test="${pInfo.endNavi != naviTotalCount}">
                    <c:url var="nextUrl" value="/board/list.gg">
                      <c:param name="page" value="${pInfo.endNavi+1}"></c:param>
                    </c:url>
                    <a href="${nextUrl }">[다음]</a>
                  </c:if>
                </td>
              </tr>
              <tr>
                <td colspan="4">
                  <form action="/board/search.gg"  method=get>
                    <select name="searchCondition">
                      <option value="all">전체</option>
                      <option value="game">게임종류</option>
                      <option value="writer">작성자</option>
                      <option value="title">제목</option>
                      <option value="content">내용</option>
                    </select>
                    <input type="text" name="searchKeyword" placeholder="검색어를 입력하세요">
                    <input type="submit" value="검색">
                  </form>
                </td>
                <td>
                  <button type="button" onClick="location.href='/board/write.gg'">글쓰기</button>
                </td>
              </tr>
            </tfoot>
          </table>
        </div>
      </div>
    </main>
    <!-- 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>
</html>