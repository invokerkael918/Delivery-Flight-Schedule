package model;

public class Order implements Comparable {

    private int priority;
    private String code;
    private String destination;
    private Schedule schedule = null;

    public Order(int priority, String code, String destination) {
        this.priority = priority;
        this.code = code;
        this.destination = destination;
    }

    public int getPriority() {
        return priority;
    }


    public String getCode() {
        return code;
    }


    public String getDestination() {
        return destination;
    }


    public Schedule getSchedule() {
        return schedule;
    }


    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean isScheduled() {
        return this.schedule != null;
    }

    @Override
    public int compareTo(Object compareOrder) {
        int comparePriority = ((Order) compareOrder).getPriority();
        return this.priority - comparePriority;
    }
}
