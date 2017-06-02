package com.group4.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group4.cms.model.DichVu;

@Repository
public interface DichVuDao extends JpaRepository<DichVu, Integer>{
	
	@Query(value = "select count(*) from dich_vu", nativeQuery = true)
	public Integer countDichVu();
	
}
