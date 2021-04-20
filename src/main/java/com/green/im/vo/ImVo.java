package com.green.im.vo;

public class ImVo {
	private int idx;
	private String code;
	private String name;
	private int price;
	private String market;
	private String remarks;
	private int member_num;
	private int quantity;
	private String regdate;
	private int member_table;
	
	
	public ImVo() {}
	public ImVo(int idx, String code, String name, int price, String market, String remarks, int member_num, int quantity, String regdate) {
		this.idx = idx;
		this.code = code;
		this.name = name;
		this.price = price;
		this.market = market;
		this.remarks = remarks;
		this.member_num = member_num;
		this.quantity = quantity;
		this.regdate = regdate;
	}
	public ImVo(int idx, String code, String name, int price, String market, String remarks, int member_num, int quantity, String regdate, int member_table) {
		this.idx = idx;
		this.code = code;
		this.name = name;
		this.price = price;
		this.market = market;
		this.remarks = remarks;
		this.member_num = member_num;
		this.quantity = quantity;
		this.regdate = regdate;
		this.member_table = member_table;
	}
	
	

	
	
	
	public ImVo(int idx, String code, String name, int price, String market, String remarks, int member_num) {
		this.idx = idx;
		this.code = code;
		this.name = name;
		this.price = price;
		this.market = market;
		this.remarks = remarks;
		this.member_num = member_num;
	}
	public int getMember_table() {
		return member_table;
	}
	public void setMember_table(int member_table) {
		this.member_table = member_table;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	


	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}
	@Override
	public String toString() {
		return "ImVo [idx=" + idx + ", code=" + code + ", name=" + name + ", price=" + price + ", market=" + market
				+ ", remarks=" + remarks + ", member_num=" + member_num + ", quantity=" + quantity + ", regdate="
				+ regdate + "]";
	}


	
	
	


	
	
}
