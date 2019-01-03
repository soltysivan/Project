package org.truck.logistic.dao.entities;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private long ID;
    private long USER_ID;
    private String departure;
    private String arrival;
    private String distance;
    private String timeDelivary;

    public Order() {
    }

    public Order(long ID, long USER_ID, String departure, String arrival, String distance, String timeDelivary) {
        this.ID = ID;
        this.USER_ID = USER_ID;
        this.departure = departure;
        this.arrival = arrival;
        this.distance = distance;
        this.timeDelivary = timeDelivary;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", USER_ID=" + USER_ID +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", distance='" + distance + '\'' +
                ", timeDelivary='" + timeDelivary + '\'' +
                '}';
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(long USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTimeDelivary() {
        return timeDelivary;
    }

    public void setTimeDelivary(String timeDelivary) {
        this.timeDelivary = timeDelivary;
    }
}
