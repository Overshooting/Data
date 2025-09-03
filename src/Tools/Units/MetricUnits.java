package Tools.Units;

public class MetricUnits {

    public static final String METERS = "Meters";
    public static final String GRAMS = "Grams";
    public static final String LITERS = "Liters";

    private static String[] degreeList = {"Quecto", "Ronto", "Yocto", "Zepto", "Atto",
            "Femto", "Pico", "Nano", "Micro", "Milli", "Centi", "Deci", "Base", "Deka",
            "Hecto", "Kilo", "Mega",  "Giga", "Tera", "Peta", "Exa", "Zetta", "Yotta",
            "Ronna", "Quetta"};

    private static String[] typesList = {"Meters", "Grams", "Liters"};

    // Creates a valid metric unit based on the provided degree and type of measurement
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

    private static boolean contains(String[] unitList, String unit) {
        for (String s : unitList) {
            if (unit.equals(s)) {
                return true;
            }
        }
        return false;
    }

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
