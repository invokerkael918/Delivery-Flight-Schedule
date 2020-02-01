package model;

import java.util.ArrayList;

public class Plane {
    private int flight_Number;

    private Schedule schedule;

    private int capacity;

    private ArrayList<Order> orders;

    public Plane(int flight_Number,Schedule schedule){
        this.flight_Number = flight_Number;
        this.capacity = 20;
        this.schedule = schedule;
    }

    public void load(Order order){
        this.orders.add(order);
    }

    public boolean ableToload(){
        return this.orders.size() < this.capacity;
    }


}
