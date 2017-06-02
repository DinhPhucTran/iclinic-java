package com.group4.cms.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.PhongDao;
import com.group4.cms.model.DichVu;
import com.group4.cms.model.Phong;
import com.group4.cms.service.PhongService;

@Service
public class PhongServiceImpl implements PhongService{

	@Autowired
	private PhongDao phongDao;
	
	@Override
	public List<Phong> findAll() {
		List<Phong> phongList = new ArrayList<Phong>();
		try {
			phongList = phongDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phongList;
	}

	@Override
	public Phong save(Phong phong) {
		try {
			return phongDao.save(phong);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(int id) {
		try {
			phongDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Phong findById(int id) {
		return phongDao.findOne(id);
	}

	@Override
	public List<Phong> findByDichVu(int id) {
		return phongDao.findByDichVu(id);
	}
	
}
