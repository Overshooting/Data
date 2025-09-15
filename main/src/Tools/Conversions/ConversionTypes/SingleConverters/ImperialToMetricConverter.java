package Tools.Conversions.ConversionTypes.SingleConverters;

import DataHolders.DataPoint;
import Tools.Conversions.ConversionTypes.ConversionType;
import Tools.Conversions.ConversionTypes.GeneralConverters.ImperialConverter;
import Tools.Conversions.ConversionTypes.GeneralConverters.MetricConverter;

import java.util.ArrayList;

/**
 * This class is meant to convert metric unit DataPoints to imperial unit DataPoints and vice versa
 *
 * @version 1.0.0
 *
 */

public class ImperialToMetricConverter extends ConversionType {

    private ArrayList<String> conversions = new ArrayList<String>();
    private String[] conversionsInitializer = {"Feet:Base", "Fluid Ounces:Base", "Pounds:Base"};

    private ArrayList<String> ratios = new ArrayList<String>();
    private String[] ratiosInitializer= {"3.28084:1", "33.814:1", "0.00220462:1"};

    private MetricConverter metricConverter = new MetricConverter();
    private ImperialConverter imperialConverter = new ImperialConverter();

    /**
     * Creates a new ImperialToMetricConverter object
     */
    public ImperialToMetricConverter() {
        super.setTag("I2M");

        for (String str : conversionsInitializer) {
            conversions.add(str);
        }

        for (String str : ratiosInitializer) {
            ratios.add(str);
        }
    }

    /**
     * Converts a given DataPoint to its opposite measurement system counterpart
     * @param datapoint The given DataPoint to be converted
     * @param newunit The new units in the opposite measurement system for DataPoint to be converted to
     * @return Returns a new DataPoint representing the converted DataPoint from its old units to newunit, with a properly formatted unit String
     * @throws IllegalArgumentException Throws a new IllegalArgumentException if the given conversion from DataPoint's units to newunit does not exist on the conversions ArrayList
     */
    public DataPoint convert(DataPoint datapoint, String newunit) {
        boolean reverse = false;

        if (!metricConverter.getMetricType(datapoint.getUnit()).equals("N/A")) {
            reverse = true;
        }

        String type;
        if (reverse) {
            type = metricConverter.getMetricType(datapoint.getUnit());
        } else {
            type = imperialConverter.getImperialType(datapoint.getUnit());
        }

        String thisconversion = "";
        boolean found = false;

        System.out.println(datapoint);

        datapoint = makeBaseUnit(datapoint, reverse);
        String tempUnit = makeBaseUnit(new DataPoint(newunit, -1), !reverse).getUnit();

        System.out.println(datapoint);

        for (String str : conversions) {
            if (str.contains(datapoint.getUnit()) || str.contains(tempUnit)) {
                thisconversion = str;
                found = true;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("No such unit conversion!");
        }

        double newTempMeasure = datapoint.getMeasurement() * getRatio(thisconversion, reverse);

        datapoint = new DataPoint(tempUnit, newTempMeasure);

        System.out.println(datapoint);

        if (reverse) {
            return imperialConverter.convert(datapoint, newunit);
        } else {
            return metricConverter.convert(datapoint, newunit, type);
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
     * Returns a converted DataPoint to its system's base unit
     * @param datapoint The DataPoint to be converted
     * @param isMetric Boolean representing whether this is a metric system or imperial system conversion
     * @return Returns a DataPoint representing the given DataPoint converted to the given its system's base unit value
     */
    private DataPoint makeBaseUnit(DataPoint datapoint, boolean isMetric) {
        if (isMetric) {
            return metricConverter.convert(datapoint, "Base");
        } else {
            String type = imperialConverter.getImperialType(datapoint.getUnit());

            if (type.equals("Length")) {
                return imperialConverter.convert(datapoint, "Feet");
            } else if (type.equals("Volume")) {
                return imperialConverter.convert(datapoint, "Fluid Ounces");
            } else {
                return imperialConverter.convert(datapoint, "Pounds");
            }

        }
    }

}
