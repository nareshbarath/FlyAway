package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.AdminDao;
import com.to.Admin;

@Controller
public class AdminController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		AdminDao ad = new AdminDao();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Admin a = ad.getadminbyEmail(email);
		if (a == null) {
			mv.addObject("message", "Wrong email");
			mv.setViewName("response.jsp");
			return mv;
		}
		String hashedPassword = a.getPassword();
		boolean passwordIsValid = bCryptPasswordEncoder.matches(password, hashedPassword);
		if (passwordIsValid == true) {
			mv.setViewName("index.jsp");
		} else {
			mv.addObject("message", "Wrong password");
			mv.setViewName("response.jsp");
		}
		return mv;
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public ModelAndView changepassword(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		AdminDao ad = new AdminDao();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String hashedPassword = bCryptPasswordEncoder.encode(password);
		String res = ad.changePassword(email, hashedPassword);
		mv.addObject("message", res);
		mv.setViewName("response.jsp");
		return mv;
	}
}
