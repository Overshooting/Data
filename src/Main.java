import DataHolders.DataPoint;
import Tools.Graph;
import Tools.UnitConverter;

public class Main {

    public static void main(String[] args) {
        DataPoint d = new DataPoint("Kilograms", 1);

        System.out.println(UnitConverter.convert(d, "Tons", UnitConverter.IMPERIAL_TO_METRIC));
    }

}
