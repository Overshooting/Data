/**
 * This class is the basis for the entire Data projects' data structures
 *
 * @version 1.0.0
 *
 */


package DataHolders;

import java.lang.*;
import java.math.*;

public class DataPoint {

    private String unit;
    private double measure;

    /**
     * Creates a new DataPoint with a unit and a measurement
     * @param unit The type of unit for the DataPoint. It is recommended to use the provided constants in the Units package for consistency
     * @param measure The number that the DataPoint will hold
     */
    public DataPoint(String unit, double measure) {
        this.unit = unit;
        this.measure = measure;
    }

    /**
     * Returns unit
     * @return Returns the unit of the DataPoint
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Returns measurement
     * @return Returns the measurement of the DataPOint
     */
    public double getMeasurement() {
        return measure;
    }

    /**
     * Returns DataPoint as a String
     * @return Returns the DataPoint as a String in the form of "measure unit"
     */
    public String toString() {
        return measure + " " + unit;
    }


    /**
     * Rounds the DataPoints measure value to the given number of decimal places
     * @param p The number of decimal places the measure value will round to
     */
    public void round(int p) {
        BigDecimal bd = BigDecimal.valueOf(measure);
        bd = bd.setScale(p, RoundingMode.HALF_UP);
        measure = bd.doubleValue();
    }

    /**
     * Compares values of two DataPoints
     * @param d The DataPoint that this will be compared to
     * @return Returns an int representing whether the given DataPoint has the same value, a lower value, or a higher value than this
     * @throws IllegalArgumentException Throws an IllegalArgumentException if units between DataPoints do not match
     */
    public int compareTo(DataPoint d) {
        if (d.getUnit().equals(unit)) {
            if (measure < d.getMeasurement()) {
                return -5;
            } else if (measure > d.getMeasurement()) {
                return 5;
            } else {
                return 0;
            }
        } else {
           throw new IllegalArgumentException("Unit Mismatch!");
        }
    }
}
