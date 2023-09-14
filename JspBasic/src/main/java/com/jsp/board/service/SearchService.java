package com.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.BoardRepository;

public class SearchService implements IBoardService {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		//일단 키워드가 왔음
		String keyword = req.getParameter("keyword");
		BoardRepository.getInstance().keywordList(keyword);
		
		req.setAttribute("boardList", BoardRepository.getInstance().keywordList(keyword));
		
	}

}
