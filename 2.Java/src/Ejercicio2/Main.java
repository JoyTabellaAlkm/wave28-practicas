package Ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Creo categorias
        List<String> Categoria1= new ArrayList<String>();
        Categoria1.add("1");
        Categoria1.add("Circuito chico");
        Categoria1.add("2 km por selva y arroyos");

        List<String> Categoria2 = new ArrayList<String>();
        Categoria2.add("2");
        Categoria2.add("Circuito medio");
        Categoria2.add("5 km por selva, arroyos y barro");

        List<String> Categoria3 = new ArrayList<String>();
        Categoria3.add("3");
        Categoria3.add("Circuito grande");
        Categoria3.add("10 km por selva, arroyos, barro y escalada en piedra.");

        //agrego categorias a un map Categorias
        Map<Integer, List<String> > Caterogorias= new HashMap<>();
        Caterogorias.put(1,Categoria1);
        Caterogorias.put(2,Categoria2);
        Caterogorias.put(3,Categoria3);
        // creo persona
        List<String> Persona1 = new ArrayList<String>();
        Persona1.add("1");
        Persona1.add("12345678");
        Persona1.add("Juana");
        Persona1.add("Perez");
        Persona1.add("15");
        Persona1.add("1512346575");
        Persona1.add("444444444");
        Persona1.add("A+");

        List<String> Persona2 = new ArrayList<String>();
        Persona2.add("2");
        Persona2.add("87654321");
        Persona2.add("Pepe");
        Persona2.add("Rodriguez");
        Persona2.add("25");
        Persona2.add("1512346575");
        Persona2.add("444444444");
        Persona2.add("A+");

        List<String> Persona3 = new ArrayList<String>();
        Persona3.add("3");
        Persona3.add("00000001");
        Persona3.add("Ana Claudia");
        Persona3.add("Fernandez");
        Persona3.add("22");
        Persona3.add("1512346575");
        Persona3.add("444444444");
        Persona3.add("A+");

        // impresion del precio segun la categoria y la edad de la persona
        List<String> valor = Caterogorias.get(1);
        int edadPersona= Integer.parseInt(Persona1.get(4));
        int precio;

        if (edadPersona<18){
            switch (Integer.parseInt(valor.get(0))) {
                case 1:
                    precio = 1000;
                    System.out.println(precio);
                    break;
                case 2:
                    precio = 2000;
                    System.out.println(precio);
                    break;
                default:
                    break;
            }
        }else if(edadPersona>=18){
            switch (Integer.parseInt(valor.get(0))) {
                case 1:
                    precio = 1500;
                    System.out.println(precio);
                    break;
                case 2:
                    precio = 2300;
                    System.out.println(precio);
                    break;
                case 3:
                    precio = 2800;
                    System.out.println(precio);
                    break;
                default:
                    break;
            }
        }

        Map< List<String>, List<String> > Inscripcion= new HashMap<>();
        Inscripcion.put(Persona1, Caterogorias.get(1));
        Inscripcion.put(Persona2, Caterogorias.get(2));
        Inscripcion.put(Persona3, Caterogorias.get(3));


        //System.out.println(Categoria1.get(1));
        //System.out.println(Categoria1.get(2));

        //nombreCategoria.put(0, "Circuito chico");
        //nombreCategoria.put(1, "Circuito medio");
        //nombreCategoria.put(2, "Circuito grande");

    }
}