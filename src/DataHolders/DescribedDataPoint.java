package DataHolders;

public class DescribedDataPoint {

    private DataPoint independent, dependent;

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
