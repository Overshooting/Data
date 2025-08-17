package DataHolders;

import Environment.Time;
import Environment.Date;

public class Observation extends DataPoint {

    private Date dateTaken;
    private Time timeTaken;

    public Observation(String u, double d, Date da, Time t) {
        super(u, d);

        dateTaken = da;
        timeTaken = t;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public Time getTimeTaken() {
        return timeTaken;
    }

    public int compareTo(Observation o) {
        if (dateTaken.compareTo(o.getDateTaken()) < 0) {
            return -5;
        } else if (dateTaken.compareTo(o.getDateTaken()) > 0) {
            return 5;
        } else {
            if (timeTaken.compareTo(o.getTimeTaken()) < 0) {
                return -5;
            } else if (timeTaken.compareTo(o.getTimeTaken()) > 0) {
                return 5;
            } else {
                return 0;
            }
        }
    }

    public String toString() {
        return super.toString() + " on: " + dateTaken + " at " + timeTaken;
    }

}
