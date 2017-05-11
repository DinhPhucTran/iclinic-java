package com.group4.cms.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.GiayNhapVienDao;
import com.group4.cms.model.GiayNhapVien;
import com.group4.cms.service.GiayNhapVienService;

@Service
public class GiayNhapVienServiceImpl implements GiayNhapVienService{

	@Autowired
	private GiayNhapVienDao giayNhapVienDao;
	
	public List<GiayNhapVien> findAll() {
		return giayNhapVienDao.findAll();
	}

	public GiayNhapVien save(GiayNhapVien giayNhapVien) {
		return giayNhapVienDao.save(giayNhapVien);
	}

	public void delete(int id) {
		giayNhapVienDao.delete(id);
	}

	public GiayNhapVien findById(int id) {
		return giayNhapVienDao.findOne(id);
	}
	
}
