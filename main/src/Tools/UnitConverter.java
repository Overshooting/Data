package Tools;

import DataHolders.DataPoint;
import Tools.Conversions.ConversionCompiler;

/**
 * This class is meant to be used to convert one DataPoint to another DataPoint with different units and a proportional measure, as well as to act as a simple guide to the conversion process.
 * The converter classes are not all knowing, and require specific key Strings to be included with the convert method call to correctly convert DataPoints
 *
 * @version 1.0
 *
 */

public class UnitConverter {

    public static final String METRIC = "MET";
    public static final String IMPERIAL = "IMP";
    public static final String IMPERIAL_TO_METRIC = "I2M";

    /**
     * Converts a given DataPoint into another DataPoint with the given units String
     * @param d The DataPoint to be converted
     * @param units The new units for the converted DataPoint to be measured in
     * @param conversiontype The String key used to designate the type of conversion that needs to take place
     * @return Returns a new DataPoint, converted using the given ConversionType key, with designated units and a converted measurement
     */
    public static DataPoint convert(DataPoint d, String units, String conversiontype) {

        return ConversionCompiler.getConversion(d, units, conversiontype);

    }

    /**
     * Lists all available conversion types and their corresponding ConversionType keys
     * @return Returns a list of all available unit conversion types and ConversionType keys as a formatted String
     */
    public static String conversionTypeList() {
        String str = "Here is the list of conversion tags:\n";

        str += "\nMetric: MET \nSupply the 'convert()' function with only the metric prefix (FIRST LETTER MUST BE UPPERCASE) you would like to convert to. For the base prefix, supply it with 'Base'\nEX: convert(new DataPoint(Seconds, 5), 'Kilo', MET)\n";
        str += "\nImperial: IMP \nNothing special with this one, as with all conversions make sure your current and target units have the first letter capitalized\n";
        str += "\nImperial to Metric (and vice versa): I2M \nLike standard Metric, supply only metric prefix (FIRST LETTER UPPERCASE) or 'Base' when converting\n";

        return str;
    }

}
