package com.jsp.board.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.BoardRepository;
import com.jsp.board.model.BoardVO;


@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardController() {
        super();
    }


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getMethod().equals("POST")) {
			req.setCharacterEncoding("UTF-8");
		}
	
		String uri = req.getRequestURI();
		uri = uri.substring(req.getContextPath().length()+1, uri.lastIndexOf("."));
		
		System.out.println("정제된 uri: "+uri);
		
		switch (uri) {
		case "write" : 
			System.out.println("글쓰기 페이지로 이동 요청!");
			resp.sendRedirect("board/board_write.jsp");
			break;
			
		case "regist" :
			System.out.println("글 등록 요청이 들어옴!");
			String writer = req.getParameter("writer");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			BoardVO vo = new BoardVO();
			vo.setWriter(writer);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setRegDate(LocalDateTime.now()); // 나중에 db쓰면 날짜설정 따로 안해도 됨
			
			BoardRepository.getInstance().regist(vo); // 글 등록 완료.
			
			
			
			resp.sendRedirect("/JspBasic/list.board");
			break;
			
		case "list" :
			System.out.println("글 목록 요청이 들어옴!");
			List<BoardVO> list = BoardRepository.getInstance().getList();
			
			/*
			DB로부터 전달받은 글 목록을 session에 넣기는 session이 아까움
			session의 목적은 데이터를 계속 *유지* 하기 위한 수단.
			글목록은 수시로 변경(갱신)되는 데이터이므로, 한 번 응답한 뒤에 유지목적으로 저장할 이유가 없음
			따라서 응답이 나가면 자동으로 소멸하는 request가 훨씬 적합함.
			 */
			req.setAttribute("boardList", list);
			
			//sendRedirect를 쓰면.. 아까 request에 setAttribute했던 데이터가...
			//리다이렉트를 위해 response하는 순간 데이터가 죽음......
			/*
			 여기서 sendRedirect를 하면 안되는 이유,
			 request 객체에 list를 담아서 전달하려 하는데, sendRedicrect를 사용하면
			 응답이 바로 나가면서 기존의 request 객체가 소멸해 버림.
			 
			 따라서, forward라는 요청 위임방식을 사용해야함.
			 forward방식을 사용해서 request를 원하는 jsp 파일로 전달해서 그쪽에서 응답이 나갈 수 있도록 처리해야함.
			 */
			//resp.sendRedirect("board/board_list.jsp");
			
			//request 객체를 다음 화면까지 운반하기 위한 forward 기능을 제공하는 객체
			// -> RequestDispatcher
			// RequestDispatcher 사용 시 유의할 점: 절대경로로 사용하고 싶다면 context path는 제외하고 사용할 것.
			// 그냥 상대경로로 체크하는게 더욱 편리할 듯.
			RequestDispatcher dp = req.getRequestDispatcher("/board/board_list.jsp");
			dp.forward(req, resp); //dp에 request와 response 두 개를 위임해서 dp의 경로로 이동하게 됨.
			
			break;
			
		case "content":
			
			List<BoardVO> list1 = BoardRepository.getInstance().getList();
			req.setAttribute("boardList", list1);
			
			String bId = req.getQueryString().substring(4);
			req.setAttribute("bId", bId);
			
			RequestDispatcher dp1 = req.getRequestDispatcher("/board/board_content.jsp");
			dp1.forward(req, resp);
		
			break;
	
		}
		
	}


}
