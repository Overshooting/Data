package Tools.Conversions;

import DataHolders.DataPoint;
import Tools.Conversions.ConversionTypes.ConversionType;
import Tools.Conversions.ConversionTypes.ImperialConverter;
import Tools.Conversions.ConversionTypes.MetricConverter;

public class ConversionCompiler {

    public static final ConversionType[] CONVERSION_TYPES = {new MetricConverter(),
            new ImperialConverter()};

    private static boolean contains(String str) {
        for (ConversionType ct : CONVERSION_TYPES) {
            if (str.equals(ct.getTag())) {
                return true;
            }
        }
        return false;
    }

    private static int indexOf(String str) {
        for (int i = 0; i < CONVERSION_TYPES.length; i++) {
            if (CONVERSION_TYPES[i].getTag().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public static DataPoint getConversion(DataPoint d, String str, String conversiontype) {
        if (contains(conversiontype)) {
            return CONVERSION_TYPES[indexOf(conversiontype)].convert(d, str);
        } else {
            throw new IllegalArgumentException("No existing conversiontype!");
        }
    }

}
