package org.example.repository.implementation;

import org.example.model.Booking;
import org.example.model.Customer;
import org.example.model.Taxi;
import org.example.repository.BookingRepository;

import java.util.ArrayList;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {
    private List<Taxi> taxiList = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();


    @Override
    public List<Taxi> findTaxiByAvailability(int pickupTime) {
        List<Taxi> availableTaxis = new ArrayList<>();
        for(Taxi taxi : taxiList)
        {
            if(pickupTime >= taxi.getFreeBy())
            {
                availableTaxis.add(taxi);
            }
        }
        return availableTaxis;
    }
    @Override
    public void initializeTaxi(int n){
        for(int i =1;i<=n;i++)
        {
            Taxi taxi = new Taxi(i);
            taxiList.add(taxi);
        }
    }
    @Override
    public void display(){
        for(Taxi taxi:taxiList)
        {
            System.out.println("Taxi - "+taxi.getTaxiId() + "      " + " Total Earnings : "+ taxi.getEarnings());
            System.out.println();
            System.out.println("Booking_Id" + "   " + "Customer_ID" + "   " + "Pickup" + "   "+ "Drop"+"   "+"Pickup_Time"+"   "+"Drop_Time" + "   "+"Amount");
            for(int bookingId:taxi.bookingIds)
            {
                for(Booking booking:bookings)
                {
                    if(bookingId == booking.getBookingId())
                    {
                        System.out.println(booking.getBookingId() + "            " + booking.getCustomerId() + "           " + booking.getFrom() + "        " + booking.getTo() + "      " + booking.getPickupTime() + "             " + booking.getDropTime() + "           " + booking.getAmount());


                    }
                }
            }
            printBorder();
        }
    }
    @Override
    public void newCustomer(char drop,char pick,int customerId)
    {
        Customer customer = new Customer(drop,pick,customerId);
        customers.add(customer);
    }
    @Override
    public void newBooking(Booking booking)
    {
        bookings.add(booking);
    }

    private static void printBorder()
    {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println();
    }



}
