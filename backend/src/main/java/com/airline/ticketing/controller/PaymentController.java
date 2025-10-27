
package com.airline.ticketing.controller;
import com.airline.ticketing.model.Booking;
import com.airline.ticketing.model.Payment;
import com.airline.ticketing.repository.BookingRepository;
import com.airline.ticketing.repository.PaymentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController @RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentRepository paymentRepo; private final BookingRepository bookingRepo;
    public PaymentController(PaymentRepository paymentRepo, BookingRepository bookingRepo){this.paymentRepo=paymentRepo; this.bookingRepo=bookingRepo;}
    public static record PayRequest(Long bookingId, double amountPaid) {}
    @PostMapping public ResponseEntity<?> pay(@RequestBody PayRequest req){
        Optional<Booking> ob = bookingRepo.findById(req.bookingId());
        if (ob.isEmpty()) return ResponseEntity.badRequest().body("Booking not found");
        Booking b = ob.get();
        double totalCost = b.getSeatsBooked() * b.getFlight().getPrice();
        double paid = req.amountPaid();
        if (paid < totalCost) return ResponseEntity.badRequest().body("Insufficient payment");
        Payment p = new Payment(); p.setBooking(b); p.setTotalCost(totalCost); p.setAmountPaid(paid); p.setChangeGiven(paid - totalCost);
        Payment saved = paymentRepo.save(p);
        return ResponseEntity.ok(saved);
    }
}
