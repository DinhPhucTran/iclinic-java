package com.group4.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group4.cms.model.BenhNhan;

@Repository
public interface BenhNhanDao extends JpaRepository<BenhNhan, Integer>{
	
	@Query(value = "select count(*) from benh_nhan", nativeQuery = true)
	public Integer countBenhNhan();
	
	@Query(value = "select * from benh_nhan where date(ngay_tiep_nhan) = curdate()", nativeQuery = true)
	public Integer countBenhNhanMoi();
}
