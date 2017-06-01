/* PhieuKhamDangChoService - Add by Hang - 31/05/2017 */
package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.PhieuKhamDangCho;

public interface PhieuKhamDangChoService {
	public List<PhieuKhamDangCho> findAll();
	public PhieuKhamDangCho save(PhieuKhamDangCho phieuKhamDangCho);
	public PhieuKhamDangCho findById(Integer id);
	public List<PhieuKhamDangCho> findByMaPhieuKham(Integer maPhieuKham);
}
