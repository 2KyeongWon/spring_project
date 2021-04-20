package com.green.im.dao;

import java.util.HashMap;
import java.util.List;

import com.green.im.vo.ImVo;
import com.green.member.vo.MemberVo;

public interface ImDao {

	void setInsert(HashMap<String, Object> map);

	List<ImVo> getImList(HashMap<String, Object> map);

	void setWrite(HashMap<String, Object> map);

	void stockInsert(ImVo imVo);

	List<ImVo> getDataList(int member_num);

	void stockDelete(HashMap<String, Object> map);

	void stockUpdate(ImVo vo);

	void sotckUpdate(HashMap<String, Object> map1);

	void putStockBasket(HashMap<String, Object> map);

	List<ImVo> getOrderList(MemberVo vo);

	void stockBasketDelete(HashMap<String, Object> map);

	List<ImVo> getBasketList(MemberVo vo);

	List<ImVo> getLowQuantityList(int member_num);

}
