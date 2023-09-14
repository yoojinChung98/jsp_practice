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
import com.jsp.board.service.ContentService;
import com.jsp.board.service.DeleteService;
import com.jsp.board.service.GetListService;
import com.jsp.board.service.IBoardService;
import com.jsp.board.service.ModifyService;
import com.jsp.board.service.RegistService;
import com.jsp.board.service.SearchService;
import com.jsp.board.service.UpdateServide;


@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IBoardService sv;
	private RequestDispatcher dp;
	
    public BoardController() {
        super();
    }


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getMethod().equals("POST")) { //getMethod()가 대문자로 메서드를 줘서 대문자로 써야함.
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
			sv = new RegistService();
			sv.execute(req, resp);
			
			/*
			 왜 board_list.jsp로 바로 리다이렉트를 하면 안될까?
			 board_list.jsp에는 데이터베이스로부터 전체 글 목록을 가져오는
			 로직을 작성하지 않을 것이기 때문입니다. (jsp는 단순히 보여지는 역할만 수행)
			 컨트롤러로 글 목록 요청이 다시 들어올 수 있게끔
			 sendRedirect()를 사용하여 자동 목록 재 요청이 들어오게 하는 겁니다.
			*/
			
			resp.sendRedirect("/JspBasic/list.board");
			break;
			
		case "list" :
			System.out.println("글 목록 요청이 들어옴!");
			sv = new GetListService();
			sv.execute(req, resp);

			//sendRedirect를 쓰면.. 아까 request에 setAttribute했던 데이터가...
			//리다이렉트를 위해 response하는 순간 데이터가 죽음......
			/*
			 여기서 sendRedirect를 하면 안되는 이유,
			 request 객체에 list를 담아서 전달하려 하는데, sendRedicrect를 사용하면
			 응답이 바로 나가면서 기존의 request 객체가 소멸해 버림.
			 
			 따라서, forward라는 요청 위임방식을 사용해야함. (포워드 기능)
			 forward방식을 사용해서 request를 원하는 jsp 파일로 전달해서 그쪽에서 응답이 나갈 수 있도록 처리해야함.
			 서버 안에서 req와 resp를 다른 경로로 위임하는 것.
			 */
			//resp.sendRedirect("board/board_list.jsp");
			
			//request 객체를 다음 화면까지 운반하기 위한 forward 기능을 제공하는 객체
			// -> RequestDispatcher
			// RequestDispatcher 사용 시 유의할 점: 절대경로로 사용하고 싶다면 context path는 제외하고 사용할 것.
			// 그냥 상대경로로 체크하는게 더욱 편리할 듯.
			dp = req.getRequestDispatcher("/board/board_list.jsp");
			dp.forward(req, resp); //dp에 request와 response 두 개를 위임해서 dp의 경로로 이동하게 됨.
			
			break;
			
		case "content":
			
			/*
			List<BoardVO> list1 = BoardRepository.getInstance().getList();
			req.setAttribute("boardList", list1);

			String bId = req.getQueryString().substring(4);
			req.setAttribute("bId", bId);
			
			RequestDispatcher dp1 = req.getRequestDispatcher("/board/board_content.jsp");
			dp1.forward(req, resp);
			*/
			
			
			/*
			List<BoardVO> list1 = BoardRepository.getInstance().getList();
			String bId = req.getQueryString().substring(4);
//			int bId = Integer.parseInt(getParameter(bId));
			BoardVO vo1 = list1.get(Integer.parseInt(bId)-1);
			
			req.setAttribute("vo1", vo1);
			
			RequestDispatcher dp1 = req.getRequestDispatcher("/board/board_content.jsp");
			dp1.forward(req, resp);
			*/
			
			
			System.out.println("글 상세보기 요청이 들어옴!");
			sv = new ContentService();
			sv.execute(req, resp);
	
			dp = req.getRequestDispatcher("board/board_content.jsp");
			dp.forward(req, resp);
			
			break;
			
		case "modify" :
			System.out.println("글 수정 페이지로 이동 요청!");
			sv = new ModifyService();
			sv.execute(req, resp);
			
			dp = req.getRequestDispatcher("board/board_modify.jsp");
			dp.forward(req, resp);
			
			break;
		
		case "update" :
			System.out.println("글 수정 요청이 들어옴!");
			
			sv = new UpdateServide();
			sv.execute(req, resp);
			
			dp = req.getRequestDispatcher("/board/board_content.jsp");
			dp.forward(req, resp);
			
			/*
			resp.sendRedirect("/JspBasic/content.board?bId="+req.getParmeter("boardNo"));
			break;
			*/
			
			
			break;
			
		case "delete" :
			System.out.println("글 삭제 요청이 들어옴!");
			
			sv = new DeleteService();
			sv.execute(req, resp);
			
			resp.sendRedirect("/JspBasic/list.board");
			break;
		
		case "search" :
			System.out.println("글 검색 요청이 들어옴!");
			
			sv = new SearchService();
			sv.execute(req, resp);
			
			dp = req.getRequestDispatcher("board/board_list.jsp");
			dp.forward(req, resp);
			break;
		}
		
	}


}
