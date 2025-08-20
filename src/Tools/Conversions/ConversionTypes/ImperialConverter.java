package Tools.Conversions.ConversionTypes;

import DataHolders.DataPoint;

import java.util.ArrayList;

public class ImperialConverter extends ConversionType {

    private ArrayList<String> conversions = new ArrayList<String>();
    private String[] conversionsInitializer = {"Inches:Feet", "Feet:Yards", "Yards:Miles",
            "Fluid Ounces:Pints", "Pints:Quarts", "Quarts:Gallons", "Ounces:Pounds", "Pounds:Tons"};

    private ArrayList<String> ratios = new ArrayList<String>();
    private String[] ratiosInitializer = {"12:1", "3:1", "1760:1", "16:1", "2:1", "4:1", "16:1",
        "2000:1"};

    public ImperialConverter() {
        for (String str : conversionsInitializer) {
            conversions.add(str);
        }

        for (String str : ratiosInitializer) {
            ratios.add(str);
        }

        super.setTag("IMP");
    }

    public DataPoint convert(DataPoint d, String newunit) {
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
