package com.flightapp.schedule.respository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.schedule.modal.FlightSchedule;

@Repository
public interface ScheduleRepository extends JpaRepository<FlightSchedule, Long>{
	
	List<FlightSchedule> findAllByflightDateGreaterThanEqualAndDepartureTimeGreaterThan(Date flightDate, Date departureTime);
	
	
}
