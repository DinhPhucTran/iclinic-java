package com.group4.cms.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.DichVuDao;
import com.group4.cms.model.DichVu;
import com.group4.cms.service.DichVuService;

@Service
public class DichVuServiceImpl implements DichVuService {
	@Autowired
	DichVuDao dvDao;

	public List<DichVu> findAll() {
		List<DichVu> result = new ArrayList<DichVu>();
		try {
			result = dvDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public DichVu save(DichVu dichVu) {
		try {
			return dvDao.save(dichVu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(int id) {
		try {
			dvDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public DichVu findById(int id) {
		return dvDao.findOne(id);
	}

	@Override
	public int countDichVu() {
		// TODO Auto-generated method stub
		try{
			return dvDao.countDichVu();
		} catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	
}
