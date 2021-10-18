package com.flightapp.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.booking.modal.Booking;

@Repository
public interface BookingRepository  extends JpaRepository<Booking, Long>{

}
