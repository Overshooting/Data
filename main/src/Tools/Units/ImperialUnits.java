package Tools.Units;

/**
 * This is a class meant to deal with and standardize Strings representing imperial system units
 *
 * @version 1.0.0
 *
 */

public class ImperialUnits {

    public static final String FEET = "Feet";
    public static final String INCHES = "Inches";
    public static final String YARDS = "Yards";
    public static final String MILES = "Miles";

    public static final String OUNCES = "Ounces";
    public static final String POUNDS = "Pounds";
    public static final String TONS = "Tons";

    public static final String FLUID_OUNCES = "Fluid Ounces";
    public static final String PINTS = "Pints";
    public static final String QUARTS = "Quarts";
    public static final String GALLONS = "Gallons";

    private static String[] unitList = {FEET, INCHES, YARDS, MILES, OUNCES, POUNDS, TONS, FLUID_OUNCES,
            PINTS, QUARTS, GALLONS};

    /**
     * Checks whether a given String is a valid imperial unit recognized by the ImperialUnits class
     * @param str The String to be checked
     * @return Returns true if the unit String is a constant in the ImperialUnits class, false if not
     */
    public static boolean isAValidImperialUnit(String str) {
        for (String s : unitList) {
            if (s.equals(str)) {
                return true;
            }
        }

        return false;
    }
}
