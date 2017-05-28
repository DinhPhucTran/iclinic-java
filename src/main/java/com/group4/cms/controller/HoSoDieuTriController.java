package com.group4.cms.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group4.cms.model.BenhNhan;
import com.group4.cms.model.ChiTietDieuTri;
import com.group4.cms.model.GiayNhapVien;
import com.group4.cms.model.GiayRaVien;
import com.group4.cms.model.HoSoDieuTriNoiTru;
import com.group4.cms.model.User;
import com.group4.cms.service.BenhNhanService;
import com.group4.cms.service.ChiTietDieuTriService;
import com.group4.cms.service.GiayNhapVienService;
import com.group4.cms.service.GiayRaVienService;
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
	
	@Autowired
	private ChiTietDieuTriService chiTietDieuTriService;
	
	@Autowired
	private GiayRaVienService giayRaVienService;
	
	@ModelAttribute("chiTietDieuTri")
	public ChiTietDieuTri getChiTietDieuTri() {
		return new ChiTietDieuTri();
	}
	
	@ModelAttribute("hoSoDieuTri")
	public HoSoDieuTriNoiTru getHoSoDieuTriNoiTru() {
		return new HoSoDieuTriNoiTru();
	}
	
	@RequestMapping(value = "/ho-so-dieu-tri", method =  RequestMethod.POST)
	public String add(@ModelAttribute("hoSoDieuTri") HoSoDieuTriNoiTru hoSoDieutri, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
			redirectAttributes.addFlashAttribute("msgType", "error");
			return "redirect:/benh-nhan";
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
		redirectAttributes.addFlashAttribute("message", "Bệnh nhân nhập viện thành công.");
		redirectAttributes.addFlashAttribute("msgType", "success");
		return "redirect:/benh-nhan";
	}
	
	@RequestMapping(value = "/benh-nhan-dieu-tri", method = RequestMethod.GET)
	public String dsDieuTri(Model model) {
		model.addAttribute("dsHoSoDieuTri", hoSoDieuTriService.findByBeingTreated());
		return "ds-dieu-tri";
	}
	
	@RequestMapping(value = "/cap-nhat-tinh-trang", method = RequestMethod.POST)
	public String update(@ModelAttribute("chiTietDieuTri") ChiTietDieuTri chiTietDieuTri, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("message", "Đã gặp sự cố khi cập nhật tình trang bệnh nhân.");
			redirectAttributes.addFlashAttribute("msgType", "error");
			return "redirect:/benh-nhan-dieu-tri";
		}
		HoSoDieuTriNoiTru hoSoDieuTriNoiTru = hoSoDieuTriService.findById(chiTietDieuTri.getHoSoDieuTriNoiTru().getMaHoSo());
		hoSoDieuTriNoiTru.setTinhTrangGanDay(chiTietDieuTri.getTinhTrang());
		hoSoDieuTriNoiTru.setSoLanDieuTri(hoSoDieuTriNoiTru.getSoLanDieuTri() + 1);
		hoSoDieuTriService.save(hoSoDieuTriNoiTru);
		
		chiTietDieuTri.setHoSoDieuTriNoiTru(hoSoDieuTriNoiTru);
		chiTietDieuTri.setThoiGianDieuTri(new Date());
		chiTietDieuTri.setTinhTrang(chiTietDieuTri.getTinhTrang());
		chiTietDieuTriService.save(chiTietDieuTri);
		redirectAttributes.addFlashAttribute("message", "Cập nhật tình trang bệnh nhân thành công.");
		redirectAttributes.addFlashAttribute("msgType", "success");
		return "redirect:/benh-nhan-dieu-tri";
	}
	
	@RequestMapping(value = "/xuat-vien", method =  RequestMethod.POST)
	public String xuatVien(@ModelAttribute("hoSoDieuTri") HoSoDieuTriNoiTru hoSoDieuTriNoiTru, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("message", "Đã gặp sự cố khi tạo phiếu xuất viện.");
			redirectAttributes.addFlashAttribute("msgType", "error");
			return "redirect:/benh-nhan-dieu-tri";
		}
		hoSoDieuTriNoiTru = hoSoDieuTriService.findById(hoSoDieuTriNoiTru.getMaHoSo());
		BenhNhan benhNhan = hoSoDieuTriNoiTru.getBenhNhan();
		GiayNhapVien giayNhapVien = hoSoDieuTriNoiTru.getGiayNhapVien();
		GiayRaVien giayRaVien = new GiayRaVien();
		giayRaVien.setBenhNhan(benhNhan);
		giayRaVien.setGiayNhapVien(giayNhapVien);
		giayRaVien.setBacSiDeNghi(hoSoDieuTriNoiTru.getBacSi());
		giayRaVienService.save(giayRaVien);
		hoSoDieuTriNoiTru.setTinhTrangXuatVien(true);
		hoSoDieuTriNoiTru.setNgayKetThucDieuTri(new Date());
		hoSoDieuTriService.save(hoSoDieuTriNoiTru);
		redirectAttributes.addFlashAttribute("message", "Tạo giấy xuất viện thành công.");
		redirectAttributes.addFlashAttribute("msgType", "success");
		return "redirect:/benh-nhan-dieu-tri";
	}
}
