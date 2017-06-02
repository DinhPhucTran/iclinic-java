package com.group4.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.cms.model.HoaDon;

@Repository
public interface HoaDonDao extends JpaRepository<HoaDon, Integer>{
}
