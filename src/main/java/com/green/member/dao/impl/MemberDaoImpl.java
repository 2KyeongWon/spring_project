package com.green.member.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.member.dao.MemberDao;
import com.green.member.vo.MemberVo;

@Repository("MemberDao")
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSession sqlSession;

		
	@Override
	public void setWrite(HashMap<String, Object> map) {
	
		sqlSession.insert("Member.InsertMember", map);
		
	}
	
	@Override
	public void register(MemberVo vo) {
		
		sqlSession.selectOne("Member.register", vo);
	}
	
	@Override
	public int idCheck(MemberVo vo) {
		int result = sqlSession.selectOne("Member.idCheck", vo);
		
		return result;
	}


	@Override
	public int pwdCheck(MemberVo vo) {
		int result = sqlSession.selectOne("Member.pwdCheck", vo);
		
		return result;
	}


	//----------------------------
	@Override
	public MemberVo login(HashMap<String, Object> map) {
		
		MemberVo memberVo = sqlSession.selectOne("Member.Login", map);
		
		return memberVo;
	}

	@Override
	public MemberVo getMemberList(HashMap<String, Object> map) {
		sqlSession.selectOne("Member.INFO", map);
		List<MemberVo> list = (List<MemberVo>) map.get("result");
		MemberVo vo = list.get(0);
		 
		return vo;
	}

	@Override
	public void setMemberUpdate(HashMap<String, Object> map) {
		sqlSession.update("Member.MemberUpdate",map);
	}

	@Override
	public void setUpdatePassword(HashMap<String, Object> map) {
		sqlSession.update("Member.UpdatePassword",map);
	}

	@Override
	public MemberVo member_emailCheck(int member_num) {
		System.out.println("다오  : " + member_num);
		MemberVo vo = sqlSession.selectOne("Member.Member_emailCheck",member_num);
		System.out.println("다오 vO : " + vo);
		return vo;
	}

	@Override
	public List<MemberVo> questionMemberList() {
		List<MemberVo>list = sqlSession.selectList("Member.QuestionMemberList");
		return list;
	}





	


	




	
	
	
}
