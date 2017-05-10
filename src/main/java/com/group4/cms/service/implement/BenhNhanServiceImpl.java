package com.group4.cms.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.BenhNhanDao;
import com.group4.cms.model.BenhNhan;
import com.group4.cms.service.BenhNhanService;

@Service("benhNhanService")
public class BenhNhanServiceImpl implements BenhNhanService {

	@Autowired
	private BenhNhanDao benhNhanDao;
	
	public List<BenhNhan> findAll() {
		List<BenhNhan> result = benhNhanDao.findAll();
		return result;
	}

	public BenhNhan save(BenhNhan benhNhan) {
		return benhNhanDao.save(benhNhan);
	}

	public void delete(int id) {
	}

	public BenhNhan findById(int id) {
		return null;
	}
}
