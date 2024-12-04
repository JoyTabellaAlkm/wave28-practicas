package ejercitacionTardeJavaDia2;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones();

        //int resultadoCociente = practica.calcularCociente(); //Esto da error que no se puede dividir por 0.

        try{
            practica.calcularCociente();
        } catch (ArithmeticException e){ //Con Illegal no deja, por jerarquia es primero Arithmetic
            System.out.println("Se ha producido un error." + e.getMessage());
        } finally{
            System.out.println("Programa finalizado");
        }

        //Parte 2
        List<Producto> listaProductos = new ArrayList<Producto>();

        listaProductos.add(new Perecedero("Leche",120, 3));
        listaProductos.add(new Perecedero("Jamon",4000, 2));
        listaProductos.add(new Perecedero("Queso",423, 1));
        listaProductos.add(new Perecedero("Leche",3213, 4));
        listaProductos.add(new Perecedero("Yogurt",1230, 5));

        listaProductos.add(new NoPerecedero("",1200, "Legumbres"));
        listaProductos.add(new NoPerecedero("Chocapic",1200, "Cereales"));
        listaProductos.add(new NoPerecedero("Trix",1200, "Cereales"));
        listaProductos.add(new NoPerecedero("Porotos",1200, "Legumbres"));
        listaProductos.add(new NoPerecedero("Fideos",1200, "Conserva"));


    

    }
}
