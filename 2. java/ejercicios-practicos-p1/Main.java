public class Main {
    public static void main(String [] args) {

        String ciudades[] = {"Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"};

        int temperaturas[][] ={{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        String paisMayorTemperatura = ciudades[0];
        String paisMenorTemperatura = ciudades[0];
        int mayorTemperatura = temperaturas[0][0];
        int menorTemperatura = temperaturas[0][0];
        

        for (int i = 0; i< temperaturas.length; i++){
            if (temperaturas[i][1]> mayorTemperatura){
                mayorTemperatura = temperaturas[i][1];
                paisMayorTemperatura = ciudades[i];
            }
           if (temperaturas[i][0] < menorTemperatura){
                menorTemperatura = temperaturas[i][0];
                paisMenorTemperatura = ciudades[i];
            }

        }

        System.out.println("La MAYOR temp. la tuvo: " + paisMayorTemperatura + ", con " + mayorTemperatura+"°");
        System.out.println("La MENOR temp. la tuvo: " + paisMenorTemperatura + ", con " + menorTemperatura+"°");
    }
}
