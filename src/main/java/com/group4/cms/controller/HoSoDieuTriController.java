package com.group4.cms.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group4.cms.model.BenhNhan;
import com.group4.cms.model.GiayNhapVien;
import com.group4.cms.model.HoSoDieuTriNoiTru;
import com.group4.cms.model.User;
import com.group4.cms.service.BenhNhanService;
import com.group4.cms.service.GiayNhapVienService;
import com.group4.cms.service.HoSoDieuTriService;
import com.group4.cms.service.PhongService;
import com.group4.cms.service.UserService;

@Controller
public class HoSoDieuTriController {
	@Autowired
	private HoSoDieuTriService hoSoDieuTriService;
	
	@Autowired
	private GiayNhapVienService giayNhapVienService;
	
	@Autowired
	private BenhNhanService benhNhanService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PhongService phongService;
	
	@RequestMapping(value = "/ho-so-dieu-tri", method =  RequestMethod.POST)
	public String add(@ModelAttribute("hoSoDieutri") HoSoDieuTriNoiTru hoSoDieutri, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
			model.addAttribute("msgType", "error");
			return "patients";
		}
		GiayNhapVien giayNhapVien = new GiayNhapVien();
		BenhNhan benhNhan = benhNhanService.findById(hoSoDieutri.getBenhNhan().getMaBenhNhan());
		User nhanVienTiepNhan = userService.findById(hoSoDieutri.getGiayNhapVien().getNhanVienTiepNhan().getId());
		
		giayNhapVien.setBenhNhan(benhNhan);
		giayNhapVien.setNhanVienTiepNhan(nhanVienTiepNhan);
		giayNhapVien.setNgayNhapVien(new Date());
		giayNhapVienService.save(giayNhapVien);

		hoSoDieutri.setBenhNhan(benhNhan);
		hoSoDieutri.setGiayNhapVien(giayNhapVien);
		hoSoDieutri.setNgayBatDauDieuTri(new Date());
		hoSoDieutri.setBacSi(userService.findById(hoSoDieutri.getBacSi().getId()));
		hoSoDieutri.setyTa(userService.findById(hoSoDieutri.getyTa().getId()));
		hoSoDieutri.setPhong(phongService.findById(hoSoDieutri.getPhong().getMaPhong()));
		hoSoDieuTriService.save(hoSoDieutri);
		return "redirect:/benh-nhan";
	}
}
