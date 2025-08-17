package DataHolders;

public class DescribedDataPoint extends DataPoint{

    private double independent;
    private String iunits;

    public DescribedDataPoint(String idunits, String units, double idependent, double dependent) {
        super(units, dependent);

        this.iunits = idunits;
        this.independent = idependent;
    }

    public double getIndependent() {
        return independent;
    }

    public String toString() {
        return "Independant: " + independent + " " + iunits + ", Dependent: " + super.getMeasurement() + " " + super.getUnit();
    }

    public String getIndependentUnits() {
        return iunits;
    }


    

}
