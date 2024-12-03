//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
             String[] ciudades = {"Londres", "Madrid", "New York", "Buenos Aires", "Asunción del Paraguay", "São Paulo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperaturas = {
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

        //Busca minimo y maximo de las temperaturas y los nombres de las ciudades
        int minTemp = 100;
        int maxTemp = -100;
        String ciudadMin = "";
        String ciudadMax = "";

        for (int f = 0; f < temperaturas.length; f++) {
            for (int c = 0; c < temperaturas[f].length; c++) {
                if (temperaturas[f][c] < minTemp) {
                    minTemp = temperaturas[f][c];
                    ciudadMin = ciudades[f];
                }
                if (temperaturas[f][c] > maxTemp) {
                    maxTemp = temperaturas[f][c];
                    ciudadMax = ciudades[f];
                }
            }
        }
        System.out.println("La temperatura minima fue " + minTemp + " de la ciudad " + ciudadMin);
        System.out.println("La temperatura maxima fue " + maxTemp + " de la ciudad " + ciudadMax);

    }
}