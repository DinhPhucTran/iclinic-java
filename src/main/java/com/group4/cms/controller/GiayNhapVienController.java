package com.group4.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.group4.cms.service.GiayNhapVienService;

@Controller
public class GiayNhapVienController {
	
	@SuppressWarnings("unused")
	@Autowired
	private GiayNhapVienService giayNhapVienService;
}
