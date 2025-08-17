package Environment;

public class Time {

    private int hour, minute;
    private double second;

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

    public static double convertMilliseconds(double s, double m) {
        return s + (m / 1000);
    }

    public String toString() {
        return hour + ":" + minute + ":" + second;
    }

    public String getStandard() {
        if (hour > 12) {
            return (hour % 12) + ":" + minute + ":" + second;
        } else {
            return toString();
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public double getSecond() {
        return second;
    }

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

    public static Time randTime() {
        return new Time((int)(Math.random() * 24), (int)(Math.random()*60), (int)Math.random()*60);
    }
}
