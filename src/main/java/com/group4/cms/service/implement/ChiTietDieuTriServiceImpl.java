package com.group4.cms.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.ChiTietDieuTriDao;
import com.group4.cms.model.ChiTietDieuTri;
import com.group4.cms.service.ChiTietDieuTriService;

@Service
public class ChiTietDieuTriServiceImpl implements ChiTietDieuTriService{

	@Autowired
	private ChiTietDieuTriDao chiTietDieuTriDao;
	
	@Override
	public List<ChiTietDieuTri> findAll() {
		return chiTietDieuTriDao.findAll();
	}

	@Override
	public ChiTietDieuTri save(ChiTietDieuTri chiTietDieuTri) {
		return chiTietDieuTriDao.save(chiTietDieuTri);
	}

	@Override
	public void delete(int id) {
		chiTietDieuTriDao.delete(id);
	}

	@Override
	public ChiTietDieuTri findById(int id) {
		return chiTietDieuTriDao.findOne(id);
	}
}
