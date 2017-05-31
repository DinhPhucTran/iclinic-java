/* PhieuKhamBenhController - Add by Hang - 31/05/2017 */
package com.group4.cms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group4.cms.model.User;
import com.group4.cms.model.UserRole;
import com.group4.cms.model.BenhNhan;
import com.group4.cms.model.BoPhan;
import com.group4.cms.model.DichVu;
import com.group4.cms.model.DonThuoc;
import com.group4.cms.model.PhieuKhamBenh;
import com.group4.cms.model.PhieuYeuCauDichVu;
import com.group4.cms.model.Phong;
import com.group4.cms.service.BenhNhanService;
import com.group4.cms.service.BoPhanService;
import com.group4.cms.service.DichVuService;
import com.group4.cms.service.PhieuKhamBenhService;
import com.group4.cms.service.PhongService;
import com.group4.cms.service.UserService;

@Controller
public class PhieuKhamBenhController {
	@Autowired
	private PhieuKhamBenhService phieuKhamBenhService;
	
	@Autowired
	private UserService userService;
	@Autowired
	BenhNhanService benhNhanService;
	@Autowired
	DichVuService dvService;
	@Autowired 
	PhieuKhamBenhService pkbService;
	@Autowired 
	PhongService phongService;
	
	@ModelAttribute("phieuKhamBenh")
	public PhieuKhamBenh getPhieuKhamBenh(){
		return new PhieuKhamBenh();
	}
	@ModelAttribute("phieuYeuCauDichVu")
	public PhieuYeuCauDichVu getPhieuYeuCauDichVu(){
		return new PhieuYeuCauDichVu();
	}

	@ModelAttribute("donThuoc")
	public DonThuoc getDonThuoc(){
		return new DonThuoc();
	}
	
	@RequestMapping(value = "/phieu-kham-benh/get-phong-by-ma-dich-vu",method = RequestMethod.POST)
	@ResponseBody
	public List<Phong> getPhongByMaDichVu(@RequestParam("maDichVu") String maDichVu){
		int i = Integer.parseInt(maDichVu);
		List<Phong> result = phongService.findByDichVu(i);
		return result;
	}

	@RequestMapping(value = "/kham-benh",method = RequestMethod.GET)
	
	public String addPhieuKhamBenh(Model model){
		List<User> users = new ArrayList<User>();		
		users = userService.findAll();
		
		List<BenhNhan> benhNhan = new ArrayList<BenhNhan>();		
		benhNhan = benhNhanService.findAll();
		
		List<DichVu> dsDichVu = new ArrayList<DichVu>();
		dsDichVu = dvService.findAll();
		
		List<PhieuKhamBenh> dsPhieuKhamBenh = new ArrayList<PhieuKhamBenh>();
		dsPhieuKhamBenh = pkbService.findAll();
		
		model.addAttribute("dsDichVu", dsDichVu);
		model.addAttribute("dsUser", users);
		model.addAttribute("dsBenhNhan", benhNhan);
		model.addAttribute("dsPhieuKhamBenh", dsPhieuKhamBenh);
		return "kham-benh";
	}
	
	@RequestMapping(value = "/phieu-kham-benh/luu", method = RequestMethod.POST)
	public String save(@ModelAttribute("phieuKhamBenh") PhieuKhamBenh phieuKhamBenhModel, @Valid PhieuKhamBenh phieuKhamBenh,
						BindingResult phieuKhamBenhResult,
						RedirectAttributes redirectAttributes, Model model){
		if (phieuKhamBenhResult.hasErrors()) {
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
		} else {
			phieuKhamBenh.setNgayKham(new Date());
			phieuKhamBenhService.save(phieuKhamBenh);
		}
		return "redirect:/kham-benh";
	}
	
	@RequestMapping(value = "/don-thuoc/luu", method = RequestMethod.POST)
	public String saveDonThuoc(@ModelAttribute("donThuoc") DonThuoc donThuocModel, @Valid DonThuoc donThuoc,
						BindingResult donThuocResult,
						RedirectAttributes redirectAttributes, Model model){
		if (donThuocResult.hasErrors()) {
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
		} else {
			//donThuocService.save(donThuoc);
		}
		return "redirect:/kham-benh";
	}
	
	@RequestMapping(value = "/dich-vu-kham/luu", method = RequestMethod.POST)
	public String savePhieuYeuCauDichVu(@ModelAttribute("phieuYeuCauDichVu") PhieuYeuCauDichVu phieuYeuCauDichVuModel, 
						@Valid PhieuYeuCauDichVu phieuYeuCauDichVu,
						BindingResult phieuYeuCauDichVuResult,
						RedirectAttributes redirectAttributes, Model model){
		if (phieuYeuCauDichVuResult.hasErrors()) {
			model.addAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
		} else {
		}
		return "redirect:/kham-benh";
	}
}
