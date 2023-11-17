package Tutorials.Week4;

import java.util.ArrayList;

public class Ferry extends Transport {
    private String route;
    private ArrayList<Stop> stops = new ArrayList<>();

    public Ferry(String r) {
        this.route = r;
    }

    public void addStop(Stop s) {
        if (!stops.contains(s)) {
            stops.add(s);
        } // end if statement
    } // end method addStop

    public void printTimetable() {
        System.out.println();
        System.out.println("Ferry rout name: " + route);

        for (Stop fList : stops) {
            System.out.print(fList);
        } //end for loop
    } // end method print time table
} // end class
