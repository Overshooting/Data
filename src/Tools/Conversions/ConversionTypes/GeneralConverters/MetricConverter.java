package Tools.Conversions.ConversionTypes.GeneralConverters;

import DataHolders.DataPoint;
import Tools.Conversions.ConversionTypes.ConversionType;

import java.util.ArrayList;

public class MetricConverter extends ConversionType {

    private ArrayList<String> prefixes = new ArrayList<String>();
    private String[] prefixesInitializer = {"Quecto", "Ronto", "Yocto", "Zepto", "Atto",
            "Femto", "Pico", "Nano", "Micro", "Milli", "Centi", "Deci", "Base", "Deka",
            "Hecto", "Kilo", "Mega", "Giga", "Tera", "Peta", "Exa", "Zetta", "Yotta",
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
            if (d.getUnit() != u) {
                String oldprefix = "";

                for (String str : prefixes) {
                    if (d.getUnit().indexOf(str) == 0) {
                        oldprefix = str;
                    }
                }

                if (oldprefix.length() == 0) {
                    oldprefix = "Base";
                }


                double newvalue = 0;
                if (prefixes.indexOf(oldprefix) > prefixes.indexOf(u)) {
                    newvalue = d.getMeasurement() *
                            Math.pow(10, -1 * (ratios.get(prefixes.indexOf(u)) -
                                    findBaseDistance(prefixes.indexOf(oldprefix))));
                } else {
                    newvalue = d.getMeasurement() *
                            Math.pow(10, -1 * (ratios.get(prefixes.indexOf(u)) +
                                    findBaseDistance(prefixes.indexOf(oldprefix))));
                }
                String newunit = "";

                if (u.equals("Base") && !oldprefix.equals("Base")) {
                    newunit = d.getUnit().substring(oldprefix.length());
                } else if (oldprefix.equals("Base") && !u.equals("Base")) {
                    newunit = u + d.getUnit().toLowerCase();
                } else {
                    newunit = d.getUnit();
                }

                return new DataPoint(newunit, newvalue);
            } else {
                return d;
            }
    }

    public DataPoint convert(DataPoint d, String u, String type) {
            String oldprefix = "";
            String realtype = matchType(type);

            for (String str : prefixes) {
                if (d.getUnit().indexOf(str) == 0) {
                    oldprefix = str;
                }
            }

            if (oldprefix.length() == 0) {
                oldprefix = "Base";
            }


            double newvalue = 0;
            if (prefixes.indexOf(oldprefix) < prefixes.indexOf(u)) {
                newvalue = d.getMeasurement() *
                        Math.pow(10, -1 * (ratios.get(prefixes.indexOf(u)) -
                                findBaseDistance(prefixes.indexOf(oldprefix))));
            } else {
                newvalue = d.getMeasurement() *
                        Math.pow(10, -1 * (ratios.get(prefixes.indexOf(u)) +
                                findBaseDistance(prefixes.indexOf(oldprefix))));
            }

            String newunit = "";
            if (u.equals("Base")) {
                String realtypeone = realtype.substring(0,1);
                String realtypetwo = realtype.substring(1);
                newunit = realtypeone.toUpperCase() + realtypetwo;
            } else {
                newunit = u + realtype;
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

    public String getMetricType(String str) {
        if (str.contains("Grams") || str.contains("grams") || str.contains("Gram") || str.contains("gram")) {
            return "Mass";
        } else if (str.contains("Meters") || str.contains("meters") || str.contains("Meter") || str.contains("meter")) {
            return "Length";
        } else if (str.contains("Liters") || str.contains("liters") || str.contains("Liter") || str.contains("liter")) {
            return "Volume";
        } else {
            return "N/A";
        }
    }

    public String matchType(String str) {
        if (str.equals("Length")) {
            return "meters";
        } else if (str.equals("Volume")) {
            return "liters";
        } else {
            return "grams";
        }
    }

}
