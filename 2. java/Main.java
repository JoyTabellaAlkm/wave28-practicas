//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int vector[];
        String[] cities = new String[10];
        cities[0] = "Londres";
        cities[1] = "Madrid";
        cities[2] = "Nueva York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asunción";
        cities[5] = "Sao Paulo";
        cities[6] = "Lima";
        cities[7] = "Santiago de Chile";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";

        int[][] temperatures = new int[10][2];
        temperatures[0][0] = -2;
        temperatures[0][1] = 33;
        temperatures[1][0] = -3;
        temperatures[1][1] = 32;
        temperatures[2][0] = -8;
        temperatures[2][1] = 27;
        temperatures[3][0] = 4;
        temperatures[3][1] = 37;
        temperatures[4][0] = 6;
        temperatures[4][1] = 42;
        temperatures[5][0] = 5;
        temperatures[5][1] = 43;
        temperatures[6][0] = 0;
        temperatures[6][1] = 39;
        temperatures[7][0] = -7;
        temperatures[7][1] = 26;
        temperatures[8][0] = -1;
        temperatures[8][1] = 31;
        temperatures[9][0] = -10;
        temperatures[9][1] = 35;

        String[] results = getMinMax(cities, temperatures);

        System.out.println("La menor temperatura la tuvo " + results[0]);
        System.out.println("La mayor temperatura la tuvo " + results[1]);

    }

    public static String[] getMinMax(String[] cities, int[][] temperatures) {

        int minTemp = temperatures[0][0];
        int maxTemp = temperatures[0][1];
        String cityMin = cities[0] + ", con " + minTemp + "°C";
        String cityMax = cities[0] + ", con " + maxTemp + "°C";

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i][0] < minTemp) {
                minTemp = temperatures[i][0];
                cityMin = cities[i] + ", con " + minTemp + "°C";
            }
            if (temperatures[i][1] > maxTemp) {
                maxTemp = temperatures[i][1];
                cityMax = cities[i] + ", con " + maxTemp + "°C";
            }
        }

        return new String[]{cityMin, cityMax};
    }
}