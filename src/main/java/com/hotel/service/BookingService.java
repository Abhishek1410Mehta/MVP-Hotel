package com.hotel.service;

import java.util.List;

import com.hotel.dto.HotelBookingDTO;
import com.hotel.exception.HotelBookingException;

public interface BookingService {

		public Integer bookHotel(HotelBookingDTO booking) throws HotelBookingException;
		public List<HotelBookingDTO> getBookingDetails(Long mobileNo) throws HotelBookingException;
		public Integer cancelBooking(Integer bookingId) throws HotelBookingException;
	
}
