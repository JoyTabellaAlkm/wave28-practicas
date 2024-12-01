package Ejercicio1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        String ciudades[]= new String[10];

        ciudades[0]="Londres";
        ciudades[1]="Madrid";
        ciudades[2]="Nueva York";
        ciudades[3]="Buenos Aires";
        ciudades[4]="Asunción";
        ciudades[5]="Sao Paulo";
        ciudades[6]="Lima";
        ciudades[7]="Santiago de chile";
        ciudades[8]="Lisboa";
        ciudades[9]="Tokio";

        int temperatura[][]= new int[10][2];

        temperatura[0][0]= -2;
        temperatura[0][1]= 33;
        temperatura[1][0]= -3;
        temperatura[1][1]= 32;
        temperatura[2][0]= -8;
        temperatura[2][1]= 27;
        temperatura[3][0]= 4;
        temperatura[3][1]= 37;
        temperatura[4][0]= 6;
        temperatura[4][1]= 42;
        temperatura[5][0]= 5;
        temperatura[5][1]= 43;
        temperatura[6][0]= 0;
        temperatura[6][1]= 39;
        temperatura[7][0]= -7;
        temperatura[7][1]= 26;
        temperatura[8][0]= -1;
        temperatura[8][1]= 31;
        temperatura[9][0]= -10;
        temperatura[9][1]= 35;

        int tempMenor= temperatura[0][0];
        int tempMayor= temperatura[0][1];
        String ciudadMenor= ciudades[0];
        String ciudadMayor= ciudades[0];


        for(int i = 0; i < temperatura.length; i++) {
            if(temperatura[i][0]<tempMenor) {
                ciudadMenor= ciudades[i];
                tempMenor= temperatura[i][0];
            }
            if(tempMayor < temperatura[i][1]) {
                ciudadMayor= ciudades[i];
                tempMayor= temperatura[i][1];
            }

        }

        System.out.println("La menor temperatura es " + ciudadMenor +" con temperatura de "
                + tempMenor);

        System.out.println("La mayor temperatura es " + ciudadMayor +" con temperatura de "
                + tempMayor);
    }
}