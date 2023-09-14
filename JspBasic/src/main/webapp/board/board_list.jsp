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

	<h2>게시글 목록</h2>
	
		<c:choose>
			<c:when test="${boardList.size() == 0}">
				<h3>*** 작성된 게시물이 하나도 없습니다.</h3>
			</c:when>
			<c:otherwise>
				<table border="1">
					<tr>
						<th>번호</th>
						<th>작성자</th>
						<th>제목</th>
						<th>작성일</th>
						<th>비고</th>
					</tr>
			
					<!-- 
						c:forEach의 속성인 varStatus를 활용하면
						현재 사용중인 반복문의 여러가지 속성을 사용할 수 있습니다.
						
						${status.count}: 1부터의 순서 (반복문의 회차를 나타내는데 사용할 수 있음)
						${status.index}: 0부터의 순서
						${status.current}: 현재 아이템(그냥 var로 지목해도 상관없어서.. 별로 안쓸듯)
					-->
					<c:forEach var="b" items="${boardList}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${b.writer}</td>
							<!-- BoardVO 가 가지고 있는 속성 중 writer 꺼내와! -->
							<td>
								<a href="/JspBasic/content.board?bId=${status.count}">${b.title}</a>
							</td>
							<td>
								<fmt:parseDate value="${b.regDate}" pattern="yyyy-MM-dd'T'HH:mm:ss"
											var="parsedDateTime" type="both"/> <!-- 여기의 패턴은 ${b.regDate}의 데이터 패턴이 어떤지 규정해서 알려주는거고(이자리에 있는 수는 이런걸 의미해~) -->
								<fmt:formatDate value="${parsedDateTime}" pattern="yyyy년 MM월 dd일 HH시 mm분"/> <!-- 여기의 패턴은 이 데이터들을 이런 패턴으로 보여줬으면 좋겠어~ 를 표현. -->
							</td>
							<td><a href="/JspBasic/delete.board?bId=${status.count}">[삭제]</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>

		<br/>
		<!-- 
			
		 -->
		<form action="/JspBasic/search.board">
			<input type="text" name="keyword" placeholder="작성자 이름을 입력하세요."/>
			<input type="submit" value="검색"/>
		</form>


	<br/>
	
	<a href="/JspBasic/write.board">새 글 작성하기</a>
</body>
</html>