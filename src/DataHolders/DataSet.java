package DataHolders;

import Tools.Calculator;

import java.util.*;

public class DataSet {

    private ArrayList<DataPoint> dataList;
    private String units;

    // Constructs a DataHolders.DataSet to contain str unit types of DataPoints
    public DataSet(String str) {
        dataList = new ArrayList<DataPoint>();
        units = str;
    }

    //Constructs a DataHolders.DataSet matching the parameter ArrayList of DataHolders.DataPoint objects
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
            System.out.println("Provide non-empty array");
        }
    }

    //Returns the DataHolders.DataSet as an array string
    public String toString() {
        String str = "";

        for (DataPoint d : dataList) {
            str += d + ",\n";
        }

        str = str.substring(0, str.length()-1);
        return str;
    }

    //Sorts the DataHolders.DataSet in ascending order
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

    //Returns a DataHolders.DataPoint representing the median value of the DataHolders.DataSet
    public DataPoint getMedian() {
        return Calculator.getMedian(dataList);
    }

    //Returns a DataHolders.DataPoint representing the mean value of the DataHolders.DataSet
    public DataPoint getMean() {
        return Calculator.getMean(dataList);
    }

    //Returns a DataHolders.DataPoint representing the mode value of the DataHolders.DataSet
    public DataPoint getMode() {
        return Calculator.getMedian(dataList);
    }

    //Returns true if the DataHolders.DataSet has been sorted, false if not
    public boolean isSorted() {
        for (int i = 0; i < dataList.size()-1; i++) {
            if (dataList.get(i).getMeasurement() > dataList.get(i+1).getMeasurement()) {
                return false;
            }
        }

        return true;
    }

    //Rounds all the DataPoints in the DataHolders.DataSet to the number of parameter decimal places
    public void roundAll(int p) {
        for (DataPoint d : dataList) {
            d.round(p);
        }
    }

    //Adds a single DataHolders.DataPoint to the DataHolders.DataSet, sorts the DataHolders.DataSet depending on the parameter boolean
    public void addDataPoint(DataPoint d, boolean b) {
        if (units.length() > 0) {
            if (d.getUnit().equals(units)) {
                dataList.add(d);
                if (b) {
                    sortAscendingMeasurements();
                }
            } else {
                System.out.println("!!Could not add DataHolders.DataPoint |" + d + "| due to unit mismatch!!");
                throw new IllegalArgumentException();
            }
        } else {
            System.out.println("!!Specify unit type before adding DataPoints!!");
            throw new IllegalArgumentException();
        }
    }


    //Removes the first instance of a Datapoint containing a measurement of parameter d and returns it
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

    public String getUnits() {
        return units;
    }
    
    public ArrayList<DataPoint> getDataList() {
        return dataList;
    }
}
