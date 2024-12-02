package ejercicios.ejerciciosJava.ejercicio1;

public class Ejercicio1 {
    public static void main(String[] args) {
        String[] ciudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };
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
                {-10, 35},
        };
        int mayorTemperatura = Integer.MIN_VALUE;
        int menorTemperatura = Integer.MAX_VALUE;
        int indiceCiudadMenorTemperatura = 0;
        int indiceCiudadMayorTemperatura = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < menorTemperatura) {
                menorTemperatura = temperaturas[i][0];
                indiceCiudadMenorTemperatura = i;
            }
            if (temperaturas[i][1] > mayorTemperatura) {
                mayorTemperatura = temperaturas[i][1];
                indiceCiudadMayorTemperatura = i;
            }
        }
        System.out.println("Ciudad menor temperatura: " + ciudades[indiceCiudadMenorTemperatura] + " -> " + menorTemperatura + "°C");
        System.out.println("Ciudad mayor temperatura: " + ciudades[indiceCiudadMayorTemperatura] + " -> " + mayorTemperatura + "°C");
    }
}

