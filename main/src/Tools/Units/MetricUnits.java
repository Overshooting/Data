package Tools.Units;

/**
 * This is a class meant to deal with and standardize Strings representing metric system units
 *
 * @version 1.0.0
 *
 */

public class MetricUnits {

    public static final String METERS = "Meters";
    public static final String GRAMS = "Grams";
    public static final String LITERS = "Liters";

    private static String[] degreeList = {"Quecto", "Ronto", "Yocto", "Zepto", "Atto",
            "Femto", "Pico", "Nano", "Micro", "Milli", "Centi", "Deci", "Base", "Deka",
            "Hecto", "Kilo", "Mega",  "Giga", "Tera", "Peta", "Exa", "Zetta", "Yotta",
            "Ronna", "Quetta"};

    private static String[] typesList = {"Meters", "Grams", "Liters"};

    /**
     * Creates a valid metric unit based on the provided prefix and measurement type
     * @param prefix The prefix of the desired metric unit
     * @param type The type of measurement of the desired metric unit
     * @return If the provided prefix and type can be combined into a valid unit, then returns a valid metric unit String of the correct prefix and type, otherwise returns a String with the value "Not a unit"
     */
    public static String createMetricUnit(String prefix, String type) {
        if (contains(degreeList, prefix) && contains(typesList, type)) {
            String degOne = prefix.substring(0,1);
            prefix = degOne.toUpperCase() + prefix.substring(1);

            String typOne = type.substring(0, 1);
            type = typOne.toLowerCase() + type.substring(1);

            return prefix + type;
        } else {
            return "Not a unit";
        }

    }

    /**
     * Internal helper method for parsing metric unit arrays
     * @param unitList
     * @param unit
     * @return
     */
    private static boolean contains(String[] unitList, String unit) {
        for (String s : unitList) {
            if (unit.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether a given String is a valid metric unit recognized by the MetricUnits class
     * @param unit The String to be checked
     * @return Returns true if the given String is a valid combination of a metric prefix and measurement type
     */
    public static boolean isAValidMetricUnit(String unit) {
        if (unit.equals(METERS) || unit.equals(GRAMS) || unit.equals(LITERS)) {
            return true;
        }

        boolean oneTrue = false;
        boolean twoTrue = false;
        int oneLength = 0;
        int twoLength = 0;

        for (String s : degreeList) {
            if (unit.contains(s)) {
                oneTrue = true;
                oneLength = s.length();
            }
        }

        if (unit.contains(METERS.toLowerCase())) {
            twoTrue = true;
            twoLength = METERS.length();
        } else if (unit.contains(GRAMS.toLowerCase())) {
            twoTrue = true;
            twoLength = GRAMS.length();
        } else if (unit.contains(LITERS.toLowerCase())) {
             twoTrue = true;
             twoLength = LITERS.length();
        }

        return oneTrue && twoTrue && (oneLength + twoLength == unit.length());
    }

}
