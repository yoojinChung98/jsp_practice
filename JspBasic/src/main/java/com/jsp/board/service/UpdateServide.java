package com.jsp.board.service;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.BoardRepository;
import com.jsp.board.model.BoardVO;

public class UpdateServide implements IBoardService {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		BoardVO vo = new BoardVO();
		vo.setWriter(req.getParameter("writer"));
		vo.setTitle(req.getParameter("title"));
		vo.setContent(req.getParameter("content"));
		vo.setRegDate(LocalDateTime.now());
		
		/*
		// 멤버변수 모두 파라미터로 보내는 생성자로 생성해도 ㄱㅊ
		BoardVO vo = new BoardVO(
					request.getParameter("writer"),
					request.getParameter("title"),
					request.getParameter("content"),
					LocalDateTime.now()
			);
		*/
		
		int bId = Integer.parseInt(req.getParameter("boardNo"));
		
		BoardRepository.getInstance().setContent(bId, vo );
		
		req.setAttribute("content", vo);
	}

}
