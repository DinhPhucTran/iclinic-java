package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.ChiTietDieuTri;

public interface ChiTietDieuTriService {
	
	public List<ChiTietDieuTri> findAll();

	public ChiTietDieuTri save(ChiTietDieuTri chiTietDieuTri);

	public void delete(int id);

	public ChiTietDieuTri findById(int id);
}
