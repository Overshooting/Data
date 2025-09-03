package Tools;

import DataHolders.DataSet;
import DataHolders.DataPoint;

import java.util.ArrayList;

public class Calculator {

    public static DataPoint getMedian(ArrayList<DataPoint> dataList) {
        int middle = dataList.size() / 2;

        if (middle % 2 == 0) {
            return new DataPoint(dataList.get(0).getUnit(), (dataList.get(middle).getMeasurement() + dataList.get(middle-1).getMeasurement())/2);
        } else {
            return new DataPoint(dataList.get(0).getUnit(), dataList.get(middle).getMeasurement());
        }
    }

    public static DataPoint getMean(ArrayList<DataPoint> dataList) {
        double sum = 0;
        int count = 0;
        for (DataPoint d : dataList) {
            sum += d.getMeasurement();
            count++;
        }
        return new DataPoint(dataList.get(0).getUnit(), sum / count);
    }

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


    public static double strdDeviation(DataSet dataset) {
        if (dataset.getDataList().size() > 0) {
            double mean = getMean(dataset.getDataList()).getMeasurement();
            int index = 0;
            double sum = 0;

            double[] ndataset = new double[dataset.getDataList().size()];
            index = 0;
            for (DataPoint d : dataset.getDataList()) {
                ndataset[index] = Math.pow((d.getMeasurement() - mean), 2);
                System.out.println("ADDING " + Math.pow((d.getMeasurement()-mean), 2) + " AT " + index);
                index++;
            }
            for (double d : ndataset) {
                sum += d;
                System.out.println("ADDING " + d + " TO " + sum);
            }

            return Math.sqrt(sum / dataset.getDataList().size());
        }
        else return Double.MIN_VALUE;
    }

}
