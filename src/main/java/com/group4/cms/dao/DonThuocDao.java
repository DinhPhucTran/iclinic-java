package com.group4.cms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group4.cms.model.DonThuoc;

@Repository
public interface DonThuocDao extends JpaRepository<DonThuoc, Integer>{

	@Query(value = "select * from don_thuoc where ma_phieu_kham_dang_cho = :maPhieuKham", nativeQuery = true)
	public List<DonThuoc> findByMaPhieuKham(@Param("maPhieuKham") Integer maPhieuKham);
}
