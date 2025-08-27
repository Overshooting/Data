package Tools.Conversions.ConversionTypes.SingleConverters;

import DataHolders.DataPoint;
import Tools.Conversions.ConversionTypes.ConversionType;
import Tools.Conversions.ConversionTypes.GeneralConverters.ImperialConverter;
import Tools.Conversions.ConversionTypes.GeneralConverters.MetricConverter;

import java.util.ArrayList;

public class ImperialToMetricConverter extends ConversionType {

    private ArrayList<String> conversions = new ArrayList<String>();
    private String[] conversionsInitializer = {"Feet:Base", "Fluid Ounces:Base", "Pounds:Base"};

    private ArrayList<String> ratios = new ArrayList<String>();
    private String[] ratiosInitializer= {"3.28084:1", "33.814:1", "0.00220462:1"};

    private MetricConverter metricConverter = new MetricConverter();
    private ImperialConverter imperialConverter = new ImperialConverter();

    public ImperialToMetricConverter() {
        super.setTag("I2M");

        for (String str : conversionsInitializer) {
            conversions.add(str);
        }

        for (String str : ratiosInitializer) {
            ratios.add(str);
        }
    }

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
