package DataHolders;

import Tools.Calculator;

import java.util.*;

/**
 * This class holds lists of DataPoints and contains options for sorting and analyzing them
 *
 * @version 1.0.0
 *
 */

public class DataSet {

    private ArrayList<DataPoint> dataList;
    private String units;

    /**
     * Creates a DataSet to contain str unit types of DataPoints
     * @param str The units of the DataSet
     */
    public DataSet(String str) {
        dataList = new ArrayList<DataPoint>();
        units = str;
    }

    /**
     * Creates a DataSet matching the parameter ArrayList of DataPoint objects
     * @param str Unit type of the DataSet
     * @param d Input ArrayList for the DataSet
     * @throws IllegalArgumentException Throws an IllegalArgumentException if d is empty or if the units of the DataPoints in d and str don't match
     */
    public DataSet(String str, ArrayList<DataPoint> d) {
        dataList = new ArrayList<DataPoint>();

        if (d.size() > 0) {
            units = str;
            for (DataPoint dp : d) {
                if (dp.getUnit().equals(units)) {
                    dataList.add(dp);
                } else {
                    System.out.println("!!Unit mismatch among input array!!");
                    throw new IllegalArgumentException();
                }
            }
        } else {
            throw new IllegalArgumentException("Provide a non empty ArrayList!");
        }
    }

    /**
     * Returns the DataSet as an array string
     * @return Returns a formatted String containing each DataPoint in the DataSet
     */
    public String toString() {
        String str = "";

        for (DataPoint d : dataList) {
            str += d + ",\n";
        }

        str = str.substring(0, str.length()-1);
        return str;
    }

    /**
     * Sorts the DataSet in ascending order
     */
    public void sortAscendingMeasurements() {
        for (int i = 0; i < dataList.size(); i++) {
            for (int k = i+1; k < dataList.size(); k++) {
                if (dataList.get(k).getMeasurement() <= dataList.get(i).getMeasurement()) {
                    DataPoint tmp = dataList.get(k);
                    dataList.set(k, dataList.get(i));
                    dataList.set(i,tmp);
                }
            }
        }
    }

    /**
     * Returns the median value of the DataSet
     * @return Returns a DataPoint representing the median value of the DataSet
     */
    public DataPoint getMedian() {
        if (isSortedAscending()) {
            return Calculator.getMedian(dataList);
        } else {
            throw new IllegalArgumentException("Sort dataset first!");
        }
    }

    /**
     * Returns the mean value of the DataSet
     * @return Returns a DataPoint representing the mean value of the DataSet
     */
    public DataPoint getMean() {
        return Calculator.getMean(dataList);
    }

    /**
     * Returns the mode value of the DataSet
     * @return Returns a DataPoint representing the mode value of the DataSet
     */
    public DataPoint getMode() {
        return Calculator.getMedian(dataList);
    }

    /**
     * Returns a boolean representing whether the DataSet has been sorted in ascending order
     * @return Returns true if the DataSet has been sorted in ascending order of measurements, false if not
     */
    public boolean isSortedAscending() {
        for (int i = 0; i < dataList.size()-1; i++) {
            if (dataList.get(i).getMeasurement() > dataList.get(i+1).getMeasurement()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Rounds all the DataPoints in the DataSet to the given number of decimal places
     * @param p The number of decimal places to round each DataPoint's measurement to
     */
    public void roundAll(int p) {
        for (DataPoint d : dataList) {
            d.round(p);
        }
    }

    /**
     * Adds a DataPoint to the end of the DataSet, then sorts DataSet in ascending order based on b
     * @param d The DataPoint to add to the DataSet
     * @param b Sorts the DataSet in ascending order if true, does nothing if false
     * @throws IllegalArgumentException Throws an IllegalArgumentException if unit types do not match between the DataSet and given DataPoint,
     */
    public void addDataPoint(DataPoint d, boolean b) {
        if (d.getUnit().equals(units)) {
            dataList.add(d);
            if (b) {
                sortAscendingMeasurements();
            }
        } else {
            throw new IllegalArgumentException("Unit Mismatch!");
        }
    }


    /**
     * Removes the first instance of a DataPoint containing a measurement matching d and returns it
     * @param d The measurement that will be searched for
     * @return Returns the removed DataPoint if it is found, returns null if the DataPoint is not found
     */
    public DataPoint removeFirstInstance(double d) {
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).getMeasurement() == d) {
                DataPoint tmp = dataList.get(i);
                dataList.remove(i);
                return tmp;
            }
        }
        return null;
    }

    /**
     * Returns units
     * @return Returns the unit type of the DataSet
     */
    public String getUnits() {
        return units;
    }

    /**
     * Returns dataList
     * @return Returns the DataSet's ArrayList of DataPoints
     */
    public ArrayList<DataPoint> getDataList() {
        return dataList;
    }
}
