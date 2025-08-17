package Tools;

import DataHolders.DataPoint;
import DataHolders.DescribedDataPoint;
import DataHolders.DescribedDataSet;
import java.util.ArrayList;
import java.util.Scanner;

public class DescribedDataSetConstructor {

    private ArrayList<DataPoint> dataList;

    public DescribedDataSetConstructor() {
        dataList = new ArrayList<DataPoint>();

        Scanner scan = new Scanner(System.in);
        System.out.println("\nSubmit a dataset in the format: 'Independent variable, Dependent variable, Independent units, Dependent units' || etc || etc ||\n");
        String str = scan.nextLine();

        ArrayList<String> tokens = new ArrayList<String>();
        while (str.contains("||")) {
            tokens.add(str.substring(0, str.indexOf("||") - 1));

            str = str.substring(str.indexOf("||") + 2);
        }

        for (int i = 1; i < tokens.size(); i++) {
            tokens.set(i, tokens.get(i).substring(1));
        }

        for (String string : tokens) {
            double ind = Double.parseDouble(string.substring(0, string.indexOf(",")));
            string = string.substring(string.indexOf(",")+1);
            double dep = Double.parseDouble(string.substring(0, string.indexOf(",")));
            string = string.substring(string.indexOf(",")+1);
            String iunits = string.substring(0, string.indexOf(","));
            string = string.substring(string.indexOf(",")+1);
            String dunits = string;

            dataList.add(new DescribedDataPoint(iunits, dunits, ind, dep));
        }
    }

    public DescribedDataSet createDataSet() {
        return new DescribedDataSet(dataList);
    }

}
