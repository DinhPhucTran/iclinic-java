package com.group4.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group4.cms.service.PhieuKhamBenhService;

@Controller
public class BcController {
	
	@Autowired
	PhieuKhamBenhService phieuKhamService;

	@RequestMapping(value = "/soLuotKham", method = RequestMethod.GET)
	@ResponseBody
	public String getSoLuotKham() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 1; i <= 12; i++){
			phieuKhamService.getPhieuKhamByThangNam(i, 2017);
			
		}
		return "";
	}

}
