import DataHolders.DataPoint;
import DataHolders.DescribedDataPoint;
import DataHolders.DescribedDataSet;
import Tools.DescribedDataSetConstructor;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DescribedDataSetConstructor d = new DescribedDataSetConstructor();

        DescribedDataSet dataSet = d.createDataSet();
        System.out.println("\nHere is your dataset:\n" + dataSet);

        dataSet.sortAscendingIndependents();
        System.out.println("\nHere is your sorted dataset:\n" + dataSet);
    }

}
