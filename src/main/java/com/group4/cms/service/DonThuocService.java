package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.DonThuoc;
public interface DonThuocService {
	public List<DonThuoc> findAll();
	
	public DonThuoc save(DonThuoc DonThuoc);
	
	public void delete(int id);
	
	public DonThuoc findById(int id);

	public List<DonThuoc> findByMaPhieuKham(Integer maPhieuKham);
}
