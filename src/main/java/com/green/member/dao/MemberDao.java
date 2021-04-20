package com.green.member.dao;

import java.util.HashMap;
import java.util.List;

import com.green.member.vo.MemberVo;

public interface MemberDao {


	MemberVo login(HashMap<String, Object> map);

	void setWrite(HashMap<String, Object> map);
	
	void register(MemberVo vo);
	
	int  idCheck(MemberVo vo);
	
	int  pwdCheck(MemberVo vo);

	MemberVo getMemberList(HashMap<String, Object> map);

	void setMemberUpdate(HashMap<String, Object> map);

	void setUpdatePassword(HashMap<String, Object> map);

	MemberVo member_emailCheck(int member_num);

	List<MemberVo> questionMemberList();


}
