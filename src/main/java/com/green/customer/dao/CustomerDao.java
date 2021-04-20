package com.green.customer.dao;

import java.util.HashMap;
import java.util.List;

import com.green.customer.vo.CustomerVo;

public interface CustomerDao {

	void insert(HashMap<String, Object> map);

	List<CustomerVo> view(HashMap<String, Object> map);

	void update(HashMap<String, Object> map);

	List<CustomerVo> getCustomerList(HashMap<String, Object> map);

	void customerInsert(CustomerVo customerVo);

	void customerDelete(HashMap<String, Object> map);

	void customerUpdate(HashMap<String, Object> map1);

}
