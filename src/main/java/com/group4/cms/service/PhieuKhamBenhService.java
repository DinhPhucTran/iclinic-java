/* PhieuKhamBenhService - Add by Hang - 31/05/2017 */
package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.PhieuKhamBenh;

public interface PhieuKhamBenhService {
	public List<PhieuKhamBenh> findAll();
	public PhieuKhamBenh save(PhieuKhamBenh phieuKhamBenh);
	public PhieuKhamBenh findById(Integer id);
	public List<PhieuKhamBenh> findPKBChuaThanhToan();
	public List<PhieuKhamBenh> getPhieuKhamByThangNam(int month, int year);
}
