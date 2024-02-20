package com.hotel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dto.HotelBookingDTO;
import com.hotel.entity.HotelBooking;
import com.hotel.exception.HotelBookingException;
import com.hotel.repository.BookingRepository;

@Service("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Override
	public Integer bookHotel(HotelBookingDTO bookingDTO) throws HotelBookingException {
		HotelBooking hotelBooking = new HotelBooking();
		hotelBooking.setDestination(bookingDTO.getDestination());
		hotelBooking.setSource(bookingDTO.getSource());
		hotelBooking.setFare(bookingDTO.getFare());
		hotelBooking.setBookingDate(bookingDTO.getBookingDate());
		hotelBooking.setUserMobile(bookingDTO.getUserMobile());
		hotelBooking.setStatus(bookingDTO.getStatus());
		hotelBooking.setHotelName(bookingDTO.getHotelName());
		return bookingRepository.save(hotelBooking).getBookingId();
	}

	@Override
	public List<HotelBookingDTO> getBookingDetails(Long mobileNo) throws HotelBookingException {
		List<HotelBookingDTO> hotelBookingDTOs = new ArrayList<>();
		List<HotelBooking> hotelBookings = bookingRepository.findByUserMobile(mobileNo);
		if (hotelBookings.isEmpty())
			throw new HotelBookingException("BookingService.BOOKINGS_NOT_FOUND");
		hotelBookings.forEach( hotelBooking -> {
			HotelBookingDTO hotelBookingDTO = new HotelBookingDTO();
			hotelBookingDTO.setBookingId(hotelBooking.getBookingId());
			hotelBookingDTO.setDestination(hotelBooking.getDestination());
			hotelBookingDTO.setSource(hotelBooking.getSource());
			hotelBookingDTO.setFare(hotelBooking.getFare());
			hotelBookingDTO.setStatus(hotelBooking.getStatus());
			hotelBookingDTO.setBookingDate(hotelBooking.getBookingDate());
			hotelBookingDTO.setUserMobile(hotelBooking.getUserMobile());
			hotelBookingDTO.setHotelName(hotelBooking.getHotelName());
			hotelBookingDTOs.add(hotelBookingDTO);
		});
		
		return hotelBookingDTOs;
	}

	@Override
	public Integer cancelBooking(Integer bookingId) throws HotelBookingException {
		Optional<HotelBooking> optional = bookingRepository.findById(bookingId);
		optional.orElseThrow(() -> new HotelBookingException("BookingService.BOOKINGS_NOT_FOUND"));
		optional.get().setStatus('C');
		return optional.get().getBookingId();
	}

}
