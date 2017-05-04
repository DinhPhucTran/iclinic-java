package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.BoPhan;

public interface BoPhanService {
	public List<BoPhan> findAll();
	
	public BoPhan save(BoPhan boPhan);
	
	public void delete(int id);
	
	public BoPhan findById(int id);
}
