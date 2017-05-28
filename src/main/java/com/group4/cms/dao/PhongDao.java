package com.group4.cms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group4.cms.model.Phong;

public interface PhongDao extends JpaRepository<Phong, Integer>{
	
	@Query(value = "select * from phong where dich_vu_id = :dichVuId", nativeQuery = true)
	public List<Phong> findByDichVu(@Param("dichVuId") Integer dichVuId);
}
