<%@page import="user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		//getAttribute는 Object형을 반환. User의 메서드 등을 사용하려면 형변환 필요
		User user = (User)session.getAttribute("member");
	%>
	
	<p>
		# 이름: <%=user.getUserName() %><br/>
		# 아이디: <%=user.getUserId() %> <br/>
		# 이메일: <%=user.getUserEmail() %> <br/>
		# 비밀번호: <%=user.getUserPw() %>
	</p>
	
	<hr/>
	
	<p>
		<!-- el을 이용해서 객체 내의 필드값을 꺼낼 때는
			변수명(즉, getter메서드의 이름) 을 입력하면 해당 필드의 getter 메서드를 알아서 호출합니다.
			# 이름: ${sessionScope.member.getUserName()} 필요X  -->
		# 이름: ${sessionScope.member.userName} <br/>
		# 아이디: ${member.userId} <br/>
		# 이메일: ${member.userEmail} <br/>
		# 비밀번호: ${member.userPw} 
	</p>

</body>
</html>