package Environment;

public class Date {

    private int day, month, year;
    private static final String[] MONTHS = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    private static final String[] DAYS = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    public Date(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }

    // Returns true if the Date is not a real date on the calendar
    public boolean isIllegalDate() {
        if (day < 1 || day > 31 || year < 0 || month < 1 || month > 12) {
            return false;
        } else if (day > maxDays()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isALeapYear() {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getWeekDay() {
        return DAYS[dayOfWeekInt()];
    }

    public String getMonthString() {
        return MONTHS[month - 1];
    }

    public String getDayString() {
        String str = "";
        int day = this.getDay();
        int enday;
        if (day < 4) {
            enday = day;
        } else {
            enday = day % 10;
        }

        if (enday == 0 || enday > 3 || day == 11 || day == 12 || day == 13) {
            str = day + "th";
        } else if (enday == 1) {
            str = day + "st";
        } else if (enday == 2) {
            str = day + "nd";
        } else {
            str = day + "rd";
        }

        return str;
    }

    // Returns the day of the week represented by an int value
    public int dayOfWeekInt() {
        int century = this.getYear() / 100;
        int centuryValue = 2*(3 - (century % 4));
        int yearend = (int)(Math.round((this.getYear() / 100.0 - century) * 100));
        int yearValue = (int)yearend + (int)yearend / 4;
        int tmonth = this.getMonth();
        int monthValue;

        if (tmonth == 1 || tmonth == 10) {
            if (this.isALeapYear() && tmonth == 1) {
                monthValue = 6;
            } else {
                monthValue = 0;
            }
        } else if (tmonth == 2 || tmonth == 3 || tmonth == 11) {
            if (this.isALeapYear() && tmonth == 2) {
                monthValue = 2;
            } else {
                monthValue = 3;
            }
        } else if (tmonth == 4 || tmonth == 7) {
            monthValue = 6;
        } else if (tmonth == 5) {
            monthValue = 1;
        } else if (tmonth == 6) {
            monthValue = 4;
        } else if (tmonth == 8) {
            monthValue = 2;
        } else {
            monthValue = 5;
        }

        int dayValue = this.getDay();
        int weekday = (dayValue + monthValue + centuryValue + yearValue) % 7;
        return weekday;
    }

    // Returns the maximum days of the month of the Date
    public int maxDays() {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2 && isALeapYear()) {
            return 29;
        } else if (month == 2) {
            return 28;
        } else {
            return 31;
        }
    }

    public String toString() {
        return getWeekDay() + " " + getMonthString() + " " + getDayString() + ", " + getYear();
    }

    public int compareTo(Date o) {
        int myday = this.getDay();
        int mymonth = this.getMonth();
        int myyear = this.getYear();
        int oday = o.getDay();
        int omonth = o.getMonth();
        int oyear = o.getYear();

        int c;

        if (myyear < oyear) {
            c = -5;
        } else if (myyear > oyear) {
            c = 5;
        } else {
            if (mymonth > omonth) {
                c = 5;
            } else if (mymonth < omonth) {
                c = -5;
            } else {
                if (myday > oday) {
                    c = 5;
                } else if (myday < oday) {
                    c = -5;
                } else {
                    c = 0;
                }
            }
        }
        return c;
    }

    // Generates a random valid date
    public static Date randDate() {
        return new Date((int)((Math.random() * 20)), (int)((Math.random()*12)+1), (int)(Math.random()*30)+1);
    }

}
