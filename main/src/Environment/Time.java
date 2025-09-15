package Environment;

/**
 * This class is meant to store times to be used to describe Observations made
 *
 * @version 1.0.0
 *
 */

public class Time {

    private int hour, minute;
    private double second;

    /**
     * Creates a new Time with the given hours, minutes, and seconds
     * @param h The hours
     * @param min The minutes
     * @param s The seconds with milliseconds as a decimal place
     * @throws IllegalArgumentException Throws an IllegalArgumentException if any of the hours, minutes, or seconds exceed their maximum values or fall short of their minimum values
     */
    public Time(int h, int min, double s) {
        if (h > -1 && h < 24 && min < 61 & min > -1 && s > -1 && s < 61) {
            hour = h;
            minute = min;
            second = s;
        } else {
            System.out.println("!!Input a real time!!");
            throw new IllegalArgumentException();
        }
    }

    /**
     * Creates a new Time with the given hours, minutes, and seconds
     * @param h The hours
     * @param min The minutes
     * @param s The seconds
     * @throws IllegalArgumentException Throws an IllegalArgumentException if any of the hours, minutes, or seconds exceed their maximum values or fall short of their minimum values
     */
    public Time(int h, int min, int s) {
        if (h > -1 && h < 24 && min < 61 & min > -1 && s > -1 && s < 61) {
            hour = h;
            minute = min;
            second = s;
        } else {
            System.out.println("!!Input a real time!!");
            throw new IllegalArgumentException();
        }
    }

    /**
     * Converts a given number of seconds and milliseconds into a decimal value in seconds
     * @param s The number of seconds
     * @param m The number of milliseconds
     * @return Returns a double value representing the combined seconds and milliseconds values as decimals
     */
    public static double convertMilliseconds(double s, double m) {
        return s + (m / 1000);
    }

    public String toString() {
        return hour + ":" + minute + ":" + second;
    }

    /**
     * Returns a String representing the Time in standard, rather than military
     * @return Returns a String representing the Time's values in standard time
     */
    public String getStandard() {
        if (hour > 12) {
            return (hour % 12) + ":" + minute + ":" + second;
        } else {
            return toString();
        }
    }

    /**
     * Returns hour
     * @return Returns the hours of the Time
     */
    public int getHour() {
        return hour;
    }

    /**
     * Returns minute
     * @return Returns the minutes of the Time
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Returns second
     * @return Returns the seconds of the Time
     */
    public double getSecond() {
        return second;
    }

    /**
     * Compares this Time to another given Time based on chronological order
     * @param o The other Time
     * @return Returns an int value representing whether this holds a shorter, longer, or the same time as the other Time
      */
    public int compareTo(Time o) {
        int c;
        int ohour = o.getHour();
        int ominute = o.getMinute();
        double osecond = o.getSecond();

        if (hour < ohour) {
            c = -5;
        } else if (hour > ohour) {
            c = 5;
        } else {
            if (minute > ominute) {
                c = 5;
            } else if (minute < ominute) {
                c = -5;
            } else {
                if (second > osecond) {
                    c = 5;
                } else if (second < osecond) {
                    c = -5;
                } else {
                    c = 0;
                }
            }
        }
        return c;
    }

    /**
     * Creates a random Time
     * @return Returns a new randomly generated valid Time object
     */
    public static Time randTime() {
        return new Time((int)(Math.random() * 24), (int)(Math.random()*60), (int)Math.random()*60);
    }
}
