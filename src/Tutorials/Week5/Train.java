package Tutorials.Week4;

import java.util.ArrayList;

public class Train extends Transport{
    private String line;
    private ArrayList<Stop> stops = new ArrayList<>();

    public Train(String l) {
        line = l;
    } // end constructor

    public void addStop(Stop stop) {
        if(!stops.contains(stop)) {
            stops.add(stop);
        } // end if statement
    } // end method add stop

    public void printTimetable() {
        System.out.println();
    System.out.println("Train line name: " + line);

    for (Stop trainList : stops) {
        System.out.print(trainList);
    }
    }
} // end class
