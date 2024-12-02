public class Main {
    public static void main(String[] args) {
        // Creo Vector de ciudades y Matriz de temperaturas por ciudad
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temps = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        // Creo e inicializo variables para almacenar las temperaturas maxima y minima y sus respectivos indices
        int tempMax, tempMin, indiceMax, indiceMin;
        tempMax = tempMin = temps[0][0];
        indiceMax = indiceMin = 0;

        // Recorro la matriz de temperaturas para buscar la temperatura maxima y minima y sus respectivos indices
        for (int i = 0; i < temps.length; i++) {
            for (int j = 0; j < temps[i].length; j++) {
                if (j == 0) {
                    if (temps[i][j] < tempMin) {
                        tempMin = temps[i][j];
                        indiceMin = i;
                    }
                } else {
                    if (temps[i][j] > tempMax) {
                        tempMax = temps[i][j];
                        indiceMax = i;
                    }
                }
            }
        }

        // Muestro por consola la ciudad con la temperatura mas baja y la ciudad con la temperatura mas alta
        System.out.println("La ciudad con la temperatura mas baja es: " + ciudades[indiceMin] + " con " + tempMin + "° C");
        System.out.println("La ciudad con la temperatura mas alta es: " + ciudades[indiceMax] + " con " + tempMax + "° C");
    }
}