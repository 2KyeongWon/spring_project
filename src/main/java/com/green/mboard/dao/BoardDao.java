package com.green.mboard.dao;

import java.util.HashMap;
import java.util.List;

import com.green.mboard.vo.BoardVo;
import com.green.member.vo.MemberVo;

public interface BoardDao {

	List<BoardVo> getBoardList(HashMap<String, Object> map);

	void insertBoard(BoardVo vo);

	BoardVo getView(HashMap<String, Object> map);

	void updateBoard(HashMap<String, Object> map);
	
	void deleteBoard(HashMap<String, Object> map);

	void replyBoard(HashMap<String, Object> map);

	void insertQuestion(HashMap<String, Object> map);

	List<BoardVo> getQuestionListO(MemberVo vo);

	void insertQuestionMaster(BoardVo vo);

}
