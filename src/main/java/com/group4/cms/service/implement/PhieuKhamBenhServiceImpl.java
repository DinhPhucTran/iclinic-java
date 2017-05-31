/* PhieuKhamBenhServiceIplm - Add by Hang - 31/05/2017 */
package com.group4.cms.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.PhieuKhamBenhDao;
import com.group4.cms.model.PhieuKhamBenh;
import com.group4.cms.service.PhieuKhamBenhService;

@Service
public class PhieuKhamBenhServiceImpl implements PhieuKhamBenhService{

	@Autowired
	private PhieuKhamBenhDao phieuKhamBenhDao;
	
	public List<PhieuKhamBenh> findAll() {
		List<PhieuKhamBenh> result = phieuKhamBenhDao.findAll();
		return result;
	}
	public PhieuKhamBenh save(PhieuKhamBenh phieuKhamBenh) {
		return phieuKhamBenhDao.save(phieuKhamBenh);
	}
	public PhieuKhamBenh findById(Integer id) {
		return phieuKhamBenhDao.findOne(id);
	}
}
