//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35},
        };
        int valMin, valMax, indexMin = 0, indexMax = 0;
        valMin = temperaturas[0][0];
        valMax = temperaturas[0][1];
        for(int c = 0; c < 10; c++){
            if (temperaturas[c][0] < valMin){
                valMin = temperaturas[c][0];
                indexMin = c;
            }
            if (temperaturas[c][1] > valMax){
                valMax = temperaturas[c][1];
                indexMax = c;
            }
        }
        System.out.println("La menor temperatura la tuvo " + ciudades[indexMin] + ", "+ valMin + "º C.");
        System.out.println("La mayor temperatura la tuvo " + ciudades[indexMax] + ", " + valMax + "º C.");
    }
}