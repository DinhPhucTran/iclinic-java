package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.Thuoc;

public interface ThuocService {
	
	public List<Thuoc> findAll();
	
	public Thuoc save(Thuoc thuoc);
	
	public void delete(int id);
	
	public Thuoc findById(int id);
}
