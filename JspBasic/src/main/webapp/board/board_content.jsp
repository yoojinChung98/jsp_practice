<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- <c:forEach var="c" items="${boardList}" varStatus="idx">
		<c:if test="${idx.count == bId }">
			제목: ${c.title}</br>
			작성자: ${c.writer }</br>
			작성시간: ${c.regDate } </br>
			<p>
				${c.content}
			</p>
		</c:if>
	</c:forEach> --%>
	
	
	<%-- <p>
	제목: ${vo1.title}</br>
	작성자: ${vo1.writer }</br>
	작성시간: ${vo1.regDate } </br>
	</p>
	<p>
		${vo1.content}
	</p> --%>
	
	
	<h2>${boardNo}번 게시물 내용</h2>
	<p>
		 # 작성자: ${content.writer} <br/>
		 # 제목: ${content.title } <br/>
		 # 내용: <textarea rows="5" readonly>${content.content }</textarea>
	</p>
	
	<a href="/JspBasic/list.board">글 목록 보기</a>
	<a href="/JspBasic/modify.board?bId=${boardNo }">글 수정하기</a>
	
	
	
	

</body>
</html>