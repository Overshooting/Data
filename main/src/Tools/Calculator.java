package Tools;

import DataHolders.DataSet;
import DataHolders.DataPoint;

import java.util.ArrayList;

/**
 * This class is meant to be used for basic statistical analysis of DataPoint ArrayLists, such as those found in DataSets
 *
 * version 1.0.0
 *
 */

public class Calculator {

    /**
     * Finds the median value of a DataPoint ArrayList
     * @param dataList The ArrayList to be used in the calculation
     * @return Returns a DataPoint representing the DataPoint with the median value of the DataPoint ArrayList
     */
    public static DataPoint getMedian(ArrayList<DataPoint> dataList) {
        int middle = dataList.size() / 2;

        if (middle % 2 == 0) {
            return new DataPoint(dataList.get(0).getUnit(), (dataList.get(middle).getMeasurement() + dataList.get(middle-1).getMeasurement())/2);
        } else {
            return new DataPoint(dataList.get(0).getUnit(), dataList.get(middle).getMeasurement());
        }
    }

    /**
     * Finds the mean value of a DataPoint ArrayList
     * @param dataList The ArrayList to be used in the calculation
     * @return Returns a DataPoint representing the DataPoint with the mean value of the DataPoint ArrayList
     */
    public static DataPoint getMean(ArrayList<DataPoint> dataList) {
        double sum = 0;
        int count = 0;
        for (DataPoint d : dataList) {
            sum += d.getMeasurement();
            count++;
        }
        return new DataPoint(dataList.get(0).getUnit(), sum / count);
    }

    /**
     * Finds the mode value of a DataPoint ArrayList
     * @param dataList The ArrayList to be used in the calculation
     * @return Returns a DataPoint representing the DataPoint with the mode value of the DataPoint ArrayList
     */
    public DataPoint getMode(ArrayList<DataPoint> dataList) {
        double num = 0;
        double measure = Double.MIN_VALUE;

        for (int i = 0; i < dataList.size(); i++) {
            int tempnum = 0;

            double comp = dataList.get(i).getMeasurement();
            for (int k = 0; k < dataList.size(); k++) {
                if (dataList.get(k).getMeasurement() == comp) {
                    tempnum++;
                }
                if (tempnum > num) {
                    num = tempnum;
                    measure = dataList.get(k).getMeasurement();
                }
            }
        }

        return new DataPoint(dataList.get(0).getUnit(), measure);
    }

    /**
     * Finds the standard deviation of the mean of a DataSet
     * @param dataList The ArrayList to be used in the calculation
     * @return Returns the standard deviation of the mean of a given DataPoint ArrayList as a double value, returns MIN_VALUE if the DataPoint ArrayList is empty
     */
    public static double strdDeviation(ArrayList<DataPoint> dataList) {
        if (dataList.size() > 0) {
            double mean = getMean(dataList).getMeasurement();
            int index = 0;
            double sum = 0;

            double[] ndataset = new double[dataList.size()];
            index = 0;
            for (DataPoint d : dataList) {
                ndataset[index] = Math.pow((d.getMeasurement() - mean), 2);
                index++;
            }
            for (double d : ndataset) {
                sum += d;
            }

            return Math.sqrt(sum / dataList.size());
        }
        else return Double.MIN_VALUE;
    }

}
