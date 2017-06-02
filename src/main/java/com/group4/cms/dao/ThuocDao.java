package com.group4.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.cms.model.Thuoc;

@Repository
public interface ThuocDao extends JpaRepository<Thuoc, Integer>{

}
