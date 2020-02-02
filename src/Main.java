import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import model.Order;
import model.Schedule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) {

        //Use Story one
        Schedules schedules = new Schedules();
        ArrayList<Schedule> schedulesList = schedules.GetSchedules();
        for (Schedule s: schedulesList) {
            System.out.println("Flight: "+ s.getFlightNumber()+", "+"departure: "+s.getDeparture()+", "+"arrival: "+s.getDestination()+", "+"day: "+s.getDate());
        }

        //Use Story two
        final int capacity = 20;
        //String address = "C:\\Users\\cy379\\Downloads\\coding-assigment-orders.json";
        String address = "/Users/yuancao/Downloads/coding-assigment-orders.json";

        Loader loader = new Loader(address);
        loader.load();
        int size = loader.getSize();

        ArrayList<Order> orderList = loader.getOrderList();
        for(Order order: orderList){
            System.out.print(order.getCode() + " ");
            System.out.print(order.getDestination() + " ");
            System.out.println(order.getPriority());
        }

    }
}
