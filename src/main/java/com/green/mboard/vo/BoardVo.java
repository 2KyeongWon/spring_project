package com.green.mboard.vo;

public class BoardVo {
	// Fields
	private  int     idx;
	private  int     member_num;
	private  String  title;
	private  String  cont;
	private  String  writer;
	private  String  regdate;
	private  String  reply;
	private  String  secr;
	
	//Constructor
	public BoardVo() {}
	
	public BoardVo(int idx, int member_num, String title, String cont, String writer, String regdate, String reply,
			String secr) {
		super();
		this.idx = idx;
		this.member_num = member_num;
		this.title = title;
		this.cont = cont;
		this.writer = writer;
		this.regdate = regdate;
		this.reply = reply;
		this.secr = secr;
	}



	// Getter /Setter
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
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
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getSecr() {
		return secr;
	}
	public void setSecr(String secr) {
		this.secr = secr;
	}

	// toString
	@Override
	public String toString() {
		return "BoardVo [idx=" + idx + ", member_num=" + member_num + ", title=" + title + ", cont=" + cont
				+ ", writer=" + writer + ", regdate=" + regdate + ", reply=" + reply + ", secr=" + secr + "]";
	}
}
