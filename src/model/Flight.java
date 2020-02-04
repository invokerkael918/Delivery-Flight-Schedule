package model;

import java.util.ArrayList;

public class Flight {

    private Schedule schedule;
    private int capacity;
    private ArrayList<Order> orders;

    public Flight(int capacity, Schedule schedule) {
        this.schedule.setLoaded(true);
        this.capacity = capacity;
        this.schedule = schedule;
        this.orders = new ArrayList<>();
    }

    public void load(Order order) {
        this.orders.add(order);
    }

    public boolean ableToload() {
        return this.orders.size() < this.capacity;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + schedule.getFlightNumber() +
                ", departure='" + schedule.getDeparture() + '\'' +
                ", destination='" + schedule.getDestination() + '\'' +
                ", date=" + schedule.getDate() +
                '}';
    }


}
