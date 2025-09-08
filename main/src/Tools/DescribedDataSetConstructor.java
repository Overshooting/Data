package Tools;

import DataHolders.DataPoint;
import DataHolders.DescribedDataPoint;
import DataHolders.DescribedDataSet;
import Tools.Units.ImperialUnits;
import Tools.Units.MetricUnits;

import java.util.ArrayList;
import java.util.Scanner;

public class DescribedDataSetConstructor {

    private ArrayList<DescribedDataPoint> dataList;

    public DescribedDataSetConstructor() {
        dataList = new ArrayList<DescribedDataPoint>();

        Scanner scan = new Scanner(System.in);
        System.out.println("\nSubmit a dataset in the format: 'Independent variable, Dependent variable, Independent units, Dependent units' || etc || etc ||\n");
        String str = scan.nextLine();

        //Splices each individual "token" of the string into its own String, stored in the tokens ArrayList
        ArrayList<String> tokens = new ArrayList<String>();
        while (str.contains("||")) {
            tokens.add(str.substring(0, str.indexOf("||") - 1));

            str = str.substring(str.indexOf("||") + 2);
        }

        // Gets rid of extra space in each token
        for (int i = 1; i < tokens.size(); i++) {
            tokens.set(i, tokens.get(i).substring(1));
        }

        // Creates independent and dependent units and values from each token
        for (String string : tokens) {
            double ind = Double.parseDouble(string.substring(0, string.indexOf(",")));
            string = string.substring(string.indexOf(",")+1);
            double dep = Double.parseDouble(string.substring(0, string.indexOf(",")));
            string = string.substring(string.indexOf(",")+1);
            String iunits = string.substring(0, string.indexOf(","));
            string = string.substring(string.indexOf(",")+1);
            String dunits = string;

            if ((ImperialUnits.isAValidImperialUnit(iunits) || MetricUnits.isAValidMetricUnit(iunits)) && (ImperialUnits.isAValidImperialUnit(dunits) || MetricUnits.isAValidMetricUnit(dunits))) {
                dataList.add(new DescribedDataPoint(new DataPoint(iunits, ind), new DataPoint(dunits, dep)));
            } else {
                throw new IllegalArgumentException("Invalid units!");
            }
        }
    }

    public DescribedDataSet createDataSet() {
        return new DescribedDataSet(dataList);
    }

}
