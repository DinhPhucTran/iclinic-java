package com.group4.cms.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.ThuocDao;
import com.group4.cms.model.Thuoc;
import com.group4.cms.service.ThuocService;

@Service
public class ThuocServiceImpl implements ThuocService {
	@Autowired
	ThuocDao tDao;

	public List<Thuoc> findAll() {
		List<Thuoc> result = new ArrayList<Thuoc>();
		try {
			result = tDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Thuoc save(Thuoc Thuoc) {
		try {
			return tDao.save(Thuoc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(int id) {
		try {
			tDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Thuoc findById(int id) {
		return tDao.findOne(id);
	}
}
