package com.calltaxi.bean;

public class Booking {

    private int bookingId;
    private int customerId;
    private char fromPoint;
    private char toPoint;
    private int pickupTime;
    private int dropTime;
    private int amount;

    public Booking(int bookingId, int customerId, char fromPoint, char toPoint,
                   int pickupTime, int dropTime, int amount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.amount = amount;
    }
    public int getBookingId() { return bookingId; }
    public int getCustomerId() { return customerId; }
    public char getFromPoint() { return fromPoint; }
    public char getToPoint() { return toPoint; }
    public int getPickupTime() { return pickupTime; }
    public int getDropTime() { return dropTime; }
    public int getAmount() { return amount; }
}