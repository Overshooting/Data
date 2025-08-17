package Tools;

import DataHolders.DataSet;
import DataHolders.DataPoint;

public class Calculator {

    public static double strdDeviation(DataSet dataset) {
        if (dataset.getDataList().size() > 0) {
            double mean = dataset.getMean().getMeasurement();
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
