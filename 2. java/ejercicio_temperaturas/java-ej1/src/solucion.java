public class solucion {
    public static void main(String[] args) {

        String[] ciudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int[][] temperaturas = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35},
        };

        int posMenor=0;
        int posMayor=0;
        for(int i=1; i<10; i++) {
            if (temperaturas[i][0] < temperaturas[posMenor][0]) {
                posMenor = i;
            }
            if (temperaturas[i][1] > temperaturas[posMayor][1]) {
                posMayor = i;
            }
        }

        System.out.println(String.format("Ciudad menor temperatura: %s -> %d", ciudades[posMenor], temperaturas[posMenor][0]));
        System.out.println(String.format("Ciudad mayor temperatura: %s -> %d", ciudades[posMayor], temperaturas[posMayor][1]));

    }
}
