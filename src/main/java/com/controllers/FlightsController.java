package com.controllers;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.PlacesDao;
import com.dao.FlightsDao;
import com.dao.AirlinesDao;
import com.to.Airlines;
import com.to.Flights;
import com.to.Places;

@Controller
public class FlightsController {

	@RequestMapping(value = "/addflight", method = RequestMethod.POST)
	public ModelAndView addFlight(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		ModelAndView mv = new ModelAndView();
		FlightsDao fd = new FlightsDao();
		AirlinesDao ad = new AirlinesDao();
		PlacesDao pd = new PlacesDao();
		Long airlineid = Long.parseLong(request.getParameter("airlineid"));
		Long sourceid = Long.parseLong(request.getParameter("sourceid"));
		Long destinationid = Long.parseLong(request.getParameter("destinationid"));
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
		Date departure = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("departure"));
		Date arival = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("arival"));
		Double ticketprice = Double.parseDouble(request.getParameter("ticketprice"));
		Airlines airline = ad.getairlinebyID(airlineid);
		Places source = pd.getplacebyID(sourceid);
		Places destination = pd.getplacebyID(destinationid);

		Flights f = new Flights(airline, source, destination, date, departure, arival, ticketprice);
		String res = fd.addFlight(f);

		mv.addObject("message", res);
		mv.setViewName("response.jsp");
		return mv;
	}

	@RequestMapping(value = "/viewflights", method = RequestMethod.GET)
	public ModelAndView viewFlights(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		FlightsDao fd = new FlightsDao();
		List<Flights> flights = fd.getFlights();

		mv.addObject("message", flights);
		mv.setViewName("flightresponse.jsp");
		return mv;
	}

	@RequestMapping(value = "/deleteflight", method = RequestMethod.POST)
	public ModelAndView deleteFlight(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		FlightsDao fd = new FlightsDao();
		Long id = Long.parseLong(request.getParameter("id"));
		System.out.println("ID of flight" + id);
		String res = fd.deleteFlight(id);

		mv.addObject("message", res);
		mv.setViewName("response.jsp");
		return mv;
	}
}
