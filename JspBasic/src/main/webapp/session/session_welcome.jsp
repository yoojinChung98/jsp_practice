<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%-- 
    <%
    	String id = (String)session.getAttribute("user_id");
    
    	if(id == null) {
    		response.sendRedirect("session_login.jsp");
    	} else { //else 브레이스는 html 모든 내용을 사용할거니 그 마지막에 닫으면 됨
    %>
    --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%--
	<% 
	/*
	내장 객체 session에서 데이터를 가져오는 메서드는 getAttribute() 입니다.
	매개값으로 가져올 세션 데이터의 이름을 적습니다.
	해당 데이터가 존재하지 않는다면 null이 리턴됩니다.
	
	세션에 저장한 데이터는 브라우저 창이 종료될 때 까지, 혹은
	세션의 유효시간이 만료되기 전까지 웹 어플리케이션의 모든 jsp파일에서 사용이 가능합니다.
	세션의 기본 유호시간은 30분 입니다.
	*/
	%>

	<h2><%=id %>님 환영합니다!</h2>
	<!-- 우리가 작성한 이 내용을 톰캣이 스스로 html파일을 만들어 재작성해줘!!ㅎㅎ -->
	
	<h2>${sessionScope.user_id}님 환영합니다!</h2>
	<!-- el 사용함. -->
	 --%>
	
	<c:if test="${user_id == null}">
		<script>
			alert('로그인 하지 않은 유저는 접근할 수 없습니다.');
			location.href='session_login.jsp';
		</script>
	</c:if>
	
	<h2>${user_id}님 환영합니다!</h2>
	
	<!-- a태그는 get요청을 보냄 -->
	<a href="/JspBasic/session/login">로그아웃하기</a>
	
	

</body>
</html>
