package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//아노테이션. 기능이 있는 주석; @WebServlet 따로 서블릿을 등록하고 url mapping하는 과정을 생략할 수 있음.
@WebServlet("/resp")
public class ResponseServlet extends HttpServlet {
	//객체를 구분하기 위한 번호를 직접 입하는 것.인데 별로 지금은 신경쓰지 않아도 됌!
	private static final long serialVersionUID = 1L;
	
       
    
    public ResponseServlet() {
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청과 함께 넘어온 아이디를 얻자
//		String age = request.getParameter("customerAge");
		int age = Integer.parseInt(request.getParameter("customerAge"));
		
		//나이에 따라 각각 다른 화면으로 보내줄 것임.
		if(age>=20) {
			//성인 페이지로 이동시키 고 싶어요(즉, 여기서 바로 이동시키는게 아니야! 여기서 문자열로 html로 다 쓸거야..?)
			
			response.sendRedirect("/JspBasic/response/res_adult.jsp");
			
		} else {
			//미성년자 페이지로 이동시키기 고 싶어요
			response.sendRedirect("/JspBasic/response/res_underage.jsp");
		}
	}

}
