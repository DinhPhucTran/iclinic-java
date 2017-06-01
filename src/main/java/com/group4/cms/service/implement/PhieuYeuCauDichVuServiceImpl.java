/* PhieuYeuCauDichVuServiceIplm - Add by Hang - 31/05/2017 */
package com.group4.cms.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.cms.dao.PhieuYeuCauDichVuDao;
import com.group4.cms.model.PhieuYeuCauDichVu;
import com.group4.cms.service.PhieuYeuCauDichVuService;

@Service
public class PhieuYeuCauDichVuServiceImpl implements PhieuYeuCauDichVuService{

	@Autowired
	private PhieuYeuCauDichVuDao phieuYeuCauDichVuDao;
	
	public List<PhieuYeuCauDichVu> findAll() {
		List<PhieuYeuCauDichVu> result = phieuYeuCauDichVuDao.findAll();
		return result;
	}
	public PhieuYeuCauDichVu save(PhieuYeuCauDichVu PhieuYeuCauDichVu) {
		return phieuYeuCauDichVuDao.save(PhieuYeuCauDichVu);
	}
	public PhieuYeuCauDichVu findById(Integer id) {
		return phieuYeuCauDichVuDao.findOne(id);
	}
	public List<PhieuYeuCauDichVu> findByMaPhieuKham(Integer maPhieuKham){
		return phieuYeuCauDichVuDao.findByMaPhieuKham(maPhieuKham);
	}
}
