package com.green.customer.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.green.customer.service.CustomerService;
import com.green.customer.vo.CustomerVo;
import com.green.im.vo.ImVo;
import com.green.member.service.MemberService;
import com.green.member.vo.MemberVo;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private MemberService memberService;

	// 거래처 리스트로 이동 
	@RequestMapping("/CustomerList")
	public ModelAndView customerList(
			@RequestParam HashMap<String, Object>map) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/customer/customer_list");
		return mv;
	}
	
	// 거래처 수정으로 이동 
	@RequestMapping("/CustomerEdit")
	public ModelAndView customerEdit(
			@RequestParam HashMap<String, Object>map) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/customer/customer_edit");
		return mv;
	}

	// 거래처 리스트를 가져온다 
	@RequestMapping("/ListCustomer")
	@ResponseBody
	public List<CustomerVo>list (
			HttpServletRequest request, HttpServletResponse response, HashMap<String, Object>map,
			int member_num) {
		// 넘어온 고객 넘버를 map에 담는다 
		map.put("member_num", member_num);
		// map을 이용해서 거래처 리스트를 가져와  dataList 에 저장한다 
		List<CustomerVo> dataList = customerService.getCustomerList(map);
		// ajax dataList 리턴 
		return dataList;
	}
	
	// 거래처 등록 
	@RequestMapping("/CustomerInsert")
	@ResponseBody
	public void customerInsert(
			HttpServletRequest request, HttpServletResponse response, 
			CustomerVo customerVo)throws Exception {
		// ajax로 넘어온 값을 vo로 받아 db에 insert한다 
		customerService.customerInsert(customerVo);
		
	}
	
	// 거래처 삭제 
	@RequestMapping("/CustomerDelete")
	@ResponseBody
	public void customerDelete(
			HttpServletRequest request, HttpServletResponse response, 
			@RequestParam(value="checkArr[]")List<Integer>idx, int member_num, String member_email, HashMap<String, Object>map)throws Exception {
		// 넘어온 idx의 배열을 맵에 담는다 
		map.put("idx", idx);
		// 넘어온 고객 넘버로 고객의 이메일 확인
		MemberVo vo  = memberService.member_emailCheck(member_num);
		// 이메일 비교 
		if(vo.getMember_email().equals(member_email) ) {
			// map을 이용해서 거래처 삭제 
			customerService.customerDelete(map);
		}else {
			System.out.println("실패");
		}
		
	}
	
	// 거래처 수정 
	@RequestMapping("/CostomerUpdate")
	@ResponseBody
	public void costomerUpdate(
			HttpServletRequest request, HttpServletResponse response, 
			@RequestParam HashMap<String, Object>map )throws Exception {
		int arr = Integer.parseInt((String) map.get("arr[0][idx]"));
		// ajax로 넘어온 배열 반복문으로 전부 수정 
		for (int i = 0; i < arr; i++) {
			HashMap<String, Object> map1 = new HashMap<String, Object>();
			String idx = (String) map.get("arr[" + i + "][idx]");
			if(idx!=null) {
			String it = (String) map.get("arr[" + i + "][it]");
			String name = (String) map.get("arr[" + i + "][name]");
			String tel = (String) map.get("arr[" + i + "][tel]");
			String email = (String) map.get("arr[" + i + "][email]");
			String remarks = (String) map.get("arr[" + i + "][remarks]");
			int member_num = Integer.parseInt((String) map.get("arr[" + i  + "][member_num]"));
			map1.put("idx", Integer.parseInt(idx));
			map1.put("it", it);
			map1.put("name", name);
			map1.put("tel", tel);
			map1.put("email", email);
			map1.put("remarks", remarks);
			map1.put("member_num", member_num);
			customerService.customerUpdate(map1);
			}else {
				break;
			}
		}
	}
	
}

		 
			
			
		






















