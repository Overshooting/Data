package Tools.Conversions.ConversionTypes;

import DataHolders.DataPoint;

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
}
