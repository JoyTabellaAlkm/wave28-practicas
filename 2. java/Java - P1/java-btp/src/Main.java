import java.util.Scanner;

public class Main {

    String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
    int[][] temperatures = new int[10][2];

    public static void main(String[] args) {
        Main main = new Main();

        main.fullTemperatures();

        for(int i = 0; i<2; i++){
            int temp = 0, city = 0;
            for(int j = 0; j<10; j++){
                if(i==0){
                    if(main.temperatures[j][i] < temp){
                        temp = main.temperatures[j][i];
                        city = j;
                    }
                }else{
                    if(main.temperatures[j][i] > temp){
                        temp = main.temperatures[j][i];
                        city = j;
                    }
                }
            }
            if(i==0){
                System.out.println("La temperatura menor es: "+ temp + ". En la ciudad de " + main.cities[city]);
            }else{
                System.out.println("La temperatura mayor es: "+ temp + ". En la ciudad de " + main.cities[city]);
            }
        }

    }

    public void fullTemperatures(){
        Scanner teclado = new Scanner(System.in);
        for(int i = 0; i<10; i++){
            System.out.print("Ingrese la temperatura menor de la ciudad "+cities[i]+":");
            temperatures[i][0] = teclado.nextInt();
            System.out.print("Ingrese la temperatura mayor de la ciudad "+cities[i]+":");
            temperatures[i][1] = teclado.nextInt();
        }
        teclado.close();
    }
}