package com.green.count.vo;

public class CountVo {
	private int		idx;
	private String  code;
	private String  name;
	private int		price;
	private String  market;
	private int     quantity;
	private String  regdate;
	private int     member_num;
	private int     count_num;
	
	public CountVo() {
	}
	public CountVo(int idx, String code, String name, int price, String market, int quantity, String regdate,
			int member_num, int count_num) {
		this.idx = idx;
		this.code = code;
		this.name = name;
		this.price = price;
		this.market = market;
		this.quantity = quantity;
		this.regdate = regdate;
		this.member_num = member_num;
		this.count_num = count_num;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public int getCount_num() {
		return count_num;
	}
	public void setCount_num(int count_num) {
		this.count_num = count_num;
	}
	@Override
	public String toString() {
		return "CountVo [idx=" + idx + ", code=" + code + ", name=" + name + ", price=" + price + ", market=" + market
				+ ", quantity=" + quantity + ", regdate=" + regdate + ", member_num=" + member_num + ", count_num="
				+ count_num + "]";
	}
	
	
	
	
}
