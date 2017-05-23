package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.GiayRaVien;

public interface GiayRaVienService {
	
	public List<GiayRaVien> findAll();

	public GiayRaVien save(GiayRaVien giayRaVien);

	public void delete(int id);

	public GiayRaVien findById(int id);
}
