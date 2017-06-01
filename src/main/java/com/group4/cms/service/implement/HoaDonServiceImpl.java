package com.group4.cms.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.HoaDonDao;
import com.group4.cms.model.HoaDon;
import com.group4.cms.service.HoaDonService;

@Service
public class HoaDonServiceImpl implements HoaDonService {
	@Autowired
	HoaDonDao hoaDonDao;

	public List<HoaDon> findAll() {
		List<HoaDon> result = new ArrayList<HoaDon>();
		try {
			result = hoaDonDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public HoaDon save(HoaDon hoaDon) {
		try {
			return hoaDonDao.save(hoaDon);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(int id) {
		try {
			hoaDonDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public HoaDon findById(int id) {
		return hoaDonDao.findOne(id);
	}
}
