package com.group4.cms.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.group4.cms.model.PhieuKhamBenh;
import com.group4.cms.service.PhieuKhamBenhService;

public class StringToPhieuKhamBenhConverter implements Converter<String, PhieuKhamBenh>{
	
	@Autowired
	PhieuKhamBenhService phieuKhamBenhService;

//	@Override
	public PhieuKhamBenh convert(String phieuKham) {
		try{
			return phieuKhamBenhService.findById(Integer.parseInt(phieuKham));
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}