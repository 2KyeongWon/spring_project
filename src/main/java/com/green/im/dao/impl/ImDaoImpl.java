package com.green.im.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.im.dao.ImDao;
import com.green.im.vo.ImVo;
import com.green.member.vo.MemberVo;

@Repository("imDao")
public class ImDaoImpl implements ImDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void setInsert(HashMap<String, Object> map) {
		sqlSession.insert("Im.Insert",map);
	}

	@Override
	public List<ImVo> getImList(HashMap<String, Object> map) {
		sqlSession.selectList("Im.ImList", map);
		
		List<ImVo>list = (List<ImVo>) map.get("result");
		return list;
	}

	@Override
	public void setWrite(HashMap<String, Object> map) {
		sqlSession.delete("Im.Delete", map);
		
	}

	@Override
	public void stockInsert(ImVo imVo) {
		sqlSession.insert("Im.StockInsert", imVo);
	}

	@Override
	public List<ImVo> getDataList(int member_num) {
		List<ImVo> list = sqlSession.selectList("Im.DataList", member_num);
		return list;
	}

	@Override
	public void stockDelete(HashMap<String, Object> map) {
		System.out.println("gd : " + map);
		sqlSession.delete("Im.StockDelete",map);
	}


	@Override
	public void sotckUpdate(HashMap<String, Object> map1) {
		sqlSession.update("Im.StockUpdate",map1);
	}


	@Override
	public void putStockBasket(HashMap<String, Object> map) {
		sqlSession.insert("Im.StockBasket", map);
	}

	@Override
	public void stockUpdate(ImVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ImVo> getOrderList(MemberVo vo) {
		List<ImVo> list = sqlSession.selectList("Im.OrderList", vo);
		return list;
	}

	@Override
	public void stockBasketDelete(HashMap<String, Object> map) {
		sqlSession.delete("Im.OrderListDelete",map);
	}

	@Override
	public List<ImVo> getBasketList(MemberVo vo) {
		List<ImVo>list = sqlSession.selectList("Im.GetBasketList",vo);
		return list;
	}

	@Override
	public List<ImVo> getLowQuantityList(int member_num) {
		List<ImVo> list = sqlSession.selectList("Im.LowQuantityList", member_num);
		return list;
	}




	


}
