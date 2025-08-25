package Tools.Conversions.ConversionTypes.SingleConverters;

import DataHolders.DataPoint;
import Tools.Conversions.ConversionCompiler;
import Tools.Conversions.ConversionTypes.ConversionType;
import java.util.ArrayList;

public class ImperialToMetricConverter extends ConversionType {

    public ArrayList<String> conversions = new ArrayList<String>();
    public String[] conversionsInitializer = {"WIP"};

    public ArrayList<String> ratios = new ArrayList<String>();
    public String[] ratiosInitializer= {"WIP"};

    public ImperialToMetricConverter() {
        super.setTag("I2M");

        for (String str : conversionsInitializer) {
            conversions.add(str);
        }

        for (String str : ratiosInitializer) {
            ratios.add(str);
        }
    }

    public DataPoint convert(DataPoint d, String newunit) {
        boolean reverse = false;

        for (String str : ConversionCompiler.findConversion("MET").getUnitStrings()) {
            if (d.getUnit().contains(str)) {
                reverse = true;
            }
        }

        String thisconversion = "";
        boolean found = false;

        for (String str : conversions) {
            if (str.contains(d.getUnit()) && str.contains(newunit)) {
                thisconversion = str;
                found = true;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("No such unit conversion!");
        }

        boolean isReversed = false;
        if (!(thisconversion.indexOf(d.getUnit()) == 0)) {
            isReversed = true;
        }

        double newvalue = d.getMeasurement() * getRatio(thisconversion, isReversed);

        return new DataPoint(newunit, newvalue);

    }

    private double getRatio(String thisconversion, boolean isReversed) {
        String thisratio = ratios.get(conversions.indexOf(thisconversion));

        double firstspace = Double.parseDouble(thisratio.substring(0, thisratio.indexOf(":")));
        double secondspace = Double.parseDouble(thisratio.substring(thisratio.indexOf(":")+1));

        if (isReversed) {
            return firstspace / secondspace;
        } else {
            return secondspace / firstspace;
        }
    }

}
