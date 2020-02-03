import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import model.Order;

public class Loader {

    private JSONParser parser;
    private String address;
    private ArrayList<Order> orderList;
    private HashMap<String,ArrayList<Order>> Destination_to_Orderlist;

    public Loader(String address) {
        this.address = address;
    }

    public void load() {
        try {
            System.out.println(address);
            parser = new JSONParser();
            orderList = new ArrayList();
            Object obj = parser.parse(new FileReader(
                    address));
            JSONObject jsonObject = (JSONObject) obj;
            Iterator<String> keys = jsonObject.keySet().iterator();
            Destination_to_Orderlist = new HashMap<>();
            while (keys.hasNext()) {
                String key = keys.next();
                if (jsonObject.get(key) instanceof JSONObject) {
                    JSONObject value = (JSONObject) jsonObject.get(key);
                    String destination = value.get("destination").toString();
                    int priority = Integer.parseInt(key.substring(key.length() - 3));

                    Order order = new Order(priority,key,destination);
                    if (!Destination_to_Orderlist.containsKey(destination)){
                        Destination_to_Orderlist.put(destination,new ArrayList<>());
                    }
                    else{
                        Destination_to_Orderlist.get(destination).add(order);
                    }
                    orderList.add(order);
                }
            }
            //sort each city's order list by priority
            for (ArrayList<Order> cityOrderList:
                 this.Destination_to_Orderlist.values()) {
                Collections.sort(cityOrderList);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return orderList.size();
    }
    public ArrayList<Order> getOrderList() {
        return this.orderList;
    }

    public ArrayList<Order> getOrderList(String Destination) {
        return this.Destination_to_Orderlist.get(Destination);
    }

    public HashMap<String, ArrayList<Order>> getDestination_to_Orderlist() {
        return this.Destination_to_Orderlist;
    }
}
