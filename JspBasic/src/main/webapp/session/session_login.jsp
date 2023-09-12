<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- if(session.getAttribute("user_id") == null) { --%>
	<c:choose>
	
		<c:when test="${user_id == null}">
			<form action="/JspBasic/session/login" method="post">
				<!--"/JspBasic/session/login" 이런 경로는 실제로 존재하지 않아! 가상경로이고 우리가 여러 작업을 통해서 위의 가상경로와 실제로 작동할 서블릿을 연결해놓은 거야!-->
				아이디: <input type="text" name="id" size="10" placeholder="ID"/> <br/>
				<input type="password" name="pw" size="10" placeholder="PW"/> <br/>
				<input type="submit" value="로그인"/>		
			</form>
		</c:when>
	<%-- } else { --%>
		<c:otherwise>
			<p>
				<%=session.getAttribute("user_id")%>님이 현재 로그인 중입니다~ <br/>
				<a href="session_welcome.jsp">웰컴 페이지로</a>
			</p>
		</c:otherwise>
		
	<%-- } --%>
	</c:choose>

</body>
</html>