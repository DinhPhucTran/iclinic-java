package com.group4.cms.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.PhongDao;
import com.group4.cms.model.Phong;
import com.group4.cms.service.PhongService;

@Service
public class PhongServiceImpl implements PhongService{

	@Autowired
	private PhongDao phongDao;
	
	@Override
	public List<Phong> findAll() {
		return phongDao.findAll();
	}

	@Override
	public Phong save(Phong phong) {
		return phongDao.save(phong);
	}

	@Override
	public void delete(int id) {
		phongDao.delete(id);
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
