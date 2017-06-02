package com.group4.cms.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.DonThuocDao;
import com.group4.cms.model.DonThuoc;
import com.group4.cms.service.DonThuocService;

@Service
public class DonThuocServiceImpl implements DonThuocService {
	@Autowired
	DonThuocDao dtDao;

	public List<DonThuoc> findAll() {
		List<DonThuoc> result = new ArrayList<DonThuoc>();
		try {
			result = dtDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public DonThuoc save(DonThuoc DonThuoc) {
		try {
			return dtDao.save(DonThuoc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(int id) {
		try {
			dtDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public DonThuoc findById(int id) {
		return dtDao.findOne(id);
	}
}
