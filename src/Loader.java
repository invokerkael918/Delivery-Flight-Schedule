import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import model.Order;
public class Loader {
    private JSONObject jsonObject;
    private JSONParser parser;
    private String address;
    private ArrayList<Order> orderList;

    public Loader(String address){
        this.address = address;
    }

    public void load(){
        try {
            System.out.println(address);
            parser = new JSONParser();
            orderList = new ArrayList();
            Object obj = parser.parse(new FileReader(
                    address));
            JSONObject jsonObject = (JSONObject) obj;
            Iterator<String> keys = jsonObject.keySet().iterator();
            while (keys.hasNext()){
                String key = keys.next();
                if (jsonObject.get(key) instanceof JSONObject){
                    JSONObject value = (JSONObject) jsonObject.get(key);
                    Order order = new Order();
                    order.setCode(key);
                    order.setDestination(value.get("destination").toString());
                    order.setPriority(Integer.parseInt(key.substring(key.length()-3)));
                    orderList.add(order);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSize(){
        return orderList.size();
    }

    public ArrayList<Order> getOrderList(){
        return orderList;
    }
}
