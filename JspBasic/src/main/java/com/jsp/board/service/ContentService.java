package com.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.BoardRepository;
import com.jsp.board.model.BoardVO;

public class ContentService implements IBoardService {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		int bId = Integer.parseInt(req.getParameter("bId"));
		BoardVO board = BoardRepository.getInstance().getContent(bId);
		req.setAttribute("content", board);
		req.setAttribute("boardNo", bId);
		

	}

}
