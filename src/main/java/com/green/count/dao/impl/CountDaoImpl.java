package com.green.count.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.count.dao.CountDao;
import com.green.count.vo.CountVo;
import com.green.im.vo.ImVo;
import com.green.member.vo.MemberVo;

@Repository("countDao")
public class CountDaoImpl implements CountDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void orderBasketList(List<ImVo> list) {
		sqlSession.insert("Count.OrderBasketList", list);
		
	}

	@Override
	public void updateQuantity(HashMap<String, Object> map1) {
		System.out.println("다오에서 map1 : " + map1);
		sqlSession.update("Count.UpdateQuantity", map1);
	}

	@Override
	public void inCount(HashMap<String, Object> map1) {
		sqlSession.insert("Count.inCount",map1);
	}

	@Override
	public List<CountVo> getInOutCount(MemberVo vo) {
		 List<CountVo>list = sqlSession.selectList("Count.InOutList", vo);
		return list;
	}

	@Override
	public void countInsert(CountVo countVo) {
		sqlSession.insert("Count.InsertInCount", countVo);
	}
	@Override
	public void countInsert2(CountVo countVo) {
		sqlSession.insert("Count.InsertOutCount", countVo);
	}

	@Override
	public void countUpdate(HashMap<String, Object> map1) {
		sqlSession.update("Count.UpdateCount", map1);
	}

	@Override
	public List<CountVo> getInCoList(int member_num) {
		
		List<CountVo> list = sqlSession.selectList("Count.ViewInCount", member_num);
		return list;
	}

	@Override
	public List<CountVo> getOutCoList(HashMap<String, Object> map) {
		sqlSession.selectList("Count.ViewOutCount", map);
		
		List<CountVo> list = (List<CountVo>)map.get("result");
		
		return list;
	}

	@Override
	public List<CountVo> getInOutCoList(HashMap<String, Object> map) {
		sqlSession.selectList("Count.ViewCount", map);
		
		List<CountVo> list = (List<CountVo>)map.get("result");
		return list;
	}

	@Override
	public void deCount(HashMap<String, Object> map1) {
		sqlSession.update("Count.DeCount", map1);
	}

	@Override
	public void savedeCount(HashMap<String, Object> map1) {
		sqlSession.insert("Count.InsertOutCount",map1);
		
	}

	@Override
	public void putOutCountBasket(HashMap<String, Object> map) {
		sqlSession.insert("Count.InsertOutCountBasket", map);
	}

	@Override
	public List<ImVo> getOutCountList(MemberVo vo) {
		List<ImVo> list = sqlSession.selectList("Count.OutCountList", vo);
		return list;
	}

	@Override
	public void outCount(HashMap<String, Object> map1) {
		sqlSession.insert("Count.OutCountInsert", map1);
	}

	@Override
	public void outCountBasketDelete(HashMap<String, Object> map) {
		sqlSession.delete("Count.outCountBasketDelete", map);
	}

}
