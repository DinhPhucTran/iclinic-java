package com.group4.cms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group4.cms.service.GiayNhapVienService;

@Controller
public class GiayNhapVienController {
	
	@Autowired
	private GiayNhapVienService giayNhapVienService;
	
	@RequestMapping(value = "/giay-nhap-vien", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("dsGiayNhapVien", giayNhapVienService.findAll());
		return "ds-giay-nhap-vien";
	}
}
