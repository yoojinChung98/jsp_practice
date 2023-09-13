package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//  context route는 JspBasic/src/main/webapp 인데, src/main/webapp은 우리가 처음 프로젝트를 만들 때
//이 부분을 contextpath로 설정을 했기 때문에 숨김처리가 된거다~ 라고 보면 될 것 같다!
@WebServlet("/cookie/login")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CookieServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("kim1234") && pw.equals("kkk1111!")) {
			
			//# 쿠키 생성 방법!
			// 1. 쿠키 객체를 생성 - 생성자의 매개값으로 쿠키의 이름과 저장할 데이터(String만 허용) 입력
			Cookie loginCoo = new Cookie("login_cookie", id);
			
			// 2. 쿠키 클래스의 setter 메서드로 쿠키의 속성 설정. 수명은 반드시 설정할 것!(수명을 지정하지 않으면 쿠키를 쓰지 않겠다는 말)
			//쿠키의 유효시간 설정(초) 1시간 -> 60*60
			loginCoo.setMaxAge(5);
			
			// 3. http 응답 시 response 객체에 생성된 쿠키를 탑재해서 클라이언트에게 전송.
			response.addCookie(loginCoo);
			
			// 사용자가 아이디 기억하기 체크박스를 체크했는지의 여부 확인.
			//체크박스를 체크하면 value 가 오고, 체크하지 않으면 null이 옴 if로 체크해서 null은 걸러야 함
			if(request.getParameter("rememberId") != null) {
				Cookie idMemory = new Cookie("remember_id",id);
				idMemory.setMaxAge(30);
				response.addCookie(idMemory);
			}
			
			response.sendRedirect("/JspBasic/cookie/cookie_welcome.jsp");
			
		} else {
			response.sendRedirect("cookie_login.jsp");
		}
	}

}
