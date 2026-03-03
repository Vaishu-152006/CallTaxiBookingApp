package com.calltaxi.main;

import java.util.Scanner;
import com.calltaxi.service.TaxiBookingService;

public class Main {
    public static void main(String[] args) {
        TaxiBookingService service = new TaxiBookingService(4);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Book Taxi");
            System.out.println("2. Display Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Customer ID: ");
                    int id = sc.nextInt();

                    System.out.print("Pickup Point (A-F): ");
                    char from = sc.next().toUpperCase().charAt(0);

                    System.out.print("Drop Point (A-F): ");
                    char to = sc.next().toUpperCase().charAt(0);

                    System.out.print("Pickup Time: ");
                    int time = sc.nextInt();

                    service.bookTaxi(id, from, to, time);
                    break;

                case 2:
                    service.displayTaxiDetails();
                    break;

                case 3:
                    System.exit(0);
                    sc.close();
            }
        }
    }
}