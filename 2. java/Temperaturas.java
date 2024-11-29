import java.util.Scanner;

public class Temperaturas {
    public static void main(String[] args) {
        String[] paises = new String[10];
        int[][] temperaturasMinimasMaximas = new int[10][2];
        int tempMax = 0;
        String paisMaxTemp = "";
        int tempMin = 0;
        String paisMinTemp = "";

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < paises.length; i++) {
            System.out.println("Ingrese el nombre del pais para el indice " + i);
            paises[i] = input.nextLine();
            if (paises[i] == "") {
                paises[i] = input.nextLine();
            }                    System.out.println("Ingrese la temperatura minima para " + paises[i] + " : ");
                    temperaturasMinimasMaximas[i][0] = input.nextInt();
                    System.out.println("Ingrese la temperatura maxima para " + paises[i] + " : ");
                    temperaturasMinimasMaximas[i][1] = input.nextInt();

                   if(temperaturasMinimasMaximas[i][1]> tempMax){
                        tempMax = temperaturasMinimasMaximas[i][1];
                        paisMaxTemp = paises[i];
                   }
                    if(temperaturasMinimasMaximas[i][0] == 0){
                        tempMin = temperaturasMinimasMaximas[i][0];
                    } else if(temperaturasMinimasMaximas[i][0]< tempMin){
                        tempMin = temperaturasMinimasMaximas[i][0];
                        paisMinTemp = paises[i];
                    }
        }
        System.out.println("Temperatura minima " + tempMin + " pais " +paisMinTemp );
        System.out.println("Temperatura minima " + tempMax + " pais " +paisMaxTemp );
    }
}

