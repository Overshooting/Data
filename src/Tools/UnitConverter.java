package Tools;

import DataHolders.DataPoint;
import Tools.Conversions.ConversionCompiler;

public class UnitConverter {

    public static DataPoint convert(DataPoint d, String units, String conversiontype) {

        return ConversionCompiler.getConversion(d, units, conversiontype);

    }

    public static String conversionTypeList() {
        String str = "Here is the list of conversion tags:\n";

        str += "\nStandard Metric: MSTND \nSupply the 'convert()' function with only the metric prefix (FIRST LETTER MUST BE UPPERCASE) you would like to convert to. For the base prefix, supply it with 'Base'\nEX: convert(new DataPoint(Seconds, 5), 'Kilo', MSTND)\n";

        return str;
    }

}
