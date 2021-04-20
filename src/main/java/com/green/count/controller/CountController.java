package com.green.count.controller;

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
import com.green.im.vo.ImVo;
import com.green.member.vo.MemberVo;

@Controller
public class CountController {
	
	@Autowired
	private CountService countService;
	
	
	// incout.jsp 이동
	@RequestMapping("/CountInCount")
	public ModelAndView incountList(HttpSession   session,
			HttpServletRequest request,HttpServletResponse response,
			@RequestParam HashMap<String, Object>map) {
		session = request.getSession();
		ModelAndView mv = new ModelAndView();
		 mv.setViewName("/count/incount"); 
		return mv;
	}
	// 입고 리스트 불러오기
	@RequestMapping("/IncountList")
	@ResponseBody
	public List<CountVo> list(HttpServletRequest request, 
			HttpServletResponse response, Model model,
			int member_num ) {
		List<CountVo> dataList = countService.getCoList(member_num);
		return dataList;
	}
	
	
	@RequestMapping("/CountOutCount")
	public ModelAndView outcountList(HttpSession   session,
			HttpServletRequest request,HttpServletResponse response,
			@RequestParam HashMap<String, Object>map) {
		session = request.getSession();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/count/outcount"); 
		return mv;
	}
	
	@RequestMapping("/OutcountList")
	@ResponseBody
	public List<CountVo> list2(HttpServletRequest request, HttpServletResponse response, Model model,
			HashMap<String, Object> map) {
		List<CountVo> dataList = countService.getCoList2(map);
		return dataList;
	}
	
	
	@RequestMapping("/CountInOutCount")
	public ModelAndView inoutcountList(HttpSession session, HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam HashMap<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		MemberVo vo = (MemberVo) session.getAttribute("login");
		// 로그인 세션의 고객 정보를 통해서 입출고 내역을 가져온다
		List<CountVo>list = countService.getInOutCount(vo);
		mv.addObject("list", list);
		mv.setViewName("/count/inoutcount");
		return mv;
	}
	
	@RequestMapping("/InOutcountList")
	@ResponseBody
	public List<CountVo> list3(HttpServletRequest request, HttpServletResponse response, Model model,
			HashMap<String, Object> map ) {
		List<CountVo> dataList = countService.getCoList3(map);
		return dataList;
	}
	
	
	
	// 입고 추가
	@RequestMapping("/CountInsert")
	@ResponseBody
	public void countInsert(
			HttpServletRequest request, HttpServletResponse response, 
			CountVo countVo)throws Exception {
		countService.countInsert(countVo);
		
	}
	// 출고 추가
	@RequestMapping("/CountInsert2")
	@ResponseBody
	public void countInsert2(
			HttpServletRequest request, HttpServletResponse response, 
			CountVo countVo)throws Exception {
		countService.countInsert2(countVo);
		
	}
	
	// 출고
	@RequestMapping("/DeCount")
	@ResponseBody
	public void deCount(HttpSession session,HttpServletRequest request,HttpServletResponse response,
			@RequestParam HashMap<String, Object> map) {
		System.out.println("imVo : " + map);
		countService.putOutCountBasket(map);
		
	}
	
	// 출고 페이지 이동 
	@RequestMapping("/OutCountPage")
	@ResponseBody
	public ModelAndView outCounPage(HttpSession session,HttpServletRequest request,HttpServletResponse response,
			@RequestParam HashMap<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		MemberVo vo = (MemberVo) session.getAttribute("login");
		List<ImVo> outCountList = countService.getOutCountList(vo);
		mv.addObject("outCountlist", outCountList);
		mv.setViewName("/count/out_count_page");
		return mv;
	}
	
	// 출고 작업 
	@RequestMapping("/OutCountEnd")
	@ResponseBody
	public void outCountEnd(HttpSession session,HttpServletRequest request,HttpServletResponse response,
			@RequestParam HashMap<String, Object> map) {
		System.out.println("map.size() : " + map.size());
		System.out.println("출고 작업 map : "+ map);
		for (int i = 0; i < map.size(); i++) {
			HashMap<String, Object> map1 = new HashMap<String, Object>();
			String idx = (String) map.get("arr[" + i + "][idx]");
			if(idx != null) {
			String code = (String) map.get("arr[" + i + "][code]");
			String name = (String) map.get("arr[" + i + "][name]");
			String price = (String) map.get("arr[" + i + "][price]");
			String quantity = (String) map.get("arr[" + i + "][quantity]");
			String market = (String) map.get("arr[" + i + "][market]");
			String member_num = (String) map.get("arr[" + i + "][member_num]");
			map1.put("idx", Integer.parseInt(idx));
			map1.put("code", code);
			map1.put("name", name);
			map1.put("price", Integer.parseInt(price));
			map1.put("quantity", Integer.parseInt(quantity));
			map1.put("market", market);
			map1.put("member_num", Integer.parseInt(member_num));
			System.out.println(map1);
			countService.outCount(map1);
			}else {
				break;
			}
		}
	}
	
