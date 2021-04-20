package com.green.member.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.green.count.service.CountService;
import com.green.count.vo.CountVo;
import com.green.member.service.MemberService;
import com.green.member.vo.MemberVo;

@Controller
public class MemberController {
	
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private CountService countService;
	
//-------------------------------------------------------------------------------------------
	// 회원가입 페이지 
	@RequestMapping("/MEMBER/REGISTER")
	public ModelAndView writeForm(
			@RequestParam HashMap<String, Object> map ) {
		// 회원가입 페이지로 이동 
		ModelAndView mv = new ModelAndView();
		mv.addObject("map", map);
		mv.setViewName("/registar_login/register"); // jsp이동
		return mv;
	}
	
	
	// 회원가입 처리 
	@RequestMapping("/Member/Write")
	public ModelAndView write(
			@RequestParam HashMap<String, Object> map,
			HttpServletRequest request ) {
		// 회원가입시 입력한 값을 map으로 받아 db에 저장 
		memberService.setWrite(map, request);
		ModelAndView mv = new ModelAndView();
		mv.addObject("map", map);
		mv.setViewName("redirect:/LOGIN"); // jsp이동
		return mv;
	}
	
	
	
	/*
	 * @RequestMapping(value="/register", method=RequestMethod.POST) public String
	 * memberRegister(MemberVo vo) { memberService.register(vo); return
	 * "redirect:/LOGIN"; }
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value="/idCheck", method=RequestMethod.POST) public int
	 * idCheck(MemberVo vo) throws Exception { int result =
	 * memberService.idCheck(vo); return result; }
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value="/pwdCheck", method=RequestMethod.POST) public int
	 * pwdCheck(MemberVo vo) throws Exception { int result =
	 * memberService.pwdCheck(vo); return result; }
	 */
	
	
	//---------------------------------------------------
	// 로그인 폼을 띄우는 부분
		@RequestMapping(value="/LOGIN", method=RequestMethod.GET)
		public String loginForm() {
			return "/registar_login/login";
		}
		
		// 로그인 처리하는 부분 
				@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
				public String loginProcess(
						HttpSession   session,
						@RequestParam HashMap<String, Object> map ) {
					System.out.println(map);
					
					String returnURL = "";
					if( session.getAttribute("login") != null ) {
						// 기존의 login이란 세션 값이 존재한다면
						session.removeAttribute("login"); // 기존값을 제거한다
					}
					// 로그인이 성공하면 UserVo 객체를 반환함
					MemberVo vo = memberService.login( map );
					if( vo != null ) {
						session.setAttribute("login", vo); // 세션에 "login" <- vo
						System.out.println("로그인 성공 : " + vo);
						returnURL = "redirect:/";
					} else { // 로그인 되지 않았을 때
						returnURL = "redirect:/LOGIN";
					}
					return returnURL;
				}
				
				// 로그아웃 처리
				@RequestMapping(value="/logout")
				public String logout(HttpSession session) {
					
					session.invalidate(); // 세션 전체를 날려버린다
					return "redirect:/"; // 로그아웃시 이동할 주소
				}
		
//------------------------------------------------------------------------------------------
		
		// 메인화면 
		@RequestMapping("/MEMBERHOME")
		public ModelAndView memberHome(HttpSession   session,HttpServletRequest request,HttpServletResponse response,
				@RequestParam HashMap<String, Object>map) {
			ModelAndView mv = new ModelAndView();
			MemberVo vo = (MemberVo) session.getAttribute("login");
			// 로그인 세션의 고객 정보를 통해서 입출고 내역을 가져온다
			List<CountVo>list = countService.getInOutCount(vo);
			int member_basket = vo.getMember_basket();
			mv.addObject("list", list);
			mv.addObject("member_basket", member_basket);
			mv.setViewName("/member/memberhome");
			return mv;
		}

		// 고객 정보 보기 
		@ResponseBody
		@RequestMapping(value="/Member/Information")
		public ModelAndView memberInfo(HttpSession   session,HttpServletRequest request,HttpServletResponse response,
				@RequestParam HashMap<String, Object>map) {
			/* session.getAttribute("login"); */
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/member/member_info");
			return mv;
		}
		// 고객 정보 수정 
		@RequestMapping("/Member/Update")
		public ModelAndView memberUpdate(HttpSession   session,HttpServletRequest request,HttpServletResponse response,
				@RequestParam HashMap<String, Object>map) {
			ModelAndView mv = new ModelAndView();
			memberService.setMemberUpdate(map);
			mv.setViewName("redirect:/logout");
			return mv;
		}
		
		// 비밀번호 변경 화면으로 이동 
		@RequestMapping("/MemberPassword")
		public ModelAndView memberUpdatePasswordForm(@RequestParam HashMap<String, Object>map) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/member/updatePassword");
			
			return mv;
		}
		
		// 비밀번호 변경시 처리 하는 부분 
		@RequestMapping("/MEMBERUPDATEPASSWORD")
		public ModelAndView memberUpdatePassword(@RequestParam HashMap<String, Object>map) {
			System.out.println("맵보기 : " + map);
			ModelAndView mv = new ModelAndView();
			memberService.setUpdatePassword(map);
			
			mv.setViewName("redirect:/LOGIN");
			
			return mv;
		}
		
		
}
