package org.example.controller;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import org.example.service.BookingService;
import org.example.service.implementation.BookingServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int noOfTaxi;
        BookingService bookingService =  new BookingServiceImpl();
        welcome();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Taxi");
        noOfTaxi = sc.nextInt();
        bookingService.setTaxi(noOfTaxi);

        application(bookingService,sc);

    }
    private static void description() {
        System.out.println();
        System.out.println("1.Book a Taxi");
        System.out.println("2.Display Taxi Details");
        System.out.println("3.Exit");
    }

    private static void welcome(){
        System.out.println("***************************************************************************************************");
        System.out.println();
        System.out.println();
        System.out.println("                                   Taxi Booking Application              ");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************************************************************");
    }

    private static void endMessage()
    {
        System.out.println("***************************************************************************************************");
        System.out.println();
        System.out.println();
        System.out.println("                                   Have a safe Ride              ");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************************************************************");
    }

    private static void application(BookingService bookingService,Scanner sc) {
        while(true)
        {

            description();
            System.out.println();
            System.out.println("Enter your choice");
            int choice;
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    bookingService.bookTaxi();
                    break;
                }

                case 2: {
                    bookingService.displayTaxiDetails();
                    break;
                }

                case 3: {
                    endMessage();
                    sc.close();
                    return;

                }
            }



        }

    }
}