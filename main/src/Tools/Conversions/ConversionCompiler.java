package Tools.Conversions;

import DataHolders.DataPoint;
import Tools.Conversions.ConversionTypes.ConversionType;
import Tools.Conversions.ConversionTypes.GeneralConverters.ImperialConverter;
import Tools.Conversions.ConversionTypes.GeneralConverters.MetricConverter;
import Tools.Conversions.ConversionTypes.SingleConverters.ImperialToMetricConverter;

/**
 * This class acts as a compiler of all the different unit converters so that they may be easily accessed by the UnitConverter class. It is meant to be strictly referenced from static contexts
 *
 * @version 1.0.0
 *
 */

public class ConversionCompiler {

    public static final ConversionType[] CONVERSION_TYPES = {new MetricConverter(),
            new ImperialConverter(), new ImperialToMetricConverter()};

    /**
     * Returns a boolean representing whether a ConversionType with the matching tag identifier exists in the converison types array
     * @param str The tag identifier of the desired ConversionType
     * @return Returns true if there is at least one ConversionType in the conversion types array with a matching tag identifier to str, returns false if there is not ConversionType with a matching tag identifier to str in the conversion types array
     */
    private static boolean contains(String str) {
        for (ConversionType ct : CONVERSION_TYPES) {
            if (str.equals(ct.getTag())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of a ConversionType with a matching tag identifier to the given String
     * @param str The tag identifier of the desired ConversionType
     * @return Returns an int representing the first index of a ConversionType with a matching tag identifier to str, returns -1 if no ConversionType is found
     */
    private static int indexOf(String str) {
        for (int i = 0; i < CONVERSION_TYPES.length; i++) {
            if (CONVERSION_TYPES[i].getTag().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns a converted DataPoint from a given type of unit conversion
     * @param d The DataPoint to be converted
     * @param str The new units for the DataPoint to be converted to
     * @param conversiontype The tag identifier of the desired ConversionType for the operation
     * @return Returns a converted DataPoint from a given DataPoint to a new DataPoint with formatted units str
     * @throws IllegalArgumentException Throws an IllegalArgumentException if there is no ConversionType on the array with a matching tag identifier to conversiontype
     */
    public static DataPoint getConversion(DataPoint d, String str, String conversiontype) {
        if (contains(conversiontype)) {
            return CONVERSION_TYPES[indexOf(conversiontype)].convert(d, str);
        } else {
            throw new IllegalArgumentException("No existing conversiontype!");
        }
    }

    /**
     * Returns a ConversionType on the conversion types array with a tag identifier matching the given String
     * @param str The tag identifier of the desired ConversionType
     * @return Returns the first ConversionType on the array with a tag identifier matching str, returns null if no ConversionType is found
     */
    public static ConversionType findConversion(String str) {
        for (ConversionType c : CONVERSION_TYPES) {
            if (c.getTag().equals(str)) {
                return c;
            }
        }

        return null;
    }

}
