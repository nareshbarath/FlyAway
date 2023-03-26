package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.AirlinesDao;
import com.to.Airlines;

@Controller
public class AirlineController {

	@RequestMapping(value = "/addairline", method = RequestMethod.POST)
	public ModelAndView addAirline(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		AirlinesDao ad = new AirlinesDao();
		String airlineName = request.getParameter("airlineName");

		Airlines a = new Airlines(airlineName);
		String res = ad.addAirline(a);
		mv.addObject("message", res);
		mv.setViewName("response.jsp");
		return mv;
	}

	@RequestMapping(value = "/viewairlines", method = RequestMethod.GET)
	public ModelAndView viewAirlines(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		AirlinesDao ad = new AirlinesDao();
		List<Airlines> airlines = ad.getAirlines();

		mv.addObject("message", airlines);
		mv.setViewName("airlineresponse.jsp");
		return mv;
	}

	@RequestMapping(value = "/deleteairline", method = RequestMethod.POST)
	public ModelAndView deleteAirline(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		AirlinesDao ad = new AirlinesDao();
		Long id = Long.parseLong(request.getParameter("id"));
		String res = ad.deleteAirline(id);

		mv.addObject("message", res);
		mv.setViewName("response.jsp");
		return mv;
	}
}
