package com.green.member.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.member.dao.MemberDao;
import com.green.member.service.MemberService;
import com.green.member.vo.MemberVo;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void setWrite(HashMap<String, Object> map, 
			HttpServletRequest request) {
		
		memberDao.setWrite(map);
		
	}
	
	
	@Override
	public void register(MemberVo vo) {
		
	}
	
	@Override
	public int idCheck(MemberVo vo) {
		int result = memberDao.idCheck(vo);
		return result;
	}


	@Override
	public int pwdCheck(MemberVo vo) {
		int result = memberDao.pwdCheck(vo);
		return result;
	}
	
	//-----------------------------
	@Override
	public MemberVo login(HashMap<String, Object> map) {
		
		MemberVo memberVo = memberDao.login(map);
		System.out.println("memberVo : " + memberVo);
		
		return memberVo;
	}


	@Override
	public MemberVo getMemberlist(HashMap<String, Object> map) {
		MemberVo vo = memberDao.getMemberList(map);
		return vo;
	}


	@Override
	public void setMemberUpdate(HashMap<String, Object> map) {
		memberDao.setMemberUpdate(map);
	}


	@Override
	public void setUpdatePassword(HashMap<String, Object> map) {
		memberDao.setUpdatePassword(map);
	}


	@Override
	public MemberVo member_emailCheck(int member_num) {
		MemberVo vo = memberDao.member_emailCheck(member_num);
		return vo;
	}


	@Override
	public List<MemberVo> questionMemberList() {
		List<MemberVo>list = memberDao.questionMemberList();
		return list;
	}










	


	

	
}
