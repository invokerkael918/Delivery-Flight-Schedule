package model;

import java.util.ArrayList;

public class Schedule {

    private int flightNumber;
    private String departure;
    private String destination;
    private int date;



    private boolean isLoaded;

    public Schedule(int flightNumber, String departure,String destination,int date){
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.date = date;
    }


    public int getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public int getDate() {
        return date;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public boolean isLoaded() { return isLoaded; }

    public void setLoaded(boolean loaded) { isLoaded = loaded; }

    @Override
    public String toString() {
        return "Schedule{" +
                "flightNumber=" + flightNumber +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                '}';
    }
}
