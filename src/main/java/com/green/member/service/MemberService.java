package com.green.member.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.green.member.vo.MemberVo;

public interface MemberService {

	MemberVo login(HashMap<String, Object> map);

	void setWrite(HashMap<String, Object> map, HttpServletRequest request);
	
	int  idCheck(MemberVo vo);

	int  pwdCheck(MemberVo vo);

	void register(MemberVo vo);

	MemberVo getMemberlist(HashMap<String, Object> map);

	void setMemberUpdate(HashMap<String, Object> map);

	void setUpdatePassword(HashMap<String, Object> map);

	MemberVo member_emailCheck(int member_num);

	List<MemberVo> questionMemberList();

}
