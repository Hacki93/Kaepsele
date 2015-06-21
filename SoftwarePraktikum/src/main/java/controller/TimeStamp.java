package controller;

import java.util.Date;

public class TimeStamp {
    
    static private long last;
    
    public TimeStamp()  {
        set();
    }
    
    public static void set() {
        Date today = new Date();
        last = today.getTime();
    }
    
    public static long get() {
        Date today = new Date();
        long   now = today.getTime();
        return now;
    }

    /**
     * Ermittelt die Zeit, die zwischen diesem Moment und der letzten
     * set() Operation vergangen ist.
     * @return Zeit-Delta in Sekunden
     */
    public static double elapsed() {
        double delta = get() - last;
        return delta/1000;
    }
}