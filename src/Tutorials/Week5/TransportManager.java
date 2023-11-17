package Tutorials.Week4;

import java.util.ArrayList;

public class TransportManager {
    private ArrayList<Transport> transports = new ArrayList<>();

    public static void main (String [] args) {
        System.out.println("**************************Program Initiated**********************");
        System.out.println();
        TransportManager tMan = new TransportManager();

        Bus bOne = new Bus("55a");

        Time arrivalTime1 = new Time(9,5);
        Time arrivalTime2 = new Time(9,7);
        Time arrivalTime3 = new Time(9,8);
        Time arrivalTime4 = new Time(9,10);

        bOne.addStop(new Stop("UOW", arrivalTime1, new Time(arrivalTime1)));
        bOne.addStop(new Stop("Tafe Wollongong" , arrivalTime2, new Time(arrivalTime2)));
        bOne.addStop(new Stop("Foley st", arrivalTime3, new Time(arrivalTime3)));
        bOne.addStop(new Stop("Mercury st", arrivalTime3, new Time(arrivalTime4)));
        // end of bus object

        Coach cOne = new Coach("Wollongong", new Time(9,30),"Sydney", new Time(12,10));
        // end of coach object

        Train trainSoutCoast = new Train("South Coast");

        trainSoutCoast.addStop(new Stop("Central",  new Time(5,25), new Time(5,28)));
        trainSoutCoast.addStop(new Stop("Redfern", new Time(5,32), new Time(5,34)));
        trainSoutCoast.addStop(new Stop("Wolli Creek", new Time(5,42), new Time(5,44)));
        trainSoutCoast.addStop(new Stop("Hustville", new Time(5,58), new Time(6,0)));
        trainSoutCoast.addStop(new Stop("Sutherland", new Time(6,12), new Time(6,10)));
        trainSoutCoast.addStop(new Stop("North Wollongong", new Time(6,57), new Time(6,55)));
        trainSoutCoast.addStop(new Stop("Wollongong", new Time(7,0),new Time(7,3)));
        //end train object

        Ferry tarongaFerry = new Ferry("Taronga Zoo");

        tarongaFerry.addStop(new Stop("Mosman bay wharf", new Time(8,10), new Time(8,15)));
        tarongaFerry.addStop(new Stop("Taronga Zoo Wharf", new Time(8,25), new Time(8,29)));
        tarongaFerry.addStop(new Stop("Gremorne Point Wharf", new Time(8,38), new Time(8,41)));
        tarongaFerry.addStop(new Stop("Circular Quay", new Time(8,52), new Time(9,10)));
        // end ferry objects

        tMan.addTrasport(bOne);
        tMan.addTrasport(cOne);
        tMan.addTrasport(trainSoutCoast);
        tMan.addTrasport(tarongaFerry);

        tMan.printTransport();

        System.out.println();
        System.out.println("**********************Program terminated*******************");

    } // end main

    public void addTrasport(Transport t) {
            if (!transports.contains(t)) {
                transports.add(t);
            } // end if
    } // end method add trans

    public void printTransport() {
        for (Transport tList : transports) {
            tList.printTimetable();
        } // for loop

    } // end method print Trans
} // end class Trans manager
