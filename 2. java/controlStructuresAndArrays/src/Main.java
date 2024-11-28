public class Main {
    public static void main(String[] args) {
        String [] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion","Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int [][] temperatures =
                {
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

        int minTemperature = temperatures[0][0];
        int maxTemperature = temperatures[0][1];
        String cityMinTemperature = cities[0];
        String cityMaxTemperature = cities[0];

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i][0] < minTemperature) {
                minTemperature = temperatures[i][0];
                cityMinTemperature = cities[i];
            }
            if (temperatures[i][1] > maxTemperature) {
                maxTemperature = temperatures[i][1];
                cityMaxTemperature = cities[i];
            }
        }

        System.out.printf("La menor temperatura la tuvo %s con %d°C.\n", cityMinTemperature, minTemperature);
        System.out.printf("La mayor temperatura la tuvo %s con %d°C.", cityMaxTemperature, maxTemperature);

    }
}