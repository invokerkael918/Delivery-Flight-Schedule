import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.Order;
import model.Plane;
import model.Schedule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) {
        int FlightNumber = 1;
        //Use Story one
        Schedules schedules = new Schedules();
        ArrayList<Schedule> schedulesList = schedules.GetSchedules();
        for (Schedule s: schedulesList) {
            System.out.println("Flight: "+ s.getFlightNumber()+", "+"departure: "+s.getDeparture()+", "+"arrival: "+s.getDestination()+", "+"day: "+s.getDate());
        }

        //Use Story two
        final int capacity = 20;
        String address = "C:\\Users\\cy379\\Downloads\\coding-assigment-orders.json";
        //String address = "/Users/yuancao/Downloads/coding-assigment-orders.json";

        Loader loader = new Loader(address);
        loader.load();
        int size = loader.getSize();

        HashMap<String, ArrayList<Order>> Destination_to_List = loader.getDestination_to_Orderlist();
        Iterator iterator = Destination_to_List.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry me2 = (Map.Entry) iterator.next();
//            ArrayList<Order> orderList = loader.getOrderList((String) me2.getKey());
//            System.out.println((String) me2.getKey() + " " + orderList.size());
//            for(Order order: orderList){
//                System.out.print(order.getCode() + " ");
//                System.out.print(order.getDestination() + " ");
//                System.out.println(order.getPriority());
//            }
//        }
        while(iterator.hasNext()){
            Map.Entry me2 = (Map.Entry) iterator.next();
            ArrayList<Order> cityOrderList = loader.getOrderList((String) me2.getKey());
            if(cityOrderList.size() >=20){
                setOrder(cityOrderList);
            }
            for(Order order: cityOrderList){
                if (order.isScheduled()){
                    System.out.print("order: "+order.getCode() + ", ");
                    System.out.print("Flight number: " + order.getSchedule().getFlightNumber()+", ");
                    System.out.print("Departure: " + order.getSchedule().getDeparture()+ ", ");
                    System.out.print("Arrvial: " + order.getDestination() + ", ");
                    System.out.print("Day: " + order.getSchedule().getDate());
                    System.out.println(" ");
                }
            }
        }
        //print not scheduled
        ArrayList<Order> allOrderList = loader.getUnScheduledOrderList();
        for(Order order: allOrderList){
            System.out.print("order: "+order.getCode() + ", ");
            System.out.println("Flight number: " + "Not scheduled ");
        }



    }
    private static void setOrder(ArrayList<Order> orderlist){
        for (int i = 0; i < 20; i++) {
            Order order = orderlist.get(i);
            Schedule schedule = new Schedule(flight_number,"YUL",order.getDestination(),date);
            order.setSchedule(schedule);
        }

        if (flight_number == 3){
            date++;
        }
        flight_number++;
    }
    private static int date = 1;
    private static int flight_number = 1;
}
