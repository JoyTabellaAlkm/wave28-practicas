public class Main {
    public static void main(String[] args) {
        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion","Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int temperaturas[][] =
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

        int minTemperatura = temperaturas[0][0];
        int maxTemperatura = temperaturas[0][1];
        String ciudadMinTemperatura = "";
        String ciudadMaxTemperatura = "";

        for (int i = 0; i < temperaturas.length; i++) {
            if (minTemperatura > temperaturas[i][0]) {
                minTemperatura = temperaturas[i][0];
                ciudadMinTemperatura = ciudades[i];
            }
            if (maxTemperatura < temperaturas[i][1]) {
                maxTemperatura = temperaturas[i][1];
                ciudadMaxTemperatura = ciudades[i];
            }
        }
        System.out.println("La ciudad " + ciudadMaxTemperatura + " tiene la maxima temperatura de " + maxTemperatura);
        System.out.println("La ciudad " + ciudadMinTemperatura + " tiene la minima temperatura de " + minTemperatura);
    }
}