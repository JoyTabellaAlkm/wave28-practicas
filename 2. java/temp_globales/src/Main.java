import java.util.Vector;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vector<String> ciudades = new Vector<>();
        cargar_ciudades(ciudades);

        int[][] temperaturas = new int[2][10];
        int COLUMNA_MINIMOS = 0;
        int COLUMNA_MAXIMOS = 1;
        temperaturas[COLUMNA_MINIMOS] = new int[]{-2, -3, -8, 4, 6, 5, 0, -7, -1, -10};
        temperaturas[COLUMNA_MAXIMOS] = new int[]{33, 32, 27, 27, 42, 43, 39, 26, 31, 35};


        System.out.println(temperaturas[0][0]);

        int minimo = temperaturas[COLUMNA_MINIMOS][0];
        int idx_minimo = 0;
        for (int i = 0; i < temperaturas[COLUMNA_MINIMOS].length; i++) {
            if (temperaturas[COLUMNA_MINIMOS][i] < minimo) {
                minimo = temperaturas[COLUMNA_MINIMOS][i];
                idx_minimo = i;
            }
        }

        int maximo = temperaturas[COLUMNA_MAXIMOS][0];
        int idx_maximo = 0;
        for (int i = 0; i < temperaturas[COLUMNA_MAXIMOS].length; i++) {
            if (temperaturas[COLUMNA_MAXIMOS][i] > maximo) {
                maximo = temperaturas[COLUMNA_MAXIMOS][i];
                idx_maximo = i;
            }
        }

        System.out.println("Temperatura minima: " + minimo + " en " + ciudades.get(idx_minimo));
        System.out.println("Temperatura maxima: " + maximo + " en " + ciudades.get(idx_maximo));
    }

    public static void cargar_ciudades(Vector<String> ciudades) {
        ciudades.add("Londres");
        ciudades.add("Madrid");
        ciudades.add("Nueva York");
        ciudades.add("Buenos Aires");
        ciudades.add("Asuncion");
        ciudades.add("Sao Paulo");
        ciudades.add("Lima");
        ciudades.add("Santiago de Chile");
        ciudades.add("Lisboa");
        ciudades.add("Tokio");
    }
}

