package com.flightapp.schedule.respository;

import java.util.Date;
import java.util.List;
import org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightapp.schedule.modal.FlightSchedule;

@Repository
public interface ScheduleRepository extends JpaRepository<FlightSchedule, Long> {

	public List<FlightSchedule> findAllByflightDateEqualsAndFlightSrcAirportNameAndFlightDestAirportName(
			Date flightDate, String srcAirportName, String destAirportName);

	@Query("from FlightSchedule where flight.srcAirport.name=:src and flight.destAirport.name =:dest and flight.airline.active=1 and flightDate = :flightDate")
	public List<FlightSchedule> getAllFlights(@Param("src") String src, @Param("dest") String dest,
			@Param("flightDate") Date flightDate);

	public List<FlightSchedule> findAllByflightAirlineActive(boolean active);
}
