package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.GiayNhapVien;

public interface GiayNhapVienService {
	
	public List<GiayNhapVien> findAll();

	public GiayNhapVien save(GiayNhapVien giayNhapVien);

	public void delete(int id);

	public GiayNhapVien findById(int id);
}
