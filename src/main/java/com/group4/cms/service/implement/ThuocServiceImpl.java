package com.group4.cms.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.ThuocDao;
import com.group4.cms.model.Thuoc;
import com.group4.cms.service.ThuocService;

@Service
public class ThuocServiceImpl implements ThuocService{

	@Autowired
	ThuocDao thuocDao;

//	@Override
	public List<Thuoc> findAll() {
		List<Thuoc> result = new ArrayList<Thuoc>();
		try{
			result = thuocDao.findAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}

//	@Override
	public Thuoc save(Thuoc thuoc) {
		try{
			return thuocDao.save(thuoc);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

//	@Override
	public void delete(int id) {
		try{
			thuocDao.delete(id);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

//	@Override
	public Thuoc findById(int id) {
		return thuocDao.findOne(id);
	}
}
