/* PhieuKhamBenhDao - Add by Hang - 31/05/2017 */
package com.group4.cms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group4.cms.model.PhieuKhamBenh;

@Repository
public interface PhieuKhamBenhDao extends JpaRepository<PhieuKhamBenh, Integer>{
	@Query(value = "select * from phieu_kham_benh where tinh_trang_thanh_toan = 0", nativeQuery = true)
	public List<PhieuKhamBenh> findPKBChuaThanhToan();
	@Query(value = "update phieu_kham_benh set tinh_trang_thanh_toan = 1 where id = :maPhieuKhamBenh", nativeQuery = true)
	public void updateTinhTrangThanhToan(@Param("maPhieuKhamBenh") Integer maPhieuKhamBenh);
}
