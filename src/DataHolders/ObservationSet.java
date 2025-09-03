package DataHolders;

import java.util.ArrayList;

public class ObservationSet extends DataSet {

    public ObservationSet(String str) {
        super(str);
    }

    // Sorts the ObservationSet in ascending order depending on the time each Observation was taken
    public void sortAscendingChrono() {
        ArrayList<DataPoint> dataList = super.getDataList();

        for (int i = 0; i < dataList.size(); i++) {
            for (int k = i+1; k < dataList.size(); k++) {
                if (((Observation)(dataList.get(k))).compareTo((Observation)(dataList.get(i))) <= 0) {
                    DataPoint tmp = dataList.get(k);
                    dataList.set(k, dataList.get(i));
                    dataList.set(i,tmp);
                }
            }
        }
    }

    

}
