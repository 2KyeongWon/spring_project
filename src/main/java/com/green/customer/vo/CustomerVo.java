package com.green.customer.vo;

public class CustomerVo {
	// Fields
	private int		idx;
	private String  customer_it;
	private String  customer_name;
	private String  customer_tel;
	private String  customer_email;
	private String  customer_remarks;
	// memberVo에 존재하는데 여기도 필요한가?
	private int		member_num;
	
	// Constructor
	public CustomerVo() {
	}
	public CustomerVo(int idx, String customer_it, String customer_name, String customer_tel, String customer_email,
			String customer_remarks, int member_num) {
		this.idx = idx;
		this.customer_it = customer_it;
		this.customer_name = customer_name;
		this.customer_tel = customer_tel;
		this.customer_email = customer_email;
		this.customer_remarks = customer_remarks;
		this.member_num = member_num;
	}
	
	// Getter & Setter
	

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCustomer_it() {
		return customer_it;
	}
	public void setCustomer_it(String customer_it) {
		this.customer_it = customer_it;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_tel() {
		return customer_tel;
	}
	public void setCustomer_tel(String customer_tel) {
		this.customer_tel = customer_tel;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_remarks() {
		return customer_remarks;
	}
	public void setCustomer_remarks(String customer_remarks) {
		this.customer_remarks = customer_remarks;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	
	
	
	
	
	// toString
	@Override
	public String toString() {
		return "CustomerVo [idx=" + idx + ", customer_it=" + customer_it + ", customer_name=" + customer_name
				+ ", customer_tel=" + customer_tel + ", customer_email=" + customer_email + ", customer_remarks="
				+ customer_remarks + ", member_num=" + member_num  + "]";
	}
	

	
	
}
