package com.green.mboard.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.mboard.dao.BoardDao;
import com.green.mboard.service.BoardService;
import com.green.mboard.vo.BoardVo;
import com.green.member.vo.MemberVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardVo> getBoardList(HashMap<String, Object> map) {
		
		List<BoardVo> boardList = boardDao.getBoardList( map );  
		
		for (int i = 0; i < boardList.size(); i++) {
			String title = boardList.get(i)
					 .getTitle().replace(" ", "&nbsp;&nbsp;" );
			boardList.get(i).setTitle(title);			
		}
		
		
		return boardList;
	}

	@Override
	public void insertBoard(BoardVo vo) {
		
		boardDao.insertBoard( vo );
		
	}

	@Override
	public BoardVo getView(HashMap<String, Object> map) {
		BoardVo boardVo = boardDao.getView(map); 
		return  boardVo;
	}

	@Override
	public void updateBoard(HashMap<String, Object> map) {
		
		boardDao.updateBoard(map);
		
	}

	@Override
	public void deleteBoard(HashMap<String, Object> map) {
		
		boardDao.deleteBoard(map);
		
	}

	@Override
	public void replyBoard(HashMap<String, Object> map) {
		
		boardDao.replyBoard(map);
	}

	@Override
	public void insertQuestion(HashMap<String, Object> map) {
		boardDao.insertQuestion(map);
	}

	@Override
	public List<BoardVo> getQuestionList(MemberVo vo) {
		List<BoardVo>list = boardDao.getQuestionListO(vo);
		
		return list;
	}

	@Override
	public void insertQuestionMaster(BoardVo vo) {
		boardDao.insertQuestionMaster(vo);
	}

}









