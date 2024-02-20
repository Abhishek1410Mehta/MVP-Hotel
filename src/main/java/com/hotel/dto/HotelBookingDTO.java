package com.hotel.dto;

import java.time.LocalDate;

public class HotelBookingDTO {
	
	private Integer	bookingId;
	private String source;
	private String destination;
	private Float fare;
	private LocalDate bookingDate;
	private Long userMobile;
	private Character status;
	private String hotelName;
	
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate travelDate) {
		this.bookingDate = travelDate;
	}
	public Long getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(Long userMobile) {
		this.userMobile = userMobile;
	}
	public Float getFare() {
		return fare;
	}
	public void setFare(Float fare) {
		this.fare = fare;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	@Override
	public String toString() {
		return "HotelBookingDTO [bookingId=" + bookingId + ", source=" + source + ", destination=" + destination
				+ ", fare=" + fare + ", bookingDate=" + bookingDate + ", userMobile=" + userMobile + ""
				+ ", hotelName=" + hotelName + ", status=" + status
				+ "]";
	}

}
