import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de ciudades:");
        int citiesNumber = Integer.parseInt(console.nextLine());
        while(citiesNumber <=0){
            System.out.println("numero invalido, por favor ingrese otro valor:");
            citiesNumber = Integer.parseInt(console.nextLine());
        };
        String[] cities = new String[citiesNumber];
        int[][] temperatures = new int[citiesNumber][2];
        System.out.println("Ingresa los datos");
        for (int i = 0; i < cities.length; i++) {
            System.out.println("Ingresa la ciudad");
            String city = console.nextLine();
            cities[i] = city;
            System.out.println("Ingresa la temperatura minima:");
            int temperature = Integer.parseInt(console.nextLine());
            temperatures[i][0] = temperature;
            System.out.println("Ingresa la temperatura maxima:");
            temperature = Integer.parseInt(console.nextLine());
            temperatures[i][1] = temperature;
            System.out.println("--------------------------------------------");
        }
        int min = 0;
        int max = 0;
        for (int i = 0; i < citiesNumber; i++) {
            if (temperatures[i][0] < temperatures[min][0]) {
                min = i;
            }
            if (temperatures[i][1] > temperatures[max][1]) {
                max = i;
            }
        }

        System.out.println("La menor temperatura mínima la tuvo " + cities[min]
                + " con " + temperatures[min][0] + " °C.");
        System.out.println("La mayor temperatura máxima la tuvo " + cities[max]
                + " con " + temperatures[max][1] + " °C.");


    }
}