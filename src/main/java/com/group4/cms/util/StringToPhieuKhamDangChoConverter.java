package com.group4.cms.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.group4.cms.model.PhieuKhamDangCho;
import com.group4.cms.service.PhieuKhamDangChoService;

@Component
public class StringToPhieuKhamDangChoConverter implements Converter<String, PhieuKhamDangCho>{
	
	@Autowired
	PhieuKhamDangChoService pkdcService;

//	@Override
	public PhieuKhamDangCho convert(String id) {
		try{
			return pkdcService.findById(Integer.parseInt(id));
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
