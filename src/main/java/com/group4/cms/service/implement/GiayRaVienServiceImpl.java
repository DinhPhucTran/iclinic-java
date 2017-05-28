package com.group4.cms.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.GiayRaVienDao;
import com.group4.cms.model.GiayRaVien;
import com.group4.cms.service.GiayRaVienService;

@Service
public class GiayRaVienServiceImpl implements GiayRaVienService{

	@Autowired
	private GiayRaVienDao giayRaVienDao;
	
	@Override
	public List<GiayRaVien> findAll() {
		return giayRaVienDao.findAll();
	}

	@Override
	public GiayRaVien save(GiayRaVien giayRaVien) {
		return giayRaVienDao.save(giayRaVien);
	}

	@Override
	public void delete(int id) {
		giayRaVienDao.delete(id);
	}

	@Override
	public GiayRaVien findById(int id) {
		return giayRaVienDao.findOne(id);
	}

}
