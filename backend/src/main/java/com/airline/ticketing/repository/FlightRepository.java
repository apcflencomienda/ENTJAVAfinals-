
package com.airline.ticketing.repository;
import com.airline.ticketing.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FlightRepository extends JpaRepository<Flight, Long> {}
