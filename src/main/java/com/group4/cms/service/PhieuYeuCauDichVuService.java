/* PhieuYeuCauDichVuService - Add by Hang - 31/05/2017 */
package com.group4.cms.service;

import java.util.List;

import com.group4.cms.model.PhieuYeuCauDichVu;

public interface PhieuYeuCauDichVuService {
	public List<PhieuYeuCauDichVu> findAll();
	public PhieuYeuCauDichVu save(PhieuYeuCauDichVu PhieuYeuCauDichVu);
	public PhieuYeuCauDichVu findById(Integer id);
	public List<PhieuYeuCauDichVu> findByMaPhieuKham(Integer maPhieuKham);
}
