
//Un portal de noticias tiene registrados datos de las diferentes temperaturas que
// obtuvieron algunas ciudades del mundo durante el año pasado; a partir de estos registros,
// pudieron determinar la más baja y la más alta para cada una de las ciudades. Por ejemplo,
// se determinó que para Londres, la mínima fue de -2º C y la máxima de 33º C. Sin embargo,
// actualmente necesitan armar una noticia en donde especifiquen cuál es la temperatura
// máxima que hubo entre todas las ciudades registradas y cuál fue la mínima.
// Para ello cuentan con un vector con los nombres de cada una de las ciudades
// y una matriz de dos columnas que especifican su temperatura máxima y mínima,
// los cuales se especifican a continuación:
//Sabiendo que cada índice de fila representa a una ciudad.
// Se necesita conocer la mayor y la menor temperatura
// ntre todas las ciudades; al mismo tiempo se deberá
// especificar el nombre de la ciudad. Por ejemplo,
// la menor temperatura la tuvo Tokio, con -10 º C.


import java.util.Scanner;
public class EjercicioJavaAvanzado {

    public static void main(String[] args) {
        String[] ciudades = new String[5];
        double[][] temperatura = new double[5][2];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < ciudades.length; i++) {
            System.out.println("Ingresar el nombre de la ciudad:");
            ciudades[i] = scanner.nextLine();
            System.out.print("Ingrese la temperatura mínima: ");
            temperatura[i][0] = scanner.nextDouble();
            scanner.nextLine(); // Consume el salto de línea
            System.out.print("Ingrese la temperatura máxima: ");
            temperatura[i][1] = scanner.nextDouble();
            scanner.nextLine(); // Consume el salto de línea
            System.out.println("Ingresar el nombre de la ciudad:" + (i + 1));

        }

        int indiceMin = 0;
        int indiceMax = 0;
        double tempMin = temperatura[0][0];
        double tempMax = temperatura[0][1];

        for (int j = 1; j < ciudades.length; j++) {
            if (temperatura[j][0] < tempMin) {
                tempMin = temperatura[j][0];
                indiceMin = j;
            }
            if (temperatura[j][1] > tempMax) {
                tempMax = temperatura[j][1];
                indiceMax = j;
            }
        }

// Imprimir resultados
        System.out.println("La ciudad con la temperatura mínima es: " + ciudades[indiceMin] + " (" + tempMin + "°C)");
        System.out.println("La ciudad con la temperatura máxima es: " + ciudades[indiceMax] + " (" + tempMax + "°C)");

    }
}