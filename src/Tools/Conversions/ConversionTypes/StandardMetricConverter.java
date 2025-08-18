package Tools.Conversions.ConversionTypes;

import DataHolders.DataPoint;

import java.util.ArrayList;

public class StandardMetricConverter extends ConversionType {

    private ArrayList<String> prefixes = new ArrayList<String>();

    public StandardMetricConverter() {
        prefixes.add("Milli");prefixes.add("Centi");prefixes.add("Deci");prefixes.add("Base");prefixes.add("Deka");prefixes.add("Hecto");prefixes.add("Kilo");
        super.setTag("MSTND");
    }

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

            String newunit = "";
            double newvalue = d.getMeasurement() *  Math.pow(10, findDifference(prefixes.indexOf(oldprefix), u));
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

    private int findDifference(int oldprefixplace, String u) {
        boolean found = false;
        int count = 0;

        for (int i = oldprefixplace; i >= 0; i--) {
            if (prefixes.get(i).equals(u)) {
                return count;
            } else {
                count += 1;
            }
        }

        count = 0;
        for (int i = oldprefixplace; i < prefixes.size(); i++) {
            if (prefixes.get(i).equals(u)) {
                return count;
            } else {
                count -= 1;
            }
        }

        throw new IllegalArgumentException("No Such Conversion Exists!");
    }

    public ArrayList<String> getPrefixes() {
        return prefixes;
    }

}
