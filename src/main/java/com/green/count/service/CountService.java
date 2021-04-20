package com.green.count.service;

import java.util.HashMap;
import java.util.List;

import com.green.count.vo.CountVo;
import com.green.im.vo.ImVo;
import com.green.member.vo.MemberVo;

public interface CountService {

	void countInsert(CountVo countVo);

	void countUpdate(HashMap<String, Object> map1);

	void orderBasketList(List<ImVo> list);

	void updateQuantity(HashMap<String, Object> map1);

	void inCount(HashMap<String, Object> map1);

	List<CountVo> getInOutCount(MemberVo vo);

	void countInsert2(CountVo countVo);

	List<CountVo> getCoList(int member_num);

	List<CountVo> getCoList2(HashMap<String, Object> map);

	List<CountVo> getCoList3(HashMap<String, Object> map);

	void deCount(HashMap<String, Object> map1);

	void savedeCount(HashMap<String, Object> map1);

	void putOutCountBasket(HashMap<String, Object> map);

	List<ImVo> getOutCountList(MemberVo vo);

	void outCount(HashMap<String, Object> map1);

	void outCountBasketDelete(HashMap<String, Object> map);

}
