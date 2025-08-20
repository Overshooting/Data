import DataHolders.DataPoint;
import Tools.UnitConverter;

public class Main {

    public static void main(String[] args) {

        System.out.println(UnitConverter.convert(new DataPoint("Tons", 1), "Pounds", "IMP"));

    }

}
