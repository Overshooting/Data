package DataHolders;

public class DescribedDataPoint {

    private DataPoint independent, dependent;

    // Creates new DescribedDataPoint with an independent DataPoint and a dependent DataPoint
    public DescribedDataPoint(DataPoint id, DataPoint d) {
        independent = id;
        dependent = d;
    }

    public DataPoint getIndependent() {
        return independent;
    }

    public DataPoint getDependent() {
        return dependent;
    }

    public String toString() {
        return "Independant: " + independent + ", Dependent: " + dependent;
    }



    

}
