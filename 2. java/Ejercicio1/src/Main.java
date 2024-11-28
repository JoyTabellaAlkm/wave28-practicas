//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> places = Arrays.asList("Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio");

        int[][] temperatures = { {-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35},};
        int highestTemperature[] = {Integer.MIN_VALUE, 0};
        int lowestTemperature[] = {Integer.MAX_VALUE, 0};
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 10; j++){
                highestTemperature= (highestTemperature[0] > temperatures[j][i]) ? highestTemperature : new int[]{temperatures[j][i], j};
                lowestTemperature= (lowestTemperature[0] < temperatures[j][i]) ? lowestTemperature : new int[]{temperatures[j][i], j};
            }
        }
        System.out.println("La menor temperatura: " + lowestTemperature[0] + " En la ciudad de " + places.get(lowestTemperature[1]));
        System.out.println("La menor temperatura: " + highestTemperature[0] + " En la ciudad de " + places.get(highestTemperature[1]));
    }
}