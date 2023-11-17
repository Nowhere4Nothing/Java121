package Tutorials.Week4;

public class Time {
    private int hour;
    private int minute;

    public Time (int h, int m) {
        this.hour = h;
        this.minute = m;
    } // end constructor

    public Time (Time t) {
      this(t.hour, t.minute);
    }

    public void setMinute(int m) {
        minute = m;
    }

    public void setHour(int h) {
        hour = h;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }
}
