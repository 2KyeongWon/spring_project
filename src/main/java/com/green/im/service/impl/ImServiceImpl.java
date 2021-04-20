package com.green.im.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.im.dao.ImDao;
import com.green.im.service.ImService;
import com.green.im.vo.ImVo;
import com.green.member.vo.MemberVo;

@Service("imService")
public class ImServiceImpl implements ImService {
	@Autowired
	private ImDao imDao;
	
	@Override
	public List<ImVo> getImList(HashMap<String, Object> map) {
		List<ImVo> list = imDao.getImList(map);
		return list;
	}

	@Override
	public void setInsert(HashMap<String, Object> map) {
		imDao.setInsert(map);
	}

	@Override
	public void setDelete(HashMap<String, Object> map) {
		imDao.setWrite(map);
		
	}

	@Override
	public void stockInsert(ImVo imVo) {
		
		imDao.stockInsert(imVo);
		
		
	}

	@Override
	public List<ImVo> getImList(int member_num) {
		List<ImVo> list = imDao.getDataList(member_num);
		return list;
	}

	@Override
	public void stockDelete(HashMap<String, Object> map) {
		imDao.stockDelete(map);
	}

	@Override
	public void stockUpdate(ImVo vo) {
		imDao.stockUpdate(vo);
	}

	@Override
	public void stockUpdate(HashMap<String, Object> map1) {
		imDao.sotckUpdate(map1);
	}

	@Override
	public void putStockBasket(HashMap<String, Object> map) {
		imDao.putStockBasket(map);
	}

	@Override
	public List<ImVo> getOrderList(MemberVo vo) {
		List<ImVo> list = imDao.getOrderList(vo);
		return list;
	}

	@Override
	public void stockBasketDelete(HashMap<String, Object> map) {
		imDao.stockBasketDelete(map);
	}

	@Override
	public List<ImVo> getBasketList(MemberVo vo) {
		List<ImVo> list = imDao.getBasketList(vo);
		return list;
	}

	@Override
	public List<ImVo> getLowQuantityList(int member_num) {
		List<ImVo> list = imDao.getLowQuantityList(member_num);
		return list;
	}





}
