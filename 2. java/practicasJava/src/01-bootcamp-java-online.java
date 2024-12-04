import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int temperaturas[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35},};
        int tempMin = temperaturas[0][0];
        int tempMax = temperaturas[0][1];
        int indiceMin = 0;
        int indiceMax = 0;
        for (int fila = 0; fila < ciudades.length; fila++) {
            if (temperaturas[fila][0] < tempMin) {
                tempMin = temperaturas[fila][0];
                indiceMin = fila;
            }
            if (temperaturas[fila][1] > tempMax) {
                tempMax = temperaturas[fila][1];
                indiceMax = fila;
            }
        }

        System.out.println("La menor temperatura la tuvo " + ciudades[indiceMin] + ", con " + tempMin + "°C");
        System.out.println("La mayor temperatura la tuvo " + ciudades[indiceMax] + ", con " + tempMax + "°C");
        //Por ejemplo, la menor temperatura la tuvo Tokio, con -10 º C.
    }
}