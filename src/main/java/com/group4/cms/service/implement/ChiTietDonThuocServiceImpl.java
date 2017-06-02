package com.group4.cms.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.ChiTietDonThuocDao;
import com.group4.cms.model.ChiTietDonThuoc;
import com.group4.cms.service.ChiTietDonThuocService;

@Service
public class ChiTietDonThuocServiceImpl implements ChiTietDonThuocService{

	@Autowired
	private ChiTietDonThuocDao ChiTietDonThuocDao;
	
	public List<ChiTietDonThuoc> findAll() {
		return ChiTietDonThuocDao.findAll();
	}

	public ChiTietDonThuoc save(ChiTietDonThuoc ChiTietDonThuoc) {
		return ChiTietDonThuocDao.save(ChiTietDonThuoc);
	}

	public void delete(int id) {
		ChiTietDonThuocDao.delete(id);
	}

	public ChiTietDonThuoc findById(int id) {
		return ChiTietDonThuocDao.findOne(id);
	}
}
