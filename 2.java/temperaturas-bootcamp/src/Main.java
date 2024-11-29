class Main {
    public static void main(String[] args) {
        String[] ciudades = new String[10];

        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "São Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";


        int menorIndex = 0;
        int mayorIndex = 0;

        int menorVal = temperatures[0][0];
        int mayorVal = temperatures[0][1];

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i][0] < menorVal) {
                menorVal = temperatures[i][0];
                menorIndex = i;
            }
            if (temperatures[i][1] > mayorVal) {
                mayorVal = temperatures[i][1];
                mayorIndex = i;
            }
        }

        System.out.println("La menor tempertura se registró en: " + ciudades[menorIndex] + " : " + menorVal);
        System.out.println("La menor tempertura se registró en: " + ciudades[mayorIndex] + " : " + mayorVal);
    }
}