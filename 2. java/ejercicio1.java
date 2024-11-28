public static void main(String[] args) {
        String[] cities = {
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

        //step2 temperatures
        int[][] temperatures = {
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

        String nameCityMinTemperatures = "";
        int minTemperatures = Integer.MAX_VALUE;

        String nameCityMaxTemperatures = "";
        int maxTemperatures = Integer.MIN_VALUE;

        for(int row = 0; row < temperatures.length; row++){
            for(int column = 0; column < temperatures[row].length; column++) {

                if(temperatures[row][column] < minTemperatures){
                    nameCityMinTemperatures = cities[row];
                    minTemperatures = temperatures[row][column];
                }

                if(temperatures[row][column] > maxTemperatures){
                    nameCityMaxTemperatures = cities[row];
                    maxTemperatures = temperatures[row][column];
                }
            }
        }

        System.out.println("La temperatura menor es " + nameCityMinTemperatures + " con " + minTemperatures + " °C");
        System.out.println("La temperatura mayor es " + nameCityMaxTemperatures + " con " + maxTemperatures + " °C");

    }