	// 출고 목록 안 목록 삭제 
	@RequestMapping(value="/OutCountBasketDelete", method = RequestMethod.POST)
	@ResponseBody
	public void stockBasketDelete(HttpSession session,
			HttpServletRequest request, HttpServletResponse response, 
			@RequestParam(value="outCountList[]")List<String>orderList )throws Exception {
		MemberVo vo = (MemberVo) session.getAttribute("login");
		HashMap<String,Object>map = new HashMap<String, Object>();
		map.put("idx", orderList);
		map.put("member_num", vo.getMember_num());
		System.out.println("출고 목록 삭제: "+ map);
		countService.outCountBasketDelete(map);
	}
	
	
	
	
	
	@RequestMapping("/OrderEnd")
	@ResponseBody
	public void orderEnd(HttpSession session,HttpServletRequest request,HttpServletResponse response,
			@RequestParam HashMap<String, Object> map){
		/*
		 * HashMap<String, Object> map1 = new HashMap<String, Object>(); MemberVo vo =
		 * (MemberVo) session.getAttribute("login"); String quantity = (String)
		 * map.get("arr[0][count]"); String idx = (String) map.get("arr[0][idx]");
		 * map1.put("quantity", quantity.substring(0,quantity.length()-1));
		 * map1.put("idx", idx.substring(0,idx.length()-1)); map1.put("member_num",
		 * vo.getMember_num()); List<ImVo> list = imService.getBasketList(vo);
		 * countService.orderBasketList(list); countService.updateQuantity(map1);
		 * System.out.println("끝");
		 */
		System.out.println("map.size() : " + map.size());
		System.out.println("map : "+ map);
		for (int i = 0; i < map.size(); i++) {
			HashMap<String, Object> map1 = new HashMap<String, Object>();
			String idx = (String) map.get("arr[" + i + "][idx]");
			if(idx != null) {
			String code = (String) map.get("arr[" + i + "][code]");
			String name = (String) map.get("arr[" + i + "][name]");
			String price = (String) map.get("arr[" + i + "][price]");
			String quantity = (String) map.get("arr[" + i + "][quantity]");
			String market = (String) map.get("arr[" + i + "][market]");
			String member_num = (String) map.get("arr[" + i + "][member_num]");
			map1.put("idx", Integer.parseInt(idx));
			map1.put("code", code);
			map1.put("name", name);
			map1.put("price", Integer.parseInt(price));
			map1.put("quantity", Integer.parseInt(quantity));
			map1.put("market", market);
			map1.put("member_num", Integer.parseInt(member_num));
			System.out.println(map1);
			countService.inCount(map1);
			}else {
				break;
			}
		}
		
	}
	
	@RequestMapping("/CountUpdate")
	@ResponseBody
	public void countUpdate(
			HttpServletRequest request, HttpServletResponse response, 
			@RequestParam HashMap<String, Object>map )throws Exception {
		System.out.println(map);
		int arr = Integer.parseInt((String) map.get("arr[0][idx]"));
		System.out.println("arr : " + arr);
		for (int i = 0; i < arr; i++) {
			HashMap<String, Object> map1 = new HashMap<String, Object>();
			int 	idx 		= Integer.parseInt((String) map.get("arr[" + i  + "][idx]"));
			String 	code 		= (String) map.get("arr[" + i + "][code]");
			String 	name 		= (String) map.get("arr[" + i + "][name]");
			int 	price 		= Integer.parseInt((String) map.get("arr[" + i  + "][price]"));
			String 	quantity    = (String) map.get("arr[" + i + "][quantity]");
			String 	market 		= (String) map.get("arr[" + i + "][market]");
			int 	member_num 	= Integer.parseInt((String) map.get("arr[" + i  + "][member_num]"));
			int 	count_num 	= Integer.parseInt((String) map.get("arr[" + i  + "][count_num]"));
			map1.put("idx", idx);
			map1.put("code", code);
			map1.put("name", name);
			map1.put("price", price);
			map1.put("quantity", quantity);
			map1.put("market", market);
			map1.put("member_num", member_num);
			map1.put("count_num", count_num);
			//imService.stockUpdate(vo);
			countService.countUpdate(map1);
			System.out.println(map1);
		}
	}
	
		
	
}
