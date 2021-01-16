// TimeEx.java

import java.util.*;

class Time {

    private int hour, minute, second;

    Time(int h, int m, int s) {

        hour = h; minute = m; second = s;

    }

    public String toString() {

        return hour + ":" + minute + ":" + second;

    }

    public int getHour() { return hour; }

    public int getMinute() { return minute; }

    public int getSecond() { return second; }

}

class TimeComparator implements Comparator<Time> {

    public int compare(Time t1, Time t2) {
        int h = (t1.getHour() < t2.getHour())?-1:0;

        if (h != 0)

            return h;

        int m = (t1.getMinute() < t2.getMinute())?-1:0;

        if (m != 0)

            return m;

        return  (t1.getSecond() < t2.getSecond())?-1:0;

    }

}

class TimeEx {

    public static void main(String args[]) {

        Time []t = { new Time(6, 10, 00),

                    new Time(6, 30, 11),

                    new Time(6, 45, 50)};

        Arrays.sort(t, new TimeComparator());

        System.out.println(Arrays.asList(t));

    }

}