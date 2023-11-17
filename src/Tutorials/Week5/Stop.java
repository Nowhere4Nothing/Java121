package Tutorials.Week4;

public class Stop {
    private String name;
    private Time arrivalTime;
    private Time departureTime;

    public Stop (String n, Time aT, Time dT) {
        this.name = n;
        this.arrivalTime = aT;
        this.departureTime = dT;
    }

    public String toString () {
        return "Stop name: " + name + ", Arrival time: " + arrivalTime.getHour() + ":" + arrivalTime.getMinute()
                + ", Departure time: " + departureTime.getHour() + ":" + departureTime.getMinute() + ". \n";
    }
}
