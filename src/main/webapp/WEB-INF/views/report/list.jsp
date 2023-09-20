<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<!-- head 파일 -->
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
<body>
	<!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<main class="main report report_list" id="report_list">
		<div class="container">
			<div class="report_list_wrap">
        <h1 class="main_txt">신고게시글 목록</h1>
        <table>
          <colgroup>
            <col width="15%"></col>
            <col width="40%"></col>
            <col width="10%"></col>
            <col width="15%"></col>
          </colgroup>
          <thead>
            <tr>
              <td>번호</td>
              <td>제목</td>
              <td>작성자</td>
              <td>등록일</td>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="report" items="${rList}" varStatus="i">
              <tr>
                <td>${report.reportNo }</td>
                <c:url var="detailUrl" value="/report/detail.gg">
                  <c:param name="reportNo" value="${report.reportNo }"></c:param>
                </c:url>
                <td><a href="${detailUrl }">${report.reportTitle }</a></td>
                <td>${report.reportWriter }</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd"
                    value="${report.rCreateDate }" /></td>
              </tr>
            </c:forEach>
          </tbody>
          <tfoot>
            <tr align="center" class="paging_area">
              <td colspan="5"><c:if test="${pInfo.startNavi !=1}">
                  <c:url var="prevUrl" value="/report/list.gg">
                    <c:param name="page" value="${pInfo.startNavi-1 }"></c:param>
                  </c:url>
                  <a href="${prevUrl }">[이전]</a>
                </c:if> <c:forEach begin="${pInfo.startNavi }" end="${pInfo.endNavi }"
                  var="p">
                  <c:url var="pageUrl" value="/report/list.gg">
                    <c:param name="page" value="${p }"></c:param>
                  </c:url>
                  <a href="${pageUrl }">${p }</a>&nbsp;
                  </c:forEach> <c:if test="${pInfo.endNavi != naviTotalCount }">
                  <c:url var="nextUrl" value="/report/list.gg">
                    <c:param name="page" value="${pInfo.endNavi+1 }"></c:param>
                  </c:url>
                  <a href="${nextUrl }">[다음]</a>
                </c:if></td>
            </tr>
            <tr>
              <td colspan="4">
                <form action="/report/search.gg" method="get">
                  <select name="searchCondition">
                    <option value="all">전체</option>
                    <option value="writer">작성자</option>
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                  </select> <input type="text" name="searchKeyword"
                    placeholder="검색어를 입력하세요"> <input type="submit" value="검색">
                </form>
              </td>
              <td>
             	 <button type="button" onclick="location.href='/report/write.gg'">글쓰기</button>
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