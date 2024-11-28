public class Main {
    public static void main(String[] args) {
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatures = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        int maxTemperature = 0;
        int minTemperature = 0;

        int indexCityMaxTemperature = 0;
        int indexCityMinTemperature = 0;

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i][1] > maxTemperature) {
                maxTemperature = temperatures[i][1];
                indexCityMaxTemperature = i;
            }
            if (temperatures[i][0] < minTemperature) {
                minTemperature = temperatures[i][0];
                indexCityMinTemperature = i;
            }
        }

        System.out.println("La menor temperatura la tuvo " + cities[indexCityMinTemperature] + " con " + minTemperature + " º C");
        System.out.println("La mayor temperatura la tuvo " + cities[indexCityMaxTemperature] + " con " + maxTemperature + " º C");
    }


}


