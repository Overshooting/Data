package DataHolders;

/**
 * This class uses DataPoints to create data containing independent and dependent variables
 *
 * @version 1.0.0
 *
 */

public class DescribedDataPoint {

    private DataPoint independent, dependent;

    /**
     * Creates a new DescribedDataPoint with given independent and dependent variable DataPoints
     * @param id The independent variable DataPoint
     * @param d
     */
    public DescribedDataPoint(DataPoint id, DataPoint d) {
        independent = id;
        dependent = d;
    }

    /**
     * Returns the independent variable
     * @return Returns the independent variable DataPoint
     */
    public DataPoint getIndependent() {
        return independent;
    }

    /**
     * Returns the dependent variable
     * @return Returns the dependent variable DataPoint
     */
    public DataPoint getDependent() {
        return dependent;
    }

    /**
     * Returns the DescribedDataPoint as a String
     * @return Returns a String in the form "Independent, Dependent"
     */
    public String toString() {
        return "Independent: " + independent + ", Dependent: " + dependent;
    }



    

}
