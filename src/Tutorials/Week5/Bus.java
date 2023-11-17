package Tutorials.Week4;

import java.util.ArrayList;

public class Bus extends Transport {
    private String route;
    private ArrayList<Stop> stops = new ArrayList<>();

    public Bus(String r) {
        this.route = r;
    } // end constructor

    public void addStop(Stop s) {
        if (!stops.contains(s)) {
            stops.add(s);
        } // end if
    } // end add stop


    public void printTimetable() {
        System.out.println("Bus route: " + route);
        for (Stop sT : stops) {
            System.out.print(sT);
        }// end for lloop

    } // end method print time
} // end class
