package org.example.repository;

import org.example.model.Booking;
import org.example.model.Taxi;

import java.util.List;

public interface BookingRepository {
    List<Taxi> findTaxiByAvailability(int pickupTime);
    void initializeTaxi(int n);

    void display();

    void newCustomer(char drop,char pick,int customerId);
    public void newBooking(Booking booking);


}
