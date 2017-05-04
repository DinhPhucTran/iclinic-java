package com.group4.cms.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.BoPhanDao;
import com.group4.cms.model.BoPhan;
import com.group4.cms.service.BoPhanService;

@Service
public class BoPhanServiceImpl implements BoPhanService {
	
	@Autowired
	BoPhanDao bpDao;

	@Override
	public List<BoPhan> findAll() {
		List<BoPhan> result = new ArrayList<BoPhan>();
		try{
			result = bpDao.findAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public BoPhan save(BoPhan boPhan) {
		try{
			return bpDao.save(boPhan);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(int id) {
		try{
			bpDao.delete(id);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public BoPhan findById(int id) {
		return bpDao.findOne(id);
	}

}
