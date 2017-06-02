package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.ChiTietDonThuoc;

public interface ChiTietDonThuocService {
	
	public List<ChiTietDonThuoc> findAll();

	public ChiTietDonThuoc save(ChiTietDonThuoc chiTietDonThuoc);

	public void delete(int id);

	public ChiTietDonThuoc findById(int id);
}
