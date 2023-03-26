package com.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.PlacesDao;
import com.to.Places;

@Controller
public class PlacesController {
	@RequestMapping(value = "/addplace", method = RequestMethod.POST)
	public ModelAndView addPlace(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		PlacesDao pd = new PlacesDao();
		String placeName = request.getParameter("placeName");

		Places p = new Places(placeName);
		String res = pd.addPlace(p);
		mv.addObject("message", res);
		mv.setViewName("response.jsp");
		return mv;
	}

	@RequestMapping(value = "/viewplaces", method = RequestMethod.GET)
	public ModelAndView viewPlaces(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		PlacesDao pd = new PlacesDao();
		List<Places> places = pd.getPlaces();

		mv.addObject("message", places);
		mv.setViewName("placeresponse.jsp");
		return mv;
	}

	@RequestMapping(value = "/deleteplace", method = RequestMethod.POST)
	public ModelAndView deletePLace(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		PlacesDao pd = new PlacesDao();
		Long id = Long.parseLong(request.getParameter("id"));
		String res = pd.deletePlace(id);

		mv.addObject("message", res);
		mv.setViewName("response.jsp");
		return mv;
	}
}
