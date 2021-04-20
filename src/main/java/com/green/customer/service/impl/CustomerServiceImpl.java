package com.green.customer.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.customer.dao.CustomerDao;
import com.green.customer.service.CustomerService;
import com.green.customer.vo.CustomerVo;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public void insert(HashMap<String, Object> map) {
		
		customerDao.insert(map);
		System.out.println("service :" + map);
	}

	@Override
	public List<CustomerVo> getCmView(HashMap<String, Object> map) {
		
		List<CustomerVo> cmList = customerDao.view(map);
		return cmList;
	}

	@Override
	public void update(HashMap<String, Object> map) {
		
		customerDao.update(map);
		
	}

	@Override
	public List<CustomerVo> getCustomerList(HashMap<String, Object> map) {
		List<CustomerVo> list = customerDao.getCustomerList(map);
		return list;
	}

	@Override
	public void customerInsert(CustomerVo customerVo) {
		customerDao.customerInsert(customerVo);
	}

	@Override
	public void customerDelete(HashMap<String, Object> map) {
		customerDao.customerDelete(map);
	}

	@Override
	public void customerUpdate(HashMap<String, Object> map1) {
		customerDao.customerUpdate(map1);
	}
}
