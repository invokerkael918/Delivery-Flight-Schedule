import model.Schedule;
import java.util.ArrayList;
import java.util.List;


public class Schedules {
    private ArrayList<Schedule> schedules;
    public ArrayList<Schedule> GetSchedules(){
        int flightNumber = 1;
        int day = 1;
        schedules = new ArrayList<>();
        Schedule schedule1 = new Schedule(flightNumber,"YUL","YYZ",day);
        flightNumber++;
        Schedule schedule2 = new Schedule(flightNumber,"YUL","YYC",day);
        flightNumber++;
        Schedule schedule3 = new Schedule(flightNumber,"YUL","YVR",day);
        flightNumber++;
        schedules.add(schedule1);
        schedules.add(schedule2);
        schedules.add(schedule3);

        day++;
        Schedule schedule4 = new Schedule(flightNumber,"YUL","YYZ",day);
        flightNumber++;
        Schedule schedule5 = new Schedule(flightNumber,"YUL","YYC",day);
        flightNumber++;
        Schedule schedule6 = new Schedule(flightNumber,"YUL","YVR",day);
        schedules.add(schedule4);
        schedules.add(schedule5);
        schedules.add(schedule6);

        return schedules;
    }

}
