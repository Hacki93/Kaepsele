package controller;

import java.util.Date;

/**
 * @author Hannes
 * Diese Klasse beinhaltet Methoden zur Zeitmessung
 */
public class TimeStamp {
    
    static private long last;
    
    /**
     * Startet den Timer
     */
    public TimeStamp()  {
        set();
    }
    
    /**
     * Startet den Timer
     */
    public static void set() {
        Date today = new Date();
        last = today.getTime();
    }
    
    /**
     * Gibt aktuelle exakte Zeit zur&uuml;ck
     * @return Exakte aktuelle Zeit
     */
    public static long get() {
        Date today = new Date();
        long   now = today.getTime();
        return now;
    }
    

    /**
     * Ermittelt die Zeit, die seit Timerstart vergangen ist
     * @return Zeit-Delta in Sekunden
     */
    public static double elapsed() {
        double delta = get() - last;
        return delta/1000;
    }
}