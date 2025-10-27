
package com.airline.ticketing.controller;
import com.airline.ticketing.model.Flight;
import com.airline.ticketing.repository.FlightRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/flights")
public class FlightController {
    private final FlightRepository flightRepo;
    public FlightController(FlightRepository flightRepo){this.flightRepo=flightRepo;}
    @GetMapping public List<Flight> all(){return flightRepo.findAll();}
    @PostMapping public Flight create(@RequestBody Flight f){return flightRepo.save(f);}
}
