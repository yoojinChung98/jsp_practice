package com.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IBoardService {
	
	public void execute( HttpServletRequest req, HttpServletResponse resp); //컨트롤러에서 전달받은 HttpServletRequest, HttpServletResponse를 받아올 것
	

}
