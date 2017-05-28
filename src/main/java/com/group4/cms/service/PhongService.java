package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.Phong;

public interface PhongService {

public List<Phong> findAll();
	
	public Phong save(Phong phong);
	
	public void delete(int id);
	
	public Phong findById(int id);

	public List<Phong> findByDichVu(int i);
}
