
package com.airline.ticketing.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
@Entity
@Table(name = "flight")
public class Flight {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "flight_number") private String flightNumber;
    private String origin;
    private String destination;
    @Column(name = "departure_time") private LocalDateTime departureTime;
    @Column(name = "arrival_time") private LocalDateTime arrivalTime;
    private int capacity;
    private double price;
    public Flight() {}
    // getters & setters omitted for brevity in template
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getFlightNumber(){return flightNumber;} public void setFlightNumber(String s){this.flightNumber=s;}
    public String getOrigin(){return origin;} public void setOrigin(String s){this.origin=s;}
    public String getDestination(){return destination;} public void setDestination(String s){this.destination=s;}
    public java.time.LocalDateTime getDepartureTime(){return departureTime;} public void setDepartureTime(java.time.LocalDateTime t){this.departureTime=t;}
    public java.time.LocalDateTime getArrivalTime(){return arrivalTime;} public void setArrivalTime(java.time.LocalDateTime t){this.arrivalTime=t;}
    public int getCapacity(){return capacity;} public void setCapacity(int c){this.capacity=c;}
    public double getPrice(){return price;} public void setPrice(double p){this.price=p;}
}
