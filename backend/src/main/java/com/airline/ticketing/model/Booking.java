
package com.airline.ticketing.model;
import jakarta.persistence.*;
@Entity
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne private Flight flight;
    private String passengerName;
    private String passengerEmail;
    private int seatsBooked;
    public Booking() {}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Flight getFlight(){return flight;} public void setFlight(Flight f){this.flight=f;}
    public String getPassengerName(){return passengerName;} public void setPassengerName(String s){this.passengerName=s;}
    public String getPassengerEmail(){return passengerEmail;} public void setPassengerEmail(String s){this.passengerEmail=s;}
    public int getSeatsBooked(){return seatsBooked;} public void setSeatsBooked(int s){this.seatsBooked=s;}
}
