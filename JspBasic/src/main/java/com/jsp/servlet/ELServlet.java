package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;

@WebServlet("/el/obj")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ELServlet() {
    	super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
		
		User user = new User(
				request.getParameter("id"),
				request.getParameter("pw"),
				request.getParameter("name"),
				request.getParameter("email")
		);
		//두고두고 쓸거면 변수로 받고, 아니면 그냥 이렇게 바로바로 불러쓰세용
		
		//session 여러번 쓸 떄
//		HttpSession session = request.getSession();
		
		//우리는 한번만 쓸거니까
		request.getSession().setAttribute("member", user);
		response.sendRedirect("/JspBasic/EL/el_obj2.jsp");
		
		
		
	}

}
