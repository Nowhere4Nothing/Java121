package Final;

public class Stop {
    private String name;
    private int arrivalHour;
    private int arrivalMinite;

    public Stop(String n, int ah, int am) {
        name = n;
        arrivalHour = ah;
        arrivalMinite = am;
    }

    public String toString() {
        return name + " "
        + arrivalHour + ":" + arrivalMinite;
    }
}

