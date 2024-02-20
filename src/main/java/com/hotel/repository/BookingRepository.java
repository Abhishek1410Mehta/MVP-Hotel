package com.hotel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hotel.entity.HotelBooking;

public interface BookingRepository extends CrudRepository<HotelBooking, Integer>{
	
	List<HotelBooking> findByUserMobile(Long userMobile);

}
