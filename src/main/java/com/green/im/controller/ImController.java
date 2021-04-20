package com.green.im.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.green.count.service.CountService;
import com.green.count.vo.CountVo;
import com.green.im.service.ImService;
import com.green.im.vo.ImVo;
import com.green.member.service.MemberService;
import com.green.member.vo.MemberVo;

@Controller
public class ImController {
	
	@Autowired
	private ImService imService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private CountService countService;
	
	// 기본 루트 
	@RequestMapping("/")
	public ModelAndView home(HttpSession session,
			@RequestParam HashMap<String, Object>map) {
		ModelAndView mv = new ModelAndView();
		// 로그인 되어있을시 멤버홈으로 
		if(session.getAttribute("login") != null ) {
			mv.setViewName("redirect:/MEMBERHOME");
		}else {
			// 로그인 안되어있으면 로그인, 회원가입이 있는 홈으로
			mv.setViewName("home");
		}
		return mv;
	}
	
	// 고객의 재고 리스트를 불러온다 
	@RequestMapping("/LIST")
	@ResponseBody
	public List<ImVo>list (
			HttpServletRequest request, HttpServletResponse response, Model model,
			int member_num) {
		// 넘겨받은 고객넘버로  리스트를 불러와 dataList에 저장해서 리턴한다  
		List<ImVo> dataList = imService.getImList(member_num);
		return dataList;
	}
	
	// 재고 알람 리스트 
	@RequestMapping("/LowQuantity")
	@ResponseBody
	public List<ImVo>LowList (
			HttpServletRequest request, HttpServletResponse response, Model model,
			int member_num) {
		// 넘겨 받은 고객넘버로 5개 이하의 재고를  dataList 에 저장해서 리턴한다 
		List<ImVo> dataList = imService.getLowQuantityList(member_num);
		return dataList;
	}
	
	// 재고 수정 페이지로 이동 
	@RequestMapping("/Edit")
	public ModelAndView stockEdit(HttpSession   session,HttpServletRequest request,HttpServletResponse response,
			@RequestParam HashMap<String, Object>map) {
		MemberVo vo = (MemberVo) session.getAttribute("login");
		// 세션에 있는 고객 정보를 통해 장바구니의 물품 갯수를 확인 
		int member_basket = vo.getMember_basket();
		ModelAndView mv = new ModelAndView();
		// 장바구니 정보와 함께 페이지 이동 
		mv.addObject("member_basket", member_basket);
		mv.setViewName("/member/stock_edit");
		return mv;
	}
	
	// 재고 리스트 페이지로 이동 
	@RequestMapping("/StockList")
	public ModelAndView stockList(HttpSession   session,HttpServletRequest request,HttpServletResponse response,
			@RequestParam HashMap<String, Object>map) {
		session = request.getSession();
		ModelAndView mv = new ModelAndView();
		// 세션에 있는 고객 정보를 통해 장바구니의 물품 갯수를 확인 
		MemberVo vo = (MemberVo) session.getAttribute("login");
		int member_basket = vo.getMember_basket();
		// 장바구니 정보와 함께 페이지 이동 
		mv.addObject("member_basket", member_basket);
		 mv.setViewName("/member/stock_list"); 
		return mv;
	}
	
	
	// 구매 페이지로 이동 
	@ResponseBody
	@RequestMapping("/StockOrderPage")
	public ModelAndView stockOrderPage(HttpSession   session,HttpServletRequest request,HttpServletResponse response,
			@RequestParam HashMap<String, Object>map) {
		ModelAndView mv = new ModelAndView();
		MemberVo vo = (MemberVo) session.getAttribute("login");
		// 세션에 담겨있는 고객 정보로 장바구니의 물품을 orderList에 저장 리턴 
		List<ImVo> orderList = imService.getOrderList(vo);
		mv.setViewName("/member/stock_order");
		mv.addObject("orderList", orderList);
		return mv;
	}
	
