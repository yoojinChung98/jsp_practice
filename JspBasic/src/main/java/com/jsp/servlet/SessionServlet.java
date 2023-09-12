package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session/login")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SessionServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("로그아웃 요청이 들어옴!");
//		request.getSession().removeAttribute("user_id");
		
		//모든 세션 데이터 삭제하는 법(세션 객체 자체를 무효화)
		request.getSession().invalidate();
		
		//SessionServlet도 같은 JspBasic 출신이므로 상대경로로 아래처럼 지목해도 문제X
		response.sendRedirect("session_login.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("abc1234") && pw.equals("aaa1111!")) {

			
			/*
            - 세션은 http 통신 데이터를 유지하기 위한 수단으로 사용합니다.
            - 세션에 데이터를 저장할 때는 session 객체의 메서드 setAttribute()
             메서드를 사용합니다.
            - 해당 메서드의 첫번째 매개값으로 세션 데이터의 이름을 정하고, 두 번째 매개값으로
             세션에 저장할 값을 지정합니다.
            */
			HttpSession session = request.getSession();
			session.setAttribute("user_id", id);
			
			//세션의 유효기간 설정
			//초단위로 설정, 디폴드=1800초(=30분)
			//세션의 수명은 새로운 요청이 서버로 들어오면 초기화됨.
			session.setMaxInactiveInterval(60 * 60 * 24 * 30); //한달 유지
			//근데 브라우저 꺼지면 끝.(초기화)
			
			response.sendRedirect("/JspBasic/session/session_welcome.jsp");
		} else {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter w = response.getWriter();
            
            String htmlCode = "";
            htmlCode += "<script>\r\n"
                    + "        alert('로그인에 실패했습니다.');\r\n"
                    + "        history.back();\r\n"
                    + "    </script>\r\n"
                    + "";
            
            w.write(htmlCode);
            w.flush();
            w.close();
			
		}
	}

}
