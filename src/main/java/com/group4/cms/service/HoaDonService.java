package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.HoaDon;
public interface HoaDonService {
	public List<HoaDon> findAll();
	
	public HoaDon save(HoaDon HoaDon);
	
	public void delete(int id);
	
	public HoaDon findById(int id);
}
