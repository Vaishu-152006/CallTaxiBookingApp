package com.calltaxi.bean;

import java.util.ArrayList;
import java.util.List;

public class Taxi {

    private int taxiId;
    private char currentPoint = 'A';
    private int freeTime = 0;
    private int totalEarnings = 0;
    private List<Booking> bookings = new ArrayList<>();

    public Taxi(int taxiId) {
        this.taxiId = taxiId;
    }
    public int getTaxiId() { return taxiId; }

    public char getCurrentPoint() { return currentPoint; }
    public void setCurrentPoint(char currentPoint) {
        this.currentPoint = currentPoint;
    }

    public int getFreeTime() { return freeTime; }
    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }

    public int getTotalEarnings() { return totalEarnings; }
    public void addEarnings(int amount) {
        this.totalEarnings += amount;
    }

    public List<Booking> getBookings() { return bookings; }
}