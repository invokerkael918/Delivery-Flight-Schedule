import java.util.*;

import model.Order;
import model.Schedule;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int FlightNumber = 1;
        //Use Story one
        Schedules schedules = new Schedules();
        ArrayList<Schedule> schedulesList = schedules.GetSchedules();
        for (Schedule s : schedulesList) {
            System.out.println("Flight: " + s.getFlightNumber() + ", " + "departure: " + s.getDeparture() + ", " + "arrival: " + s.getDestination() + ", " + "day: " + s.getDate());
        }

        //Use Story two
        System.out.println("Please Enter the file address");
        //String address = myObj.nextLine();
        String address = "C:\\Users\\cy379\\Downloads\\coding-assigment-orders.json";
        //String address = "/Users/yuancao/Downloads/coding-assigment-orders.json";

        Loader loader = new Loader(address);
        loader.load();
        HashMap<String, ArrayList<Order>> Destination_to_List = loader.getDestination_to_Orderlist();
        //print not scheduled
        printOutScheduled(Destination_to_List);
        System.out.println("Not scheduled list:");
        ArrayList<Order> allOrderList = loader.getUnScheduledOrderList();
        for (Order order : allOrderList) {
            System.out.print("order: " + order.getCode() + ", ");
            System.out.println("Flight number: " + "Not scheduled ");
        }
        removeScheduled(Destination_to_List);

    }

    private static void removeScheduled(HashMap<String, ArrayList<Order>> Destination_to_List){
        for (String key:
             Destination_to_List.keySet()) {
            ArrayList<Order> YYZOrderList= Destination_to_List.get(key);
            int size =YYZOrderList.size();
            ArrayList<Order> newList = new ArrayList<>();
            for (int i = 0; i < size ; i++) {
                if (!YYZOrderList.get(i).isScheduled()){
                    newList.add(YYZOrderList.get(i));
                }
            }
            Destination_to_List.put(key,newList);
        }


    }




    private static void printOutScheduled(HashMap<String, ArrayList<Order>> Destination_to_List){

        System.out.println("Scheduled list:");
        for (String key: Destination_to_List.keySet()) {
            ArrayList<Order> cityOrderList = Destination_to_List.get(key);
            if (cityOrderList.size() >= 20) {
                setOrder(cityOrderList);
            }
            for (Order order : cityOrderList) {
                if (order.isScheduled()) {
                    System.out.print("order: " + order.getCode() + ", ");
                    System.out.print("Flight number: " + order.getSchedule().getFlightNumber() + ", ");
                    System.out.print("Departure: " + order.getSchedule().getDeparture() + ", ");
                    System.out.print("Arrvial: " + order.getDestination() + ", ");
                    System.out.print("Day: " + order.getSchedule().getDate());
                    System.out.println(" ");
                }

            }

        }
    }

    private static void setOrder(ArrayList<Order> orderlist) {
        for (int i = 0; i < 20; i++) {
            Order order = orderlist.get(i);
            Schedule schedule = new Schedule(flight_number, "YUL", order.getDestination(), date);
            order.setSchedule(schedule);
        }

        if (flight_number == 3) {
            date++;
        }
        flight_number++;
    }

    private static int date = 1;
    private static int flight_number = 1;
}
