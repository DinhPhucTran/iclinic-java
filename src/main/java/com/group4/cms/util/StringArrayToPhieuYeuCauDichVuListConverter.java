package com.group4.cms.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.group4.cms.model.PhieuYeuCauDichVu;
import com.group4.cms.service.PhieuYeuCauDichVuService;

@Component
public class StringArrayToPhieuYeuCauDichVuListConverter implements Converter<String[], List<PhieuYeuCauDichVu>>{

	@Autowired
	PhieuYeuCauDichVuService phieuYeuCauDichVuService;
	
//	@Override
	public List<PhieuYeuCauDichVu> convert(String[] ids) {
		List<PhieuYeuCauDichVu> result = new ArrayList<PhieuYeuCauDichVu>();
		
		for(String maPhieuYeuCauDichVu : ids){
			try{
				result.add(phieuYeuCauDichVuService.findById(Integer.parseInt(maPhieuYeuCauDichVu)));
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

}
