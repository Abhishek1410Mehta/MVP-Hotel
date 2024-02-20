package com.hotel.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Booking")
public class HotelBooking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
		return "HotelBooking [bookingId=" + bookingId + ", source=" + source + ", destination=" + destination + ", fare="
				+ fare + ", bookingDate=" + bookingDate + ", userMobile=" + userMobile + ", "
				+ "hotelName=" + hotelName + "status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getBookingId() == null) ? 0 : this.getBookingId().hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelBooking other = (HotelBooking) obj;
		if (this.getBookingId() == null) {
			if (other.getBookingId() != null)
				return false;
		} 
		else if (!this.getBookingId().equals(other.getBookingId()))
			return false;
		return true;
	}

	
}
