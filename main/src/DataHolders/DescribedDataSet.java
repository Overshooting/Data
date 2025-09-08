/**
 * This class holds lists of DescribedDataPoints for sorting and analyzing them
 *
 * @version 1.0.0
 *
 */

package DataHolders;

import java.util.ArrayList;

public class DescribedDataSet{

    private ArrayList<DescribedDataPoint> dataList;
    private String iunits, dunits;

    /**
     * Creates a DescribedDataSet matching the given ArrayList, with matching units
     * @param d Input Arraylist for the DescribedDataSet
     */
    public DescribedDataSet(ArrayList<DescribedDataPoint> d) {
        dataList = d;
        iunits = d.get(0).getIndependent().getUnit();
        dunits = d.get(0).getDependent().getUnit();
    }

    /**
     * Creates a DescribedDataSet with an empty dataList and matching independent and dependent units
     * @param ind The independent unit for the DescribedDataSet
     * @param dep The dependent unit for the DescribedDataSet
     */
    public DescribedDataSet(String ind, String dep) {
        iunits = ind;
        dunits = dep;
        dataList = new ArrayList<DescribedDataPoint>();
    }

    /**
     * Sorts the DescribedDataSet in ascending order by independent DataPoints
     */
    public void sortAscendingIndependents() {
        for (int i = 0; i < dataList.size(); i++) {
            for (int k = i+1; k < dataList.size(); k++) {
                if ((dataList.get(k)).getIndependent().getMeasurement() <= (dataList.get(i)).getIndependent().getMeasurement()) {
                    DescribedDataPoint tmp = dataList.get(k);
                    dataList.set(k, dataList.get(i));
                    dataList.set(i,tmp);
                }
            }
        }
    }

    /**
     * Sorts the DescribedDataSet in ascending order by dependent DataPoints
     */
    public void sortAscendingDependents() {
        for (int i = 0; i < dataList.size(); i++) {
            for (int k = i+1; k < dataList.size(); k++) {
                if ((dataList.get(k)).getDependent().getMeasurement() <= (dataList.get(i)).getDependent().getMeasurement()) {
                    DescribedDataPoint tmp = dataList.get(k);
                    dataList.set(k, dataList.get(i));
                    dataList.set(i,tmp);
                }
            }
        }
    }

    /**
     * Sorts the DescribedDataSet in descending order by independent DataPoints
     */
    public void sortDescendingIndependents() {
        for (int i = 0; i < dataList.size(); i++) {
            for (int k = i+1; k < dataList.size(); k++) {
                if ((dataList.get(k)).getDependent().getMeasurement() >= (dataList.get(i)).getDependent().getMeasurement()) {
                    DescribedDataPoint tmp = dataList.get(k);
                    dataList.set(k, dataList.get(i));
                    dataList.set(i,tmp);
                }
            }
        }
    }

    /**
     * Sorts the DescribedDataSet in descending order by dependent DataPoints
     */
    public void sortDescendingDependents() {
        for (int i = 0; i < dataList.size(); i++) {
            for (int k = i+1; k < dataList.size(); k++) {
                if ((dataList.get(k)).getDependent().getMeasurement() >= (dataList.get(i)).getDependent().getMeasurement()) {
                    DescribedDataPoint tmp = dataList.get(k);
                    dataList.set(k, dataList.get(i));
                    dataList.set(i,tmp);
                }
            }
        }
    }

    /**
     * Adds a DescribedDataPoint to the front of the DescribedDataSet
     * @param d The DescribedDataPoint to be added
     * @throws IllegalArgumentException Throws an IllegalArgumentException if the units of d and this do not match
     */
    public void addDataPoint(DescribedDataPoint d) {
        if (d.getIndependent().getUnit().equals(iunits) && d.getDependent().getUnit().equals(dunits)) {
            dataList.add(d);
        } else {
            throw new IllegalArgumentException("Unit Mismatch!");
        }
    }

    /**
     * Returns the DescribedDataSet as a String
     * @return Returns a formatted String containing all the DescribedDataPoints in this
     */
    public String toString() {
        String str = "";

        for (DescribedDataPoint d : dataList) {
            str += d + ",\n";
        }

        str = str.substring(0, str.length()-1);
        return str;
    }


    /**
     * Returns dataList
     * @return Returns the ArrayList of DescribedDataPoints in the DataSet
     */
    public ArrayList<DescribedDataPoint> getDataList() {
        return dataList;
    }
}
