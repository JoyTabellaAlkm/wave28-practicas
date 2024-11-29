public class Main {
    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "New York", "Buenos Aires", "Asunción del Paraguay", "São Paulo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

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
                {-10, 35}
        };

        //Busca minimo y maximo de las temperaturas y los nombres de las ciudades
        int minTemp = 100;
        int maxTemp = -100;
        String ciudadMin = "";
        String ciudadMax = "";

        for (int f = 0; f < temperaturas.length; f++) {
            for (int c = 0; c < temperaturas[f].length; c++) {
                if (temperaturas[f][c] < minTemp) {
                    minTemp = temperaturas[f][c];
                    ciudadMin = ciudades[f];
                }
                if (temperaturas[f][c] > maxTemp) {
                    maxTemp = temperaturas[f][c];
                    ciudadMax = ciudades[f];
                }
            }
        }
        System.out.println("La temperatura minima fue " + minTemp + " de la ciudad " + ciudadMin);
        System.out.println("La temperatura maxima fue " + maxTemp + " de la ciudad " + ciudadMax);


        //P2
        double sueldoBase = 45000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        int veintePorcentajeAumento = 20;
        int diezPorcentajeAumento = 10;
        int cincoPorcentajeAumento = 5;

        int sueldoVeinteMil = 20000;
        int sueldoCuarentaycinco = 45000;

        if (sueldoBase <= sueldoVeinteMil) {

            sueldoConAumento = (sueldoBase * veintePorcentajeAumento / 100) + sueldoBase;
        }
        else {
            if (sueldoBase <= sueldoCuarentaycinco){
                sueldoConAumento = (sueldoBase * diezPorcentajeAumento / 100) + sueldoBase;
            }
            else {
                sueldoConAumento = (sueldoBase * cincoPorcentajeAumento / 100) + sueldoBase;

            }
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);




        int []serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;


        int servicioPratrullaje = 700;

        for (int i = 0; i < serviciosCli.length; i++) {
            totalFactura = 1500;
            if (serviciosCli[i] == 1) {
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura += servicioPratrullaje;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
        }

        //Categorias

        //mapa que tenga un array con inscriptos
        //1, Circuito chico, 2 km por selva y arroyos.
        HashMap<ArrayList<String>, ArrayList<Object>> categorias = new HashMap<>();


        //personas



    }
}