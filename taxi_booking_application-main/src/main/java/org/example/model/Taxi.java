package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private int taxiId;
    private char currLocation;
    private double earnings = 0;
    private int freeBy;
    public List<Integer> bookingIds = new ArrayList<>();

    public Taxi(int taxiId) {
        this.taxiId = taxiId;
        currLocation = 'A';
        freeBy = -1;
    }

    public char getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(char currLocation) {
        this.currLocation = currLocation;
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public int getFreeBy() {return freeBy;}

    public void setFreeBy(int freeBy) {this.freeBy = freeBy;}

    public void setBookingIds(int bookingId) {bookingIds.add(bookingId);}

}
