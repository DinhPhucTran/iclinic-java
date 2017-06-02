package com.group4.cms.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.group4.cms.model.ChiTietDonThuoc;
import com.group4.cms.service.ChiTietDonThuocService;

@Component
public class StringArrayToChiTietDonThuocListConverter implements Converter<String[], List<ChiTietDonThuoc>>{

	@Autowired
	ChiTietDonThuocService ChiTietDonThuocService;
	
//	@Override
	public List<ChiTietDonThuoc> convert(String[] ids) {
		List<ChiTietDonThuoc> result = new ArrayList<ChiTietDonThuoc>();
		
		for(String maChiTiet : ids){
			try{
				result.add(ChiTietDonThuocService.findById(Integer.parseInt(maChiTiet)));
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

}
