package org.example.service.implementation;

import org.example.model.Booking;
import org.example.model.Taxi;
import org.example.repository.BookingRepository;
import org.example.repository.implementation.BookingRepositoryImpl;
import org.example.service.BookingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Math.abs;

public class BookingServiceImpl implements BookingService {
    Scanner sc = new Scanner(System.in);
    private int bookingId = 1;
    static BookingRepository bookingRepository = new BookingRepositoryImpl();

    @Override
    public void bookTaxi(){
        char drop;
        char pick;                      // temporary variables for storing input data
        int customerId;
        int pickupTime;


        double earnings;
        int freeBy;                     // variables for processing data
        int reachDistance;
        int travelDistance;

        // getting input from the customer
        System.out.println("Customer Id : ");
        customerId = sc.nextInt();
        System.out.println("Drop Location : ");
        drop = sc.next().charAt(0);
        System.out.println("Pickup Location : ");
        pick = sc.next().charAt(0);
        System.out.println("Pickup Time : ");
        pickupTime = sc.nextInt();


        // adding customer to the database
        bookingRepository.newCustomer(drop,pick,customerId);

        //allocate taxi if available
        Taxi bestTaxi = allocateTaxi(drop,pick,pickupTime);

        //Displaying Booking Result
        if(bestTaxi == null)
        {
            System.out.println();
            System.out.println("Sorry, Taxi Not Available");
            System.out.println();
            return;
        }
        else {
            System.out.println();
            System.out.println("Taxi " + bestTaxi.getTaxiId() + " is allocated");
            System.out.println();


            //changing Taxi details once booked
            reachDistance = abs(bestTaxi.getCurrLocation() - pick);
            travelDistance = abs(pick - drop);
            freeBy = pickupTime+travelDistance+reachDistance;
            earnings = (travelDistance*150) + 50;

            //updating taxi details once booked
            bestTaxi.setCurrLocation(drop);
            bestTaxi.setFreeBy(freeBy);
            bestTaxi.setEarnings(bestTaxi.getEarnings()+earnings);

            //create booking log
            Booking booking = new Booking(bookingId++,customerId,pick,drop,pickupTime);
            bestTaxi.setBookingIds(booking.getBookingId());
            bookingRepository.newBooking(booking);

        }
    }
    @Override
    public void displayTaxiDetails(){bookingRepository.display();
    }
    @Override
    public void setTaxi(int n){
        bookingRepository.initializeTaxi(n);
    }



    // This method returns the nearest taxi with low earnings available at given time
    private static Taxi allocateTaxi(char drop,char pick,int pickupTime)
    {
        List<Taxi> availableTaxis= bookingRepository.findTaxiByAvailability(pickupTime);

        if(availableTaxis.isEmpty())
        {
            return null;
        }
        Taxi bestTaxi=null;
        int min = 10;
        for(Taxi taxi:availableTaxis)
        {
            int reachDistance = Math.abs(pick - taxi.getCurrLocation());
            if(reachDistance < min)
            {
                bestTaxi = taxi;
                min = reachDistance;
            }
            else if(reachDistance == min)
            {
                if(Objects.nonNull(bestTaxi) && (taxi.getEarnings() < bestTaxi.getEarnings()))
                    bestTaxi = taxi;

            }
        }
        return bestTaxi;

    }





}
