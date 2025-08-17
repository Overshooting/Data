package DataHolders;

import java.util.ArrayList;

public class DescribedDataSet extends DataSet{

    private String iunits;

    public DescribedDataSet(String str, ArrayList<DataPoint> d) {
        super(str, d);
    }

    public DescribedDataSet(String str, String string) {
        super(string);

        iunits = str;
    }

    public DescribedDataSet(ArrayList<DataPoint> dataList) {
            super(dataList.get(0).getUnit(), dataList);
            iunits = ((DescribedDataPoint)dataList.get(0)).getIndependentUnits();
    }

    public void sortAscendingIndependents() {
        ArrayList<DataPoint> dataList = super.getDataList();

        for (int i = 0; i < dataList.size(); i++) {
            for (int k = i+1; k < dataList.size(); k++) {
                if (((DescribedDataPoint)dataList.get(k)).getIndependent() <= ((DescribedDataPoint)dataList.get(i)).getIndependent()) {
                    DataPoint tmp = dataList.get(k);
                    dataList.set(k, dataList.get(i));
                    dataList.set(i,tmp);
                }
            }
        }
    }
}
