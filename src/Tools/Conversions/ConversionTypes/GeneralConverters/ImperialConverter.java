package Tools.Conversions.ConversionTypes.GeneralConverters;

import DataHolders.DataPoint;
import Tools.Conversions.ConversionTypes.ConversionType;

import java.util.ArrayList;

public class ImperialConverter extends ConversionType {

    private ArrayList<String> conversions = new ArrayList<String>();
    private String[] conversionsInitializer = {"Inches:Feet", "Inches:Yards", "Inches:Miles",
            "Feet:Yards", "Feet:Miles", "Yards:Miles", "Fluid Ounces:Pints", "Fluid Ounces:Quarts",
            "Fluid Ounces:Gallons", "Pints:Quarts", "Pints:Gallons", "Quarts:Gallons", "Ounces:Pounds",
            "Pounds:Tons", "Ounces:Tons"};

    private ArrayList<String> ratios = new ArrayList<String>();
    private String[] ratiosInitializer = {"12:1", "36:1", "63360:1", "3:1", "5280:1", "1760:1", "20:1",
            "40:1", "160:1", "2:1", "8:1", "4:1", "16:1", "2000:1", "32000:1"};

    public ImperialConverter() {
        for (String str : conversionsInitializer) {
            conversions.add(str);
        }

        for (String str : ratiosInitializer) {
            ratios.add(str);
        }

        super.setTag("IMP");
    }

    @Override
    public DataPoint convert(DataPoint d, String newunit) {
        if (d.getUnit() != newunit) {
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

        } else {
            return d;
        }

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

    @Override
    public ArrayList<String> getUnitStrings() {
        return conversions;
    }

    public String getImperialType(String str) {
        for (int i = 0; i < conversions.size(); i++) {
            if (conversions.get(i).contains(str)) {
                if (i >= 0 && i <= 5) {
                    return "Length";
                } else if (i > 5 && i <= 11) {
                    return "Volume";
                } else {
                    return "Mass";
                }
            }
        }

        throw new RuntimeException("Conversions array error");
    }

}
