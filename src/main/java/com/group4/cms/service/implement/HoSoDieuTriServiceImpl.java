package com.group4.cms.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.HoSoDieutriDao;
import com.group4.cms.model.HoSoDieuTriNoiTru;
import com.group4.cms.service.HoSoDieuTriService;

@Service
public class HoSoDieuTriServiceImpl implements HoSoDieuTriService{
	@Autowired
	private HoSoDieutriDao hoSoDieutriDao;

	@Override
	public List<HoSoDieuTriNoiTru> findAll() {
		return hoSoDieutriDao.findAll();
	}

	@Override
	public HoSoDieuTriNoiTru save(HoSoDieuTriNoiTru hoSoDieuTriNoiTru) {
		return hoSoDieutriDao.save(hoSoDieuTriNoiTru);
	}

	@Override
	public void delete(int id) {
		hoSoDieutriDao.delete(id);
	}

	@Override
	public HoSoDieuTriNoiTru findById(int id) {
		return hoSoDieutriDao.findOne(id);
	}

	@Override
	public List<HoSoDieuTriNoiTru> findByBeingTreated() {
		return hoSoDieutriDao.findByBeingTreated();
	}
}
