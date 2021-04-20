package com.green.im.service;

import java.util.HashMap;
import java.util.List;

import com.green.im.vo.ImVo;
import com.green.member.vo.MemberVo;

public interface ImService {

	List<ImVo> getImList(HashMap<String, Object> map);

	void setInsert(HashMap<String, Object> map);

	void setDelete(HashMap<String, Object> idxArr);

	void stockInsert(ImVo imVo);

	List<ImVo> getImList(int member_num);

	void stockDelete(HashMap<String, Object> map);

	void stockUpdate(ImVo vo);

	void stockUpdate(HashMap<String, Object> map1);

	void putStockBasket(HashMap<String, Object> map);

	List<ImVo> getOrderList(MemberVo vo);

	void stockBasketDelete(HashMap<String, Object> map);

	List<ImVo> getBasketList(MemberVo vo);

	List<ImVo> getLowQuantityList(int member_num);


}
