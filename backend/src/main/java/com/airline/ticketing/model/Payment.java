
package com.airline.ticketing.model;
import jakarta.persistence.*;
@Entity
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @OneToOne private Booking booking;
    private double totalCost; private double amountPaid; private double changeGiven;
    public Payment() {}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Booking getBooking(){return booking;} public void setBooking(Booking b){this.booking=b;}
    public double getTotalCost(){return totalCost;} public void setTotalCost(double v){this.totalCost=v;}
    public double getAmountPaid(){return amountPaid;} public void setAmountPaid(double v){this.amountPaid=v;}
    public double getChangeGiven(){return changeGiven;} public void setChangeGiven(double v){this.changeGiven=v;}
}
