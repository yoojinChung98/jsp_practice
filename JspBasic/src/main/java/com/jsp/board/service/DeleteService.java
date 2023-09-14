package com.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.BoardRepository;

public class DeleteService implements IBoardService {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		int bId = Integer.parseInt(req.getParameter("bId"));
		BoardRepository.getInstance().deleteContent(bId);
		
		
	}

}
