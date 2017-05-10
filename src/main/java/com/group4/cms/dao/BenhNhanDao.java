package com.group4.cms.dao;

import java.util.List;

import com.group4.cms.model.BenhNhan;

public interface BenhNhanDao {
	
	public List<BenhNhan> findAll();

	public BenhNhan save(BenhNhan boPhan);

	public void delete(int id);

	public BenhNhan findById(int id);
}
