package com.green.mboard.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.green.mboard.service.BoardService;
import com.green.mboard.vo.BoardVo;
import com.green.member.service.MemberService;
import com.green.member.vo.MemberVo;

@Controller
public class MBoardController {
	
	@Autowired
	private  BoardService  boardService;
	@Autowired
	private  MemberService  memberService;
	
	// 1:1 문의 리스트 
	@RequestMapping("/MBoard/List")
	public ModelAndView  mBoardList(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		// 세션에서 로그인 정보 뽑기
		MemberVo vo = (MemberVo) session.getAttribute("login");
		// member_num == 0 이면 관리자 페이지로 이동
		if(vo.getMember_num() == 0) {
			// 고객 정보 불러오기
			List<MemberVo>list = memberService.questionMemberList();
			// 고객 정보 memberList에 담기 
			mv.addObject("memberList",list);
			// 관리자 페이지로 이동 
			mv.setViewName("board/master_question");
			return mv;
		}
		// 고객 1:1 문의 내용 불러오기
		List<BoardVo>list = boardService.getQuestionList(vo);
		// 내용 list에 담기 
		mv.addObject("list", list);
		// 고객 1:1 문의 페이지로 이동 
		mv.setViewName("board/question");
		return  mv;
	} 
	
	// 관리자의 1:1 문의 리스트
	@RequestMapping("/MBoard/MasterQuestion")
	@ResponseBody
	// ajax로 해당 memeber_num을 불러옴 
	public List<BoardVo>list(@RequestParam int member_num) {
		// vo에 member_num을 넣어줌
		MemberVo vo = new MemberVo();
		vo.setMember_num(member_num);
		// vo를 이용해 해당 고객의 문의를 불러서 Questionlist로 저장해서 리턴 
		List<BoardVo>Questionlist = boardService.getQuestionList(vo);
		return Questionlist;
	}
	
	// 고객의 1:1 문의 입력 
	@RequestMapping("/InsertQuestion")
	@ResponseBody
	// ajax로 고객이 1:1 문의 내용 값을 map으로 받기 
	public void insertQuestion(  @RequestParam HashMap<String, Object> map  ) {
		// 1:1 문의 내용 저장 
		boardService.insertQuestion(map);
	}
	
	// 관리자의 1:1 문의 답글
	@RequestMapping("InsertQuestionReply")
	@ResponseBody
	// ajax로 관리자의 답글과 해당 고객의 넘버를 가져옴 
	public void insertQuestionReply(@RequestParam String reply, int member_num) {
		// vo에 답글과 고객 넘버를 담는다 
		BoardVo vo = new BoardVo();
		vo.setReply(reply);
		vo.setMember_num(member_num);
		// vo를 이용해 답글 db에 저장 
		boardService.insertQuestionMaster(vo);
		
	}
}















