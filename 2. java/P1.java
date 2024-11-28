public class P1 {
    public static void main(String[] args) {
        int temperaturaMin = 0, temperaturaMaxima = 0;
        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de chile", "Lisboa", "Tokio"};

        int temperaturas [][]={{-2, 33},{-3, 32}, {-8, 27}, {4, 37}, {6,42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10,35}};

        for (int i = 0; i < temperaturas.length; i++){

            if( temperaturas[temperaturaMin][0] > temperaturas[i][0]){
                temperaturaMin = i;
            }

            if( temperaturas[temperaturaMaxima][1] < temperaturas[i][1]){
                temperaturaMaxima = i;
            }
        }

        System.out.println("La ciudad con la menor temperatura reportada fue " + ciudades[temperaturaMin]+ " con una temperatura de " + temperaturas[temperaturaMin][0] +" grados"
                + " y la ciudad con la mayor temperatura reportada fue " + ciudades[temperaturaMaxima] + " con una temperatura de " + temperaturas[temperaturaMaxima][1] + " grados");
    }
}
