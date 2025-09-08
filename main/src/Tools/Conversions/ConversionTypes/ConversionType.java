package Tools.Conversions.ConversionTypes;

import DataHolders.DataPoint;

import java.util.ArrayList;

// This is an abstract class meant to create the backbone for different unit converters
public abstract class ConversionType {

    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String str) {
        tag = str;
    }

    public DataPoint convert(DataPoint d, String u) {
        return new DataPoint(null, 0);
    }

    public ArrayList<String> getUnitStrings() {
        return null;
    }
}
