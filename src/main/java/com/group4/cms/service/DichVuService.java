package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.DichVu;
public interface DichVuService {
	
	public List<DichVu> findAll();
	
	public DichVu findById(int id);
	
	public DichVu save(DichVu dichVu);
	
	public void delete(int id);
	
	public int countDichVu();
}
