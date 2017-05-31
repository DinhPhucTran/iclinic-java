package com.group4.cms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group4.cms.model.BoPhan;
import com.group4.cms.model.FileWrapper;
import com.group4.cms.model.User;
import com.group4.cms.model.UserRole;
import com.group4.cms.service.BoPhanService;
import com.group4.cms.service.FileService;
import com.group4.cms.service.UserRoleService;
import com.group4.cms.service.UserService;
import com.group4.cms.util.Util;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserRoleService roleService;

	@Autowired
	FileService fileService;

	@Autowired
	BoPhanService boPhanService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}

	@RequestMapping(value = "/user-list", method = RequestMethod.GET)
	public String userList(Model model) {
		List<User> users = new ArrayList<User>();
		users = userService.findAll();

		List<UserRole> roles = new ArrayList<UserRole>();
		roles = roleService.findAll();

		List<BoPhan> dsBoPhan = new ArrayList<BoPhan>();
		dsBoPhan = boPhanService.findAll();

		model.addAttribute("userList", users);
		model.addAttribute("roleList", roles);
		model.addAttribute("dsBoPhan", dsBoPhan);

		return "user-list";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") @Valid User user,
			@RequestParam(value = "image1", required = false) CommonsMultipartFile image, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "redirect:/user-list";
		}
		
		/*String pass = user.getPassword();
		String hashed = encodePassword(pass);
		if (!"".equals(hashed)) {
			user.setPassword(hashed);
		}*/
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		user.setEnabled(true);

		FileWrapper file = new FileWrapper();
		if (Util.isValidImageFile(image.getContentType())) {
			String name = "profile-img-" + user.getUserName() + "."
					+ Util.getFileExtension(image.getOriginalFilename());
			file.setName(name);
			file.setContent(image);
			System.out.println(image.getBytes().length);
			fileService.save(file);

			user.setProfileImage(file);
			FileWrapper wrapper = fileService.findById(file.getId());
			System.out.println(wrapper.getName() + "/" + wrapper.getContent().getContentType() + "/"
					+ wrapper.getContent().getSize());
		}

		if (userService.save(user) != null) {
			redirectAttributes.addFlashAttribute("message", "Thêm người dùng thành công");
			redirectAttributes.addFlashAttribute("msgType", "success");
		} else {
			redirectAttributes.addFlashAttribute("message", "Đã có lỗi xảy ra, vui lòng thử lại sau.");
			redirectAttributes.addFlashAttribute("msgType", "error");
		}

		return "redirect:/user-list";
	}

	@RequestMapping(value = "/edit-user", method = RequestMethod.POST)
	public String editUser(@ModelAttribute("user") @Valid User user,
			@RequestParam(value = "image1", required = false) CommonsMultipartFile image, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "redirect:/user-list";
		}

		User oldUser = userService.findById(user.getId());
		if (oldUser != null)
			System.out.println(oldUser.getId() + "/" + oldUser.getUserName());
		else
			System.out.println("NULLLLLLLLll");

		/*if (user.getPassword() != null) {
			String pass = user.getPassword();
			String hashed = encodePassword(pass);
			if (!"".equals(hashed)) {
				user.setPassword(hashed);
			}
		} else {
			user.setPassword(oldUser.getPassword());
		}*/
		if(user.getPassword() == null) {
			user.setPassword(oldUser.getPassword());
		}

		user.setEnabled(true);

		if (image != null) {
			FileWrapper file = new FileWrapper();
			if (Util.isValidImageFile(image.getContentType())) {
				String name = "profile-img-" + user.getUserName() + "."
						+ Util.getFileExtension(image.getOriginalFilename());
				file.setName(name);
				file.setContent(image);
				fileService.save(file);

				user.setProfileImage(file);
			}

		} else if (oldUser.getProfileImage() != null) {
			user.setProfileImage(oldUser.getProfileImage());
		}

		if (userService.save(user) != null) {
			redirectAttributes.addFlashAttribute("message", "Cập nhật thông tin người dùng thành công");
			redirectAttributes.addFlashAttribute("msgType", "success");
		} else {
			redirectAttributes.addFlashAttribute("message", "Đã có lỗi xảy ra, vui lòng thử lại sau.");
			redirectAttributes.addFlashAttribute("msgType", "error");
		}

		return "redirect:/user-list";
	}

	/*private String encodePassword(String password) {
		String hashedPassword = "";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
	}*/

	@RequestMapping(value = "/getProfileImage", method = RequestMethod.GET)
	public void getImage(@RequestParam("id") int id, HttpServletResponse response) {
		// ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		int imgId = userService.getImageId(id);
		FileWrapper file = fileService.findById(imgId);
		System.out
				.println(file.getName() + "/" + file.getContent().getContentType() + "/" + file.getContent().getSize());
		// byte[] imgByte = fileService.getFileContent(2);
		byte[] imgByte = file.getContent().getBytes();
		response.setContentType("image/jpeg, image/jpg, image/png");
		// response.setHeader("Content-Length", String.valueOf(imgByte.length));
		response.setHeader("Content-Disposition", "attachment; filename=\"cv-" + id + ".jpg");
		//
		try {
			// ServletOutputStream servletOutputStream =
			// response.getOutputStream();
			response.getOutputStream().write(imgByte);
			response.getOutputStream().close();
		} catch (IOException ex) {
			Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@RequestMapping(value = "/getProfileImageByUserName", method = RequestMethod.GET)
	public void getImageByUserName(@RequestParam("username") String userName, HttpServletResponse response) {
		try {
			int imgId = userService.getProfileImageIdByUserName(userName);
			FileWrapper file = fileService.findById(imgId);
			byte[] imgByte = file.getContent().getBytes();
			response.setContentType("image/jpeg, image/jpg, image/png");
			response.setHeader("Content-Disposition", "attachment; filename=\"cv-" + userName + ".jpg");

			response.getOutputStream().write(imgByte);
			response.getOutputStream().close();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/delete-user", method = RequestMethod.POST)
	public String deleteUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model,
			RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			redirectAttributes.addFlashAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
			redirectAttributes.addFlashAttribute("msgType", "error");
		} else {
			try{
				userService.delete(user.getId());
				redirectAttributes.addFlashAttribute("message", "Đã xóa người dùng " + user.getUserName());
				redirectAttributes.addFlashAttribute("msgType", "success");
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("message", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");		
				redirectAttributes.addFlashAttribute("msgType", "error");
			}			
		}
		
		return "redirect:/user-list";
	}
}
