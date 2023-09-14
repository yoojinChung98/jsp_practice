package com.jsp.board.service;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.BoardRepository;
import com.jsp.board.model.BoardVO;

public class RegistService implements IBoardService {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
			
		String writer = req.getParameter("writer");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardVO vo = new BoardVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setRegDate(LocalDateTime.now()); // 나중에 db쓰면 날짜설정 따로 안해도 됨
		
		BoardRepository.getInstance().regist(vo); // 글 등록 완료.
		//BoardRepositroy 라는 객체를 찾는다기 보다는...애초에 static 영역에는 클래스명.메서드이름() 이렇게 저장되니까 그냥 static영역의 BR.getinstcane()를 호출한거고
		
		
	}

}
