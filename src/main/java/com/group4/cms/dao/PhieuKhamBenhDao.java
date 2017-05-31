/* PhieuKhamBenhDao - Add by Hang - 31/05/2017 */
package com.group4.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.cms.model.PhieuKhamBenh;

@Repository
public interface PhieuKhamBenhDao extends JpaRepository<PhieuKhamBenh, Integer>{
}
