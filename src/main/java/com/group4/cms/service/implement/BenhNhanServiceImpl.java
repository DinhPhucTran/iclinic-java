package com.group4.cms.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.BenhNhanDao;
import com.group4.cms.model.BenhNhan;
import com.group4.cms.service.BenhNhanService;

@Service
public class BenhNhanServiceImpl implements BenhNhanService {

	@Autowired
	private BenhNhanDao benhNhanDao;
	
	public List<BenhNhan> findAll() {
		return benhNhanDao.findAll();
	}

	public BenhNhan save(BenhNhan benhNhan) {
		return benhNhanDao.save(benhNhan);
	}

	public void delete(int id) {
		benhNhanDao.delete(id);
	}

	public BenhNhan findById(int id) {
		return benhNhanDao.findOne(id);
	}

	@Override
	public Integer countBenhNhan() {
		try{
			return benhNhanDao.countBenhNhan();
		} catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer countBenhNhanMoi() {
		try {
			return benhNhanDao.countBenhNhanMoi();
		} catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}
}
