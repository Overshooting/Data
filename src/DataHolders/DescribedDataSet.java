package DataHolders;

import java.util.ArrayList;

public class DescribedDataSet{

    private ArrayList<DescribedDataPoint> dataList;
    private String iunits, dunits;

    public DescribedDataSet(ArrayList<DescribedDataPoint> d) {
        dataList = d;
        iunits = d.get(0).getIndependent().getUnit();
        dunits = d.get(0).getDependent().getUnit();
    }

    public DescribedDataSet(String str, String string) {
        iunits = str;
        dunits = string;
    }

    // Sorts the DescribedDataSet in ascending order by independent DataPoints
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

    // Sorts the DescribedDataSet in ascending order by dependent DataPoints
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

    // Sorts the DescribedDataSet in descending order by independent DataPoints
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

    // Sorts the DescribedDataSet in descending order by dependent DataPoints
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

    // Adds a new DescribedDataPoint to the DescribedDataSet
    public void addDataPoint(DescribedDataPoint d) {
        if (d.getIndependent().getUnit().equals(iunits) && d.getDependent().getUnit().equals(dunits)) {
            dataList.add(d);
        } else {
            throw new IllegalArgumentException("Unit Mismatch!");
        }
    }

    public String toString() {
        String str = "";

        for (DescribedDataPoint d : dataList) {
            str += d + ",\n";
        }

        str = str.substring(0, str.length()-1);
        return str;
    }

    public ArrayList<DescribedDataPoint> getDataList() {
        return dataList;
    }
}
