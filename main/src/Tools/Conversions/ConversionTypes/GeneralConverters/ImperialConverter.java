package Tools.Conversions.ConversionTypes.GeneralConverters;

import DataHolders.DataPoint;
import Tools.Conversions.ConversionTypes.ConversionType;

import java.util.ArrayList;

/**
 * This is a class meant to convert DataPoints holding imperial units into new DataPoints holding different imperial units, as well as provide a few tools for evaluating imperial units
 *
 * @version 1.0.0
 *
 */

public class ImperialConverter extends ConversionType {

    private ArrayList<String> conversions = new ArrayList<String>();
    private String[] conversionsInitializer = {"Inches:Feet", "Inches:Yards", "Inches:Miles",
            "Feet:Yards", "Feet:Miles", "Yards:Miles", "Fluid Ounces:Pints", "Fluid Ounces:Quarts",
            "Fluid Ounces:Gallons", "Pints:Quarts", "Pints:Gallons", "Quarts:Gallons", "Ounces:Pounds",
            "Pounds:Tons", "Ounces:Tons"};

    private ArrayList<String> ratios = new ArrayList<String>();
    private String[] ratiosInitializer = {"12:1", "36:1", "63360:1", "3:1", "5280:1", "1760:1", "16:1",
            "32:1", "128:1", "2:1", "8:1", "4:1", "16:1", "2000:1", "32000:1"};

    /**
     * Creates a new ImperialConverter object
     */
    public ImperialConverter() {
        for (String str : conversionsInitializer) {
            conversions.add(str);
        }

        for (String str : ratiosInitializer) {
            ratios.add(str);
        }

        super.setTag("IMP");
    }

    /**
     * Converts one imperial DataPoint into a new DataPoint with different imperial units
     * @param d The DataPoint to be converted
     * @param newunit The new unit for the DataPoint to be converted to
     * @return Returns a new DataPoint holding the newly converted value from the DataPoint d's units to newunits, with properly formatted newunits as its unit value
     * @throws IllegalArgumentException Throws an IllegalArgumentException if there is no unit conversion matching the given DataPoint's units to newunit or vice versa
     */
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

    /**
     * Gives the proper conversion ratio for a given conversion
     * @param thisconversion The String matching a conversion ratio found in conversions
     * @param isReversed Boolean value representing the direction of the conversion across the given String
     * @return Returns a double value representing the conversion ratio between two units described by thisconversion
     */
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

    /**
     * Returns the list of unit conversions
     * @return Returns the ArrayList of conversion Strings
     */
    public ArrayList<String> getUnitStrings() {
        return conversions;
    }

    /**
     * Returns the type of measurement a unit represents
     * @param str The unit
     * @return Returns a String representing the type of measurement the unit represents
     * @throws RuntimeException Throws a RuntimeException if the conversions array does not contain the given unit String
     */
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