	// 고객의 재고 등록 
	@RequestMapping("/StockInsert")
	@ResponseBody
	public void stockInsert(
			HttpServletRequest request, HttpServletResponse response, 
			ImVo imVo)throws Exception {
		// 고객의 직접 입력한 재고 정보를 imVo로 받아서 insert해준다 
		imService.stockInsert(imVo);
		
	}
	
	// 재고 수정 
	@RequestMapping("/StockUpdate")
	@ResponseBody
	public void stockUpdate(
			HttpServletRequest request, HttpServletResponse response, 
			@RequestParam HashMap<String, Object>map )throws Exception {
		// 재고 페이지에 있는 모든 정보를 map으로 받는다 
		// 배열 속 내용의 length를 arr에 담음 
		int arr = Integer.parseInt((String) map.get("arr[0][idx]"));
		// arr의 수 만큼 반복 
		for (int i = 0; i < arr; i++) {
			HashMap<String, Object> map1 = new HashMap<String, Object>();
			String idx = (String) map.get("arr[" + i + "][idx]");
			if(idx != null) {
			String code = (String) map.get("arr[" + i + "][code]");
			String name = (String) map.get("arr[" + i + "][name]");
			int price = Integer.parseInt((String) map.get("arr[" + i  + "][price]"));
			String market = (String) map.get("arr[" + i + "][market]");
			String remarks = (String) map.get("arr[" + i + "][remarks]");
			int member_num = Integer.parseInt((String) map.get("arr[" + i  + "][member_num]"));
			map1.put("idx", Integer.parseInt(idx));
			map1.put("code", code);
			map1.put("name", name);
			map1.put("price", price);
			map1.put("market", market);
			map1.put("remarks", remarks);
			map1.put("member_num", member_num);
			imService.stockUpdate(map1);
			}else {
				// 더이상 idx의 값이 없으면 반복문 break
				System.out.println("끝!");
				break;
			}
		}
	}
	
	// 장바구니에 담기 
	@RequestMapping("/StockBasket")
	@ResponseBody
	public void stockBasket(
			HttpServletRequest request, HttpServletResponse response, 
			@RequestParam HashMap<String, Object>map )throws Exception {
		// '담기' 클릭시 그 행의 모든 정보를 map으로 받아 db에 저장 
		imService.putStockBasket(map);
	}
	
	// 재고 알람 페이지 이동 
	@RequestMapping("/StockAlarm")
	public ModelAndView stockAlarm()throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/stock_alarm");
		return mv;
	}
	
	// 장바구니의 목록보기 
	@RequestMapping("/OrderBasket")
	@ResponseBody
	public List<ImVo>list(
			HttpServletRequest request, HttpServletResponse response,HttpSession session 
			)throws Exception {
		MemberVo vo = (MemberVo) session.getAttribute("login");
		List<ImVo>basketList =  imService.getBasketList(vo);
		
		return basketList;
	}
	
	// 장바구니 안 물품 삭제 
	@RequestMapping(value="/BasketDelete", method = RequestMethod.POST)
	@ResponseBody
	public void stockBasketDelete(HttpSession session,
			HttpServletRequest request, HttpServletResponse response, 
			@RequestParam(value="orderList[]")List<String>orderList )throws Exception {
		MemberVo vo = (MemberVo) session.getAttribute("login");
		HashMap<String,Object>map = new HashMap<String, Object>();
		map.put("idx", orderList);
		map.put("member_num", vo.getMember_num());
		imService.stockBasketDelete(map);
		//imService.putStockBasket(map);
	}
	
	// 재고 삭제 
	@RequestMapping(value="/StockDelete", method = RequestMethod.POST)
	@ResponseBody
	public void stockDelete(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="checkArr[]")List<String>code, int member_num, String member_email, HashMap<String, Object>map)throws Exception {
		map.put("idx", code);
		MemberVo vo  = memberService.member_emailCheck(member_num);
		if(vo.getMember_email().equals(member_email) ) {
			System.out.println("성공");
			imService.stockDelete(map);
		}else {
			System.out.println("실패");
		}
		
		
	}
	

	

	
}
