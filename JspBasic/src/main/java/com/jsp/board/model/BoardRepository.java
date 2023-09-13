package com.jsp.board.model;

import java.util.ArrayList;
import java.util.List;

//아직 DB를 안배워서
//DB 역할을 대신할 List를 하나 선언해서 BoardVO 객체를 저장하겠습니다.

public class BoardRepository {

	//외부에서 이 리스트에 직접 접근하지 못하도록 하기 위해 private으로 설정.
	private static final List<BoardVO> boardList = new ArrayList<>();
	
	private BoardRepository() {}
	
	private static BoardRepository repository = new BoardRepository();
	
	public static BoardRepository getInstance() {
		return repository;
	}
	
	//게시글 등록 메서드
	public void regist(BoardVO vo) {
		boardList.add(vo);
	}
	
	//전체 게시물(BoardList)을 담고 있는 리스트 객체를 리턴
	public List<BoardVO> getList() {
		return boardList;
	}
	
}
