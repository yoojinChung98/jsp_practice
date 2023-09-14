package com.jsp.board.service;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.BoardRepository;
import com.jsp.board.model.BoardVO;

public class GetListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("글 목록 요청이 들어옴!");
		List<BoardVO> list = BoardRepository.getInstance().getList();
		
		/*
		DB로부터 전달받은 글 목록을 session에 넣기는 session이 아까움
		session의 목적은 데이터를 계속 *유지* 하기 위한 수단.
		글목록은 수시로 변경(갱신)되는 데이터이므로, 한 번 응답한 뒤에 유지목적으로 저장할 이유가 없음
		따라서 응답이 나가면 자동으로 소멸하는 request가 훨씬 적합함.
		 */
		req.setAttribute("boardList", list);
		
		
		
	}

}
