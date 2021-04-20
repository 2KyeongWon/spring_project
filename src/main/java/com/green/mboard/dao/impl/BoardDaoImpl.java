package com.green.mboard.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.mboard.dao.BoardDao;
import com.green.mboard.vo.BoardVo;
import com.green.member.vo.MemberVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private  SqlSession  sqlSession; 
	
	@Override
	public List<BoardVo> getBoardList(HashMap<String, Object> map) {
		
		sqlSession.selectList("MBoard.BoardList", map);
		
		List<BoardVo> boardList = (List<BoardVo>) map.get("result");
				
		return  boardList;
	}

	@Override
	public void insertBoard(BoardVo vo) {
		
		sqlSession.insert("MBoard.InsertBoard", vo);
		
	}

	@Override
	public BoardVo getView(HashMap<String, Object> map) {
		
		sqlSession.selectList("MBoard.BoardView", map);
		
		List<BoardVo> boardList = (List<BoardVo>) map.get("result"); 
		
		BoardVo       vo = boardList.get(0);
				
		return  vo;
	}

	@Override
	public void updateBoard(HashMap<String, Object> map) {
		
		sqlSession.update("MBoard.UpdateBoard", map );
		
	}

	@Override
	public void deleteBoard(HashMap<String, Object> map) {
		
		sqlSession.delete("MBoard.DeleteBoard", map );
		
	}

	@Override
	public void replyBoard(HashMap<String, Object> map) {
		
		sqlSession.update("MBoard.ReplyBoard", map );
	}

	@Override
	public void insertQuestion(HashMap<String, Object> map) {
		sqlSession.insert("MBoard.InsertQuestion",map);
	}

	@Override
	public List<BoardVo> getQuestionListO(MemberVo vo) {
		List<BoardVo>list = sqlSession.selectList("MBoard.GetQuestionList", vo);
		return list;
	}

	@Override
	public void insertQuestionMaster(BoardVo vo) {
		sqlSession.insert("MBoard.InsertQuestionMaster", vo);
	}

}





