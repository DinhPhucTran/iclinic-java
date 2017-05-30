package com.group4.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group4.cms.service.BenhNhanService;
import com.group4.cms.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	BenhNhanService benhNhanservice;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String home(Model model){
		int countBN = benhNhanservice.countBenhNhan();
		int benhNhanMoi = benhNhanservice.countBenhNhanMoi();
		int countUser = userService.countUser();
		int countBS = userService.countBacSi();
		int countYT = userService.countYta();
		int countOthers = countUser - countBS - countYT;
		
		model.addAttribute("countBN", countBN);
		model.addAttribute("BNmoi", benhNhanMoi);
		model.addAttribute("countUser", countUser);
		model.addAttribute("countBS", countBS);
		model.addAttribute("countYT", countYT);
		model.addAttribute("countOthers", countOthers);
		
		return "index";
	}
}
