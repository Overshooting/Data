package Tools.Conversions.ConversionTypes;

import DataHolders.DataPoint;

import java.util.ArrayList;

/**
 * This is an abstract class meant to create the backbone for different unit converters and facilitate smooth operation of the UnitConverter class
 *
 * @version 1.0.0
 *
 */

public abstract class ConversionType {

    private String tag;

    /**
     * Returns tag
     * @return Returns the tag identifier of the ConversionType
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets the ConversionType's tag
     * @param str The new tag identifier for the ConversionType
     */
    public void setTag(String str) {
        tag = str;
    }

    /**
     * Placeholder convert method
     * @param d The DataPoint to be converted
     * @param u The new unit for d to be converted to
     * @return Returns a new DataPoint with null units and a measure of 0
     */
    public DataPoint convert(DataPoint d, String u) {
        return new DataPoint(null, 0);
    }

    /**
     * Returns the ConversionType's ArrayList of conversion Strings
     * @return Returns null
     */
    public ArrayList<String> getUnitStrings() {
        return null;
    }
}
