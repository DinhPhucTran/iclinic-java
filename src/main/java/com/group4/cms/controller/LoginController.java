package com.group4.cms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
						@RequestParam(value = "logout", required = false) String logout,
						HttpServletRequest request, Model model){
		
		if (error != null) {
			model.addAttribute("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}

		return "login";
	}
	
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof InternalAuthenticationServiceException || exception instanceof BadCredentialsException) {
			error = "Invalid username or password.";
		} else if (exception.getMessage() == null) {
			error = "An error occured, please try again later.";
		} else{
			error = exception.getMessage();
		}

		return exception.getMessage();
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		return "redirect:/login?logout";
	}
	
	@RequestMapping("/403")
	public String accessDeniedPage(){		
		return "403";
	}
}
