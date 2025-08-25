package Tools.Conversions.ConversionTypes.GeneralConverters;

import DataHolders.DataPoint;
import Tools.Conversions.ConversionTypes.ConversionType;

import java.util.ArrayList;

public class MetricConverter extends ConversionType {

    private ArrayList<String> prefixes = new ArrayList<String>();
    private String[] prefixesInitializer = {"Quecto", "Ronto", "Yocto", "Zepto", "Atto",
            "Femto", "Pico", "Nano", "Micro", "Milli", "Centi", "Deci", "Base", "Deka",
            "Hecto", "Kilo", "Mega",  "Giga", "Tera", "Peta", "Exa", "Zetta", "Yotta",
            "Ronna", "Quetta"};

    private ArrayList<Integer> ratios = new ArrayList<Integer>();
    private int[] ratiosInitializer = {-30, -27, -24, -21, -18, -15, -12, -9, -6, -3, -2, -1,
            0, 1, 2, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30};

    public MetricConverter() {
        for (String str : prefixesInitializer) {
            prefixes.add(str);
        }

        for (int i : ratiosInitializer) {
            ratios.add(i);
        }

        super.setTag("MET");
    }

    @Override
    public DataPoint convert(DataPoint d, String u) {
            String oldprefix = "";


            for (String str : prefixes) {
                if (d.getUnit().indexOf(str) == 0) {
                    oldprefix = str;
                }
            }

            if (oldprefix.length() == 0) {
                oldprefix = "Base";
            }

            double newvalue = d.getMeasurement() *
                    Math.pow(10, ratios.get(prefixes.indexOf(u)) - findBaseDistance(prefixes.indexOf(oldprefix)));
            String newunit = "";;
            if (u.equals("Base")) {
                newunit = d.getUnit().substring(oldprefix.length());
            } else if (oldprefix.equals("Base")) {
                newunit = u + d.getUnit().toLowerCase();
            } else {
                newunit = d.getUnit().substring(oldprefix.length());
                newunit = u + newunit;
            }


            return new DataPoint(newunit, newvalue);
    }

    public int findBaseDistance(int oldprefixplace) {
        boolean found = false;
        int count = 0;

        for (int i = oldprefixplace; i >= 0; i--) {
            if (prefixes.get(i).equals("Base")) {
                return count;
            } else if (count >= 3){
                count += 3;
            } else {
                count += 1;
            }
        }

        count = 0;
        for (int i = oldprefixplace; i < prefixes.size(); i++) {
            if (prefixes.get(i).equals("Base")) {
                return count;
            } else if (count <= -3){
                count -= 3;
            } else {
                count -= 1;
            }
        }

        throw new IllegalArgumentException("No Such Conversion Exists!");
    }

    @Override
    public ArrayList<String> getUnitStrings() {
        return prefixes;
    }

}
