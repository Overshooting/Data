package DataHolders;

import java.lang.*;
import java.math.*;

public class DataPoint {

    private String unit;
    private double measure;

    public DataPoint(String unit, double measure) {
        this.unit = unit;
        this.measure = measure;
    }

    public String getUnit() {
        return unit;
    }

    public double getMeasurement() {
        return measure;
    }

    public String toString() {
        return measure + " " + unit;
    }

    // Rounds the DataPoint's measurement to the nearest whole number
    public void round(int p) {
        BigDecimal bd = BigDecimal.valueOf(measure);
        bd = bd.setScale(p, RoundingMode.HALF_UP);
        measure = bd.doubleValue();
    }

    public int compareTo(DataPoint d) {
        if (measure < d.getMeasurement()) {
            return -5;
        } else if (measure > d.getMeasurement()) {
            return 5;
        } else {
            return 0;
        }
    }
}
