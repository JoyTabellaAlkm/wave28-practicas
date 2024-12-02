
//Una empresa de paquetería desea realizar una actualización de los sueldos
// de sus empleados. Para ello, desean la creación de un programa que al
// asignar un dni y un monto determine si al empleado en cuestión le corresponde
// o no un aumento. Para ello tiene en cuenta las siguientes condiciones:

//a) Si el sueldo es menor o igual a $20.000 le corresponde un 20% de aumento.

//b) Si el sueldo es mayor a $20.000 pero menor o igual a $45.000 le corresponde un 10% de aumento.

//c) Si el sueldo es mayor a $45.000 le corresponde un 5% de aumento.

//Un programador comenzó con el planteo, pero necesita un poco de ayuda para determinar
//las condiciones para cada uno de los casos y qué acciones deberían hacerse... ¿Podrías ayudarlo a terminar?

import java.util.Scanner;
public class EjercicioPracticoJP2 {
public static void  main(String[] args) {

    Scanner scanner=new Scanner(System.in);

    System.out.println("Ingresar DNI del empleado");
    String dni=scanner.nextLine();
    System.out.println("Ingresar sueldo del empleado");
    double sueldo=scanner.nextDouble();
    double resultado;

    if(sueldo<=20000){

        resultado=sueldo+(sueldo*0.2);
    }else if (sueldo>20000 && sueldo<=45000){
            resultado= sueldo+(sueldo*0.1);

    }else{
      resultado=sueldo+(sueldo*0.05);

    }
    System.out.println("El sueldo actualizado es de:" + resultado);

    }


}



