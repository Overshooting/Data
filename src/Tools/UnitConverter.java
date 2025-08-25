package Tools;

import DataHolders.DataPoint;
import Tools.Conversions.ConversionCompiler;

public class UnitConverter {

    public static final String METRIC = "MET";
    public static final String IMPERIAL = "IMP";
    public static final String IMPERIAL_TO_METRIC = "I2M";


    public static DataPoint convert(DataPoint d, String units, String conversiontype) {

        return ConversionCompiler.getConversion(d, units, conversiontype);

    }

    public static String conversionTypeList() {
        String str = "Here is the list of conversion tags:\n";

        str += "\nMetric: MET \nSupply the 'convert()' function with only the metric prefix (FIRST LETTER MUST BE UPPERCASE) you would like to convert to. For the base prefix, supply it with 'Base'\nEX: convert(new DataPoint(Seconds, 5), 'Kilo', MET)\n";
        str += "\nImperial: IMP \nNothing special with this one, as with all conversions make sure your current and target units have the first letter capitalized\n";
        str += "\nImperial to Metric (and vice versa): I2M \nLike standard Metric, supply only metric prefix (FIRST LETTER UPPERCASE) when converting\n";

        return str;
    }

}
