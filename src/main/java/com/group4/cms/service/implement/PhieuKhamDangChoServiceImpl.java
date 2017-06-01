/* PhieuKhamDangChoServiceIplm - Add by Hang - 31/05/2017 */
package com.group4.cms.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.PhieuKhamDangChoDao;
import com.group4.cms.model.PhieuKhamDangCho;
import com.group4.cms.service.PhieuKhamDangChoService;

@Service
public class PhieuKhamDangChoServiceImpl implements PhieuKhamDangChoService{

	@Autowired
	private PhieuKhamDangChoDao phieuKhamDangChoDao;
	
	public List<PhieuKhamDangCho> findAll() {
		List<PhieuKhamDangCho> result = phieuKhamDangChoDao.findAll();
		return result;
	}
	public PhieuKhamDangCho save(PhieuKhamDangCho phieuKhamDangCho) {
		return phieuKhamDangChoDao.save(phieuKhamDangCho);
	}
	public PhieuKhamDangCho findById(Integer id) {
		return phieuKhamDangChoDao.findOne(id);
	}
	public List<PhieuKhamDangCho> findByMaPhieuKham(Integer maPhieuKham){
		return phieuKhamDangChoDao.findByMaPhieuKham(maPhieuKham);
	}
}
