package com.group4.cms.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group4.cms.model.BenhNhan;
import com.group4.cms.model.HoSoDieuTriNoiTru;
import com.group4.cms.model.Phong;
import com.group4.cms.model.User;
import com.group4.cms.service.BenhNhanService;
import com.group4.cms.service.PhongService;
import com.group4.cms.service.UserService;

@Controller
public class BenhNhanController {

	@Autowired
	private BenhNhanService benhNhanService;

	@Autowired
	private UserService userService;

	@Autowired
	private PhongService phongService;
	
	@ModelAttribute("benhNhan")
	public BenhNhan getBenhNhan() {
		return new BenhNhan();
	}
	
	@ModelAttribute("hoSoDieuTri")
	public HoSoDieuTriNoiTru getHoSoDieuTri() {
		return new HoSoDieuTriNoiTru();
	}

	@RequestMapping("/tiep-nhan")
	public String addPatient() {
		return "add-patient";
	}

	@RequestMapping(value = "/benh-nhan/luu", method = RequestMethod.POST)
	public String save(BenhNhan benhNhan, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
			redirectAttributes.addFlashAttribute("msgType", "error");
		} else {
			if (benhNhan.getNgaySinh().after(new Date())) {
				System.out.println("ngay sinh ko hop le");
				redirectAttributes.addFlashAttribute("message", "Ngày sinh không hợp lệ");
				redirectAttributes.addFlashAttribute("msgType", "error");
				return "redirect:/tiep-nhan";
			}
			redirectAttributes.addFlashAttribute("message", "Thêm bệnh nhân hợp lệ.");
			redirectAttributes.addFlashAttribute("msgType", "success");
			benhNhan.setNgayTiepNhan(new Date());
			benhNhanService.save(benhNhan);
		}
		return "redirect:/tiep-nhan";
	}

	@RequestMapping(value = "/benh-nhan", method = RequestMethod.GET)
	public String get(Model model) {
		List<BenhNhan> dsBenhNhan = benhNhanService.findAll();
		List<User> receptionists = userService.findByBoPhan(1);
		List<User> doctors = userService.findByBoPhan(2);
		List<User> nurses = userService.findByBoPhan(3);
		List<Phong> rooms = phongService.findByDichVu(1);
		if (dsBenhNhan.isEmpty() || receptionists.isEmpty() || doctors.isEmpty() || nurses.isEmpty()
				|| rooms.isEmpty()) {
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
			model.addAttribute("msgType", "error");
			return "patients";
		}
		model.addAttribute("dsBenhNhan", dsBenhNhan);
		model.addAttribute("receptionists", receptionists);
		model.addAttribute("doctors", doctors);
		model.addAttribute("nurses", nurses);
		model.addAttribute("rooms", rooms);
		return "patients";
	}
}
