package com.green.member.vo;

public class MemberVo {
	// Fields
	private	 int	 member_num;
	private	 String	 member_name;
	private	 String	 member_email;
	private	 String	 member_pwd;
	private	 int	 member_basket;
	
	
	// Constructor
	public MemberVo() {}
	public MemberVo(int member_num, String member_name, String member_email, String member_pwd,int member_basket) {
		this.member_num = member_num;
		this.member_name = member_name;
		this.member_email = member_email;
		this.member_pwd = member_pwd;
		this.member_basket = member_basket;
	}


	// Getter & Setter
	
	
	
	
	public int getMember_basket() {
		return member_basket;
	}
	public void setMember_basket(int member_basket) {
		this.member_basket = member_basket;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_pwd() {
		return member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	
	
	@Override
	public String toString() {
		return "MemberVo [member_num=" + member_num + ", member_name=" + member_name + ", member_email=" + member_email
				+ ", member_pwd=" + member_pwd + ", member_basket=" + member_basket + "]";
	}
	
	
}
