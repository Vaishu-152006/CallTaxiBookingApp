package com.calltaxi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.calltaxi.bean.Booking;
import com.calltaxi.bean.Taxi;

public class TaxiBookingService {
    private List<Taxi> taxis = new ArrayList<>();
    private int bookingIdCounter = 1;
    public TaxiBookingService(int taxiCount) {
        for (int i = 1; i <= taxiCount; i++) {
            taxis.add(new Taxi(i));
        }
    }
    public void bookTaxi(int customerId, char from, char to, int pickupTime) {
        Taxi taxi = findTaxi(from, pickupTime);
        if (taxi == null) {
            System.out.println("Booking rejected. No taxi available.");
            return;
        }
        int distance = Math.abs(from - to) * 15;
        int travelHours = Math.abs(from - to);
        int dropTime = pickupTime + travelHours;
        int amount = calculateFare(distance);
        Booking booking = new Booking(bookingIdCounter++,customerId,from,to,pickupTime,dropTime,
                amount
        );
        taxi.getBookings().add(booking);
        taxi.addEarnings(amount);
        taxi.setCurrentPoint(to);
        taxi.setFreeTime(dropTime);
        System.out.println("Taxi can be allotted. Taxi-" +
                taxi.getTaxiId() + " is allotted.");
    }
    private Taxi findTaxi(char pickupPoint, int pickupTime) {
        List<Taxi> freeTaxis = new ArrayList<>();
        for (Taxi taxi : taxis) {
            if (taxi.getFreeTime() <= pickupTime) {
                freeTaxis.add(taxi);
            }
        }
        if (freeTaxis.isEmpty()) return null;
        Collections.sort(freeTaxis, new Comparator<Taxi>() {
            @Override
            public int compare(Taxi t1, Taxi t2) {

                int dist1 = Math.abs(t1.getCurrentPoint() - pickupPoint);
                int dist2 = Math.abs(t2.getCurrentPoint() - pickupPoint);
                if (dist1 == dist2) {
                    return t1.getTotalEarnings() - t2.getTotalEarnings();
                }
                return dist1 - dist2;
            }
        });
        return freeTaxis.get(0);
    }
    private int calculateFare(int distance) {
        if (distance <= 5) return 100;
        return 100 + (distance - 5) * 10;
    }

    public void displayTaxiDetails() {
        for (Taxi taxi : taxis) {
            System.out.println("\nTaxi-" + taxi.getTaxiId()+ "Total Earnings: Rs. "
                    + taxi.getTotalEarnings());
            System.out.println("BookingID  CustomerID  From  To  PickupTime  DropTime  Amount");
            for (Booking b : taxi.getBookings()) {
                System.out.println(
                        b.getBookingId() + " " +
                        b.getCustomerId() + " " +
                        b.getFromPoint() + " " +
                        b.getToPoint() + " " +
                        b.getPickupTime() + " " +
                        b.getDropTime() + " " +
                        b.getAmount());
            }
        }
    }
}