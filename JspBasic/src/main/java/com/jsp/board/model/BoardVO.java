package com.jsp.board.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 모델(model) 계층은 비즈니스 로직을 처리하는 역할을 담당
 비즈니스 로직이란, 외부 프로그램과 연계 작업 등을 수행하는 로직. (데이터베이스 등...)
 
 VO (Value Object) 
 : 데이터베이스에서 조회된 값, 서버 프로그램에서 요청과 함께 얻은 값 등을 포장해서 운반하는 값에 관련된 객체.
 - VO 클래스는 자바빈 클래스로 생성.
 
 자바 빈 * (java bean)
 : 웹 프로그래밍에서 어떠한 객체를 가지고 오기 위한 기법이며, 자바 언어로 작성된 클래스를 일반적으로 부르는 호칭.
 -웹 프로그래밍에서 사용되는 여러 객체들을 전부 다 그냥 자바 빈이라고 부름. (자바는 카페였으니까)
 -자바 웹프로그래밍 쪽에서 빈 생성할 때의 규약이 있음.
 
 자바 빈 규약 (자바빈을 설계하기 위한 규약이 존재함)
 1. 은닉(캡슐화)을 구현해서 클래스를 제작합니다. (변수 private, getter/setter 존재)
 2. getter 메서드는 매개변수가 존재하지 않아야 한다. (그냥 돌려주는 역할로 국한하자)
 3. 생성자는 매개값을 받지 않는 생성자(필수), 매개값을 받는 생성자(선택사항)가 존재.
 4. 모든 getter/setter 메서드는 접근 제한이 public 이어야 한다.
 
 EL은 모든 클래스가 자바 빈 규약을 지켜서 작성했을 것을 가정하고 작동하기 때문에 항상 getter를 불러오는 것
 따라서 getter메서드를 생성하지 않으면 EL을 사용할 수 없음.
 
 */

public class BoardVO {

	private String writer;
	private String title;
	private String content;
	private LocalDateTime regDate;
	
	public BoardVO() {}

	public BoardVO(String writer, String title, String content, LocalDateTime regDate) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardVO [writer=" + writer + ", title=" + title + ", content=" + content 
				+ ",regDate=" + regDate + "]";
	}
	
	
	
}
