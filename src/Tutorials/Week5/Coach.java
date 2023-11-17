package Tutorials.Week4;

public class Coach extends Transport {
    private String departureCity;
    private Time departureTime;
    private String destinationCity;
    private Time arrivalTime;

    public Coach (String dc, Time dt, String destC, Time at) {
    this.departureCity = dc;
    this.departureTime = dt;
    this.destinationCity = destC;
    this.arrivalTime = at;
    }

    public void printTimetable() {
        System.out.println("\nCoach departure from " + departureCity + " at " + departureTime.getHour() + ":" + departureTime.getMinute()
                + ", Arrival to " + destinationCity
        + " at " + arrivalTime.getHour() + ":" + arrivalTime.getMinute() + ".");
    }
}
