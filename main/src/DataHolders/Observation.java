package DataHolders;

import Environment.Time;
import Environment.Date;

/**
 * This class extends DataPoints to also contain the date and times in which they were recorded or created
 *
 * @version 1.0.0
 *
 */

public class Observation extends DataPoint {

    private Date dateTaken;
    private Time timeTaken;

    /**
     * Creates a new Observation with the given units, measure, date, and time
     * @param u The units of the Observation
     * @param d The measure of the Observation
     * @param da The date the Observation was recorded
     * @param t The time the Observation was recorded
     */
    public Observation(String u, double d, Date da, Time t) {
        super(u, d);

        dateTaken = da;
        timeTaken = t;
    }

    /**
     * Returns dateTaken
     * @return Returns the date that the Observation was recorded
     */
    public Date getDateTaken() {
        return dateTaken;
    }

    /**
     * Returns timeTaken
     * @return Returns the time that the Observation was recorded
     */
    public Time getTimeTaken() {
        return timeTaken;
    }

    /**
     * Compares recorded times and dates of two Observations
     * @param o The Observation being compared to this
     * @return Returns an int representing whether o was recorded before, at the same time, or after this
     */
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

    /**
     * Returns the Observation as a String
     * @return Returns a String in the form of "measure unit on: dateTaken at timeTaken"
     */
    public String toString() {
        return super.toString() + " on: " + dateTaken + " at " + timeTaken;
    }

}
