package com.green.count.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.count.dao.CountDao;
import com.green.count.service.CountService;
import com.green.count.vo.CountVo;
import com.green.im.vo.ImVo;
import com.green.member.vo.MemberVo;

@Service("countService")
public class CountServiceImpl implements CountService {
	
	@Autowired
	private CountDao countDao;

	@Override
	public void countInsert(CountVo countVo) {
		countDao.countInsert(countVo);
	}
	@Override
	public void countInsert2(CountVo countVo) {
		countDao.countInsert2(countVo);
	}

	@Override
	public void countUpdate(HashMap<String, Object> map1) {
		countDao.countUpdate(map1);
	}

	@Override
	public void orderBasketList(List<ImVo> list) {
		countDao.orderBasketList(list);
	}

	@Override
	public void updateQuantity(HashMap<String, Object> map1) {
		countDao.updateQuantity(map1);
	}
	
	// 장바구니 -> 주문하기 
	@Override
	public void inCount(HashMap<String, Object> map1) {
		countDao.inCount(map1);
	}

	@Override
	public List<CountVo> getInOutCount(MemberVo vo) {
		List<CountVo>list = countDao.getInOutCount(vo);
		return list;
	}
	
	// incout.jsp 입고 리스트 
	@Override
	public List<CountVo> getCoList(int member_num) {
		List<CountVo> list = countDao.getInCoList(member_num);
		return list;
	}
	// outcout.jsp 출고 리스트 
	@Override
	public List<CountVo> getCoList2(HashMap<String, Object> map) {
		List<CountVo> list = countDao.getOutCoList(map);
		return list;
	}
	// inoutcount.jsp 입출고 리스트
	@Override
	public List<CountVo> getCoList3(HashMap<String, Object> map) {
		List<CountVo> list = countDao.getInOutCoList(map);
		
		return list;
	}
	@Override
	public void deCount(HashMap<String, Object> map1) {
		countDao.deCount(map1);
		
	}
	@Override
	public void savedeCount(HashMap<String, Object> map1) {
		countDao.savedeCount(map1);
		
	}
	@Override
	public void putOutCountBasket(HashMap<String, Object> map) {
		countDao.putOutCountBasket(map);
	}
	@Override
	public List<ImVo> getOutCountList(MemberVo vo) {
		List<ImVo>list = countDao.getOutCountList(vo);
		return list;
	}
	@Override
	public void outCount(HashMap<String, Object> map1) {
		countDao.outCount(map1);
	}
	@Override
	public void outCountBasketDelete(HashMap<String, Object> map) {
		countDao.outCountBasketDelete(map);
	}


}
