package com.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.FlightsDao;
import com.dao.BookingsDao;
import com.dao.PlacesDao;
import com.to.Flights;
import com.to.Places;
import com.to.Bookings;

@Controller
public class BookingController {

	@RequestMapping(value = "/flightsearch", method = RequestMethod.POST)
	public ModelAndView searchFlight(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		ModelAndView mv = new ModelAndView();
		FlightsDao fd = new FlightsDao();
		PlacesDao pd = new PlacesDao();
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		Places sourceLocation = pd.getplacebyName(source);
		Places destinationLocation = pd.getplacebyName(destination);
		List<Flights> flights = fd.searchFlights(date, sourceLocation, destinationLocation);

		mv.addObject("message", flights);
		mv.setViewName("flightsearch.jsp");
		return mv;
	}

	@RequestMapping(value = "/booktickets", method = RequestMethod.POST)
	public ModelAndView bookTickets(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		ModelAndView mv = new ModelAndView();
		FlightsDao fd = new FlightsDao();
		BookingsDao bd = new BookingsDao();
		Long flightid = Long.parseLong(request.getParameter("id"));
		Long count = Long.parseLong(request.getParameter("count"));
		String name = request.getParameter("name");
		Long age = Long.parseLong(request.getParameter("age"));
		String email = request.getParameter("email");
		Long phno = Long.parseLong(request.getParameter("phno"));
		Flights flight = fd.getflightbyID(flightid);
		Double totalPrice = count * flight.getTicketprice();
		Date currentDate = new Date();
		String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentDate);
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);

		Bookings b = new Bookings(name, age, email, phno, flight, count, totalPrice, date);
		String res = bd.addBooking(b);
		if (res == "Booking added successfully") {
			mv.addObject("totalPrice", totalPrice);
			mv.addObject("bookingID", b.getID());
			mv.setViewName("playment.jsp");
		} else {
			mv.addObject("message", "Error booking");
			mv.setViewName("response.jsp");
		}

		return mv;
	}

	@RequestMapping(value = "/bookingsuccess", method = RequestMethod.POST)
	public ModelAndView bookingSuccess(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		ModelAndView mv = new ModelAndView();
		BookingsDao bd = new BookingsDao();
		Long id = Long.parseLong(request.getParameter("id"));
		Bookings b = bd.getbookingbyID(id);
		String res = "Booking successful";

		mv.addObject("message", res);
		mv.addObject("id", b.getID());
		mv.addObject("email", b.getEmail());
		mv.addObject("flight", b.getFlight());
		mv.addObject("count", b.getTicketscount());
		mv.addObject("amount", b.getTotalamount());
		mv.setViewName("bookingsuccess.jsp");
		return mv;
	}
}
