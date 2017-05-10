package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.BenhNhan;

public interface BenhNhanService {
	
	public List<BenhNhan> findAll();
	
	public BenhNhan save(BenhNhan benhNhan);
	
	public void delete(int id);
	
	public BenhNhan findById(int id);
}
