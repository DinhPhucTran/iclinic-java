package com.group4.cms.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.group4.cms.model.DichVu;
import com.group4.cms.service.DichVuService;

public class StringToDichVuConverter implements Converter<String, DichVu>{
	
	@Autowired
	DichVuService dichVuService;

//	@Override
	public DichVu convert(String maDichVu) {
		try{
			return dichVuService.findById(Integer.parseInt(maDichVu));
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}