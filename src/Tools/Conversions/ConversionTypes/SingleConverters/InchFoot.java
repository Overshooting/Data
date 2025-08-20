package Tools.Conversions.ConversionTypes.SingleConverters;

import DataHolders.DataPoint;
import Tools.Conversions.ConversionTypes.ConversionType;

public class InchFoot extends ConversionType {

    public InchFoot() {
        super.setTag("INFT");
    }

    public DataPoint convert(DataPoint d) {
        if (d.getUnit().equals("Inches")) {
            return new DataPoint("Feet", d.getMeasurement() / 12);
        } else if (d.getUnit().equals("Feet")) {
            return new DataPoint("Inches", d.getMeasurement() * 12);
        } else {
            throw new IllegalArgumentException("Original DataPoint was not in Inches!");
        }
    }


}
