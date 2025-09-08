/**
 * This class is for DataSets meant specifically for Observation objects
 *
 * @version 1.0.0
 *
 */

package DataHolders;

import java.util.ArrayList;

public class ObservationSet extends DataSet {

    /**
     * Creates an ObservationSet with the given units
     * @param str The units for the ObservationSet
     */
    public ObservationSet(String str) {
        super(str);
    }

    /**
     *  Sorts the ObservationSet in ascending order from oldest to newest depending on when each Observation was recorded
     */
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
