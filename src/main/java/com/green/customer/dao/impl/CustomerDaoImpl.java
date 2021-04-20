package com.green.customer.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.customer.dao.CustomerDao;
import com.green.customer.vo.CustomerVo;
import com.green.im.vo.ImVo;

@Repository("CustomerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(HashMap<String, Object> map) {
		
		sqlSession.insert("Customer.InsertCustomer", map);
		System.out.println("dao:" + map);      
		
		
	}

	@Override
	public List<CustomerVo> view(HashMap<String, Object> map) {
		List<CustomerVo> cmList = (List<CustomerVo>)map.get("result");
//		CustomerVo cmVo = cmList.get(0);
		
		return cmList;
	}

	@Override
	public void update(HashMap<String, Object> map) {
		sqlSession.update("Customer.C", map);
		
	}

	@Override
	public List<CustomerVo> getCustomerList(HashMap<String, Object> map) {
		sqlSession.selectList("Customer.CustomerList", map);
		List<CustomerVo>list = (List<CustomerVo>) map.get("result");
		return list ;
	}

	@Override
	public void customerInsert(CustomerVo customerVo) {
		sqlSession.insert("Customer.CustomerInsert",customerVo);
	}

	@Override
	public void customerDelete(HashMap<String, Object> map) {
		sqlSession.delete("Customer.CustomerDelete",map);
	}

	@Override
	public void customerUpdate(HashMap<String, Object> map1) {
		sqlSession.update("Customer.CustomerUpdate", map1);
	}

}
