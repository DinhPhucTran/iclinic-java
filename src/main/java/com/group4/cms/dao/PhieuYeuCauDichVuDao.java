/* PhieuYeuCauDichVuDao - Add by Hang - 31/05/2017 */
package com.group4.cms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group4.cms.model.PhieuYeuCauDichVu;

@Repository
public interface PhieuYeuCauDichVuDao extends JpaRepository<PhieuYeuCauDichVu, Integer>{
	@Query(value = "select * from phieu_yeu_cau_dich_vu where phieu_kham_id = :maPhieuKham", nativeQuery = true)
	public List<PhieuYeuCauDichVu> findByMaPhieuKham(@Param("maPhieuKham") Integer maPhieuKham);
}
