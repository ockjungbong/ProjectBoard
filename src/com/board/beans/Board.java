package com.board.beans;

public class Board {
	private int idx;
	private String title;
	private String writer;
	private String regdate;
	private int count;
	private String content;	
	
	public Board(){}
	
	public Board(int idx, String title, String writer, String regdate, int count, String content) {
		
		this.idx = idx;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
		this.count = count;
		this.content = content;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Board [idx=" + idx + ", title=" + title + ", writer=" + writer + ", regdate=" + regdate + ", count="
				+ count + ", content=" + content + "]";
	}
}
