import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] cities = {
                "London",
                "Madrid",
                "New York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokyo"
        };

        int[][] temperatures = {
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35}
        };

        int highTemp = getHighestTemperature(temperatures);
        int lowTemp = getLowestTemperature(temperatures);

        System.out.println("CITY WITH HIGHEST TEMP: " + cities[highTemp]);
        System.out.println("CITY WITH LOWEST TEMP: " + cities[lowTemp]);


    }

    private static int getHighestTemperature(int[][] toCheck){
        int maxVal = toCheck[0][1];
        int maxValPos = 0;
        for (int i=0; i < toCheck.length; i++) {
            if (maxVal < toCheck[i][1]){
                maxVal = toCheck[i][1];
                maxValPos = i;
            }
        }
        return maxValPos;
    }

    private static int getLowestTemperature(int[][] toCheck){
        int minVal = toCheck[0][0];
        int minValPos = 0;
        for (int i=0; i < toCheck.length; i++) {
            if (minVal > toCheck[i][0]){
                minVal = toCheck[i][0];
                minValPos = i;
            }
        }
        return minValPos;
    }
}