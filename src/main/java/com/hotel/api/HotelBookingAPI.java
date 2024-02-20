package com.hotel.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dto.HotelBookingDTO;
import com.hotel.exception.HotelBookingException;
import com.hotel.service.BookingService;

@RestController
@RequestMapping(value = "/bookings")
public class HotelBookingAPI {
	@Autowired
	private BookingService bookingService;

	@Autowired
	private Environment environment;

//This is a REST controller method to book a hotel. It accepts booking details as part of HTTP request body.
	@PostMapping(value = "/")
	public ResponseEntity<String> bookHotel(@RequestBody HotelBookingDTO hotelBookingDTO) throws HotelBookingException {
		Integer bookingId = bookingService.bookHotel(hotelBookingDTO);
		String successMessage = environment.getProperty("API.BOOKING_SUCCESSFUL") + bookingId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

//This is a REST controller method to get hotel booking details based on mobile number of user. 
	@GetMapping(value="/{mobileNo}")
	public ResponseEntity<List<HotelBookingDTO>> getBookingDetails(@PathVariable Long mobileNo) throws HotelBookingException {
		List <HotelBookingDTO> bookingList =  bookingService.getBookingDetails(mobileNo);
		return new ResponseEntity<>(bookingList, HttpStatus.OK);
	}

//This is a REST controller method to cancel hotel booking based on bookingId. 
	@PutMapping(value="/{bookingId}")
	public ResponseEntity<String> cancelBooking(@PathVariable Integer bookingId) throws HotelBookingException {
		Integer bookId = bookingService.cancelBooking(bookingId);
		String successMessage = environment.getProperty("API.BOOKING_CANCELLED") + bookId;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

}
