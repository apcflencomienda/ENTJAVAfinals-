
package com.airline.ticketing.controller;
import com.airline.ticketing.model.Booking;
import com.airline.ticketing.model.Flight;
import com.airline.ticketing.repository.BookingRepository;
import com.airline.ticketing.repository.FlightRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController @RequestMapping("/api/bookings")
public class BookingController {
    private final BookingRepository bookingRepo; private final FlightRepository flightRepo;
    public BookingController(BookingRepository bookingRepo, FlightRepository flightRepo){this.bookingRepo=bookingRepo; this.flightRepo=flightRepo;}
    public static record CreateBookingRequest(Long flightId, Passenger passenger, int seats){ public static record Passenger(String name, String email){} }
    @PostMapping public ResponseEntity<?> book(@RequestBody CreateBookingRequest req){
        Optional<Flight> of = flightRepo.findById(req.flightId());
        if (of.isEmpty()) return ResponseEntity.badRequest().body("Flight not found");
        Flight f = of.get();
        if (req.seats() <= 0) return ResponseEntity.badRequest().body("Invalid seats");
        if (req.seats() > f.getCapacity()) return ResponseEntity.badRequest().body("Not enough seats");
        Booking b = new Booking(); b.setFlight(f); b.setPassengerName(req.passenger().name()); b.setPassengerEmail(req.passenger().email()); b.setSeatsBooked(req.seats());
        Booking saved = bookingRepo.save(b);
        f.setCapacity(f.getCapacity() - req.seats()); flightRepo.save(f);
        return ResponseEntity.ok(saved);
    }
}
