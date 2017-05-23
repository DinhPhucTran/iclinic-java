package com.group4.cms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group4.cms.model.HoSoDieuTriNoiTru;

public interface HoSoDieutriDao extends JpaRepository<HoSoDieuTriNoiTru, Integer> {

	@Query(value = "select * from ho_so_dieu_tri_noi_tru where tinh_trang_xuat_vien = 0", nativeQuery = true)
	public List<HoSoDieuTriNoiTru> findByBeingTreated();
}
