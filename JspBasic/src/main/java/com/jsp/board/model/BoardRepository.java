package com.jsp.board.model;

import java.util.ArrayList;
import java.util.List;

//아직 DB를 안배워서
//DB 역할을 대신할 List를 하나 선언해서 BoardVO 객체를 저장하겠습니다.

public class BoardRepository {

	//외부에서 이 리스트에 직접 접근하지 못하도록 하기 위해 private으로 설정.
	//참고로 얘를 생성할 수 있는 클래스 장소만 빌려준것!
	//boardList는 BoardRepository라는 클래스에서 사용할거니까 여기서 선언생성한 것.
	private static final List<BoardVO> boardList = new ArrayList<>();
	
	
	private BoardRepository() {}
	
	private static BoardRepository repository = new BoardRepository();
	
	
	
	
	
	
	public static BoardRepository getInstance() {
		return repository;
	}
	
	
	
	
	//아래의 메서드들을 작성하는 이유.
	//baordList에는 아무도 직접 접근할 수 업성.. 그냥 걔가 가지고 있는 메서드만! 이용할 수 있는 거야.(그래서 getter setter가 있는 거고!)
	//메서드를 쓰려면 객체를 생성해서 사용해야하는데, 더이상 생성할 수 없도록 설정해놨으니까, 주소값을 받아서 사용하자 이거야!
	//그 주소값을 통해서 BoardRepository가 갖고있는 메서드를 사용할 수 있게 되는거지!
	
	//게시글 등록 메서드
	public void regist(BoardVO vo) {
		boardList.add(vo);
	}
	
	//전체 게시물(BoardList)을 담고 있는 리스트 객체를 리턴
	public List<BoardVO> getList() {
		return boardList;
	}
	
	//글번호를 가지고 특정 게시물 객체를 리턴하는 메서드
	public BoardVO getContent(int bId) {
		return boardList.get(bId-1);
		//bId는 1부터 시작하도록 설정해놓음
	}
	
	//글번호를 이용하여 수정된 게시물을 기존 게시물과 교체하는 메서드
	public void setContent(int bId, BoardVO newVO) {
		boardList.set(bId-1, newVO );
	}
	
	//글번호를 이용하여 게시물을 삭제하는 메서드
	public void deleteContent(int bId) {
		boardList.remove(bId-1);
	}
	
	//작성자 키워드를 가지고 있는 모든 VO들을 새로 담아 반환하는 메서드
	public List<BoardVO> keywordList(String keyword) {
		List<BoardVO> list = new ArrayList<>();
		for(BoardVO b : boardList) {
			if (b.getWriter().contains(keyword)) {
				list.add(b);
			}
		} return list;
	}



	
}
