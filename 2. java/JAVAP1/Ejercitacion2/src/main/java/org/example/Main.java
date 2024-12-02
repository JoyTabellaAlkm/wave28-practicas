package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {






    public static void main(String[] args) {

        HashMap<String,String> categorias = new HashMap<>();
        categorias.put("1","2 km por selva y arroyos");
        categorias.put("2","5 km por selva, arroyos y barro");
        categorias.put("3","10 km por selva, arroyos, barro y escalada en piedra.");

        List<HashMap<String,String>> inscripciones = new ArrayList<>();

        inscribir(inscripciones, categorias,"43543443", "Juan", 16, "3");
        inscribir(inscripciones, categorias,"43633332", "Pedro", 26, "2");
        inscribir(inscripciones, categorias,"34563333", "Manuel", 36, "1");



       for (HashMap<String,String> inscripcion : inscripciones) {
           if (inscripcion.get("categoriaID").equals("2")); {
               System.out.println(inscripcion.get("categoriaID"));
               System.out.println(inscripcion);


           }

       }


    }

    public static void inscribir(List<HashMap<String,String>> inscripciones, HashMap<String,String> categorias, String dni, String nombre, int edad, String categoriaID){

        double monto = calcularMonto(categoriaID, edad);

        if (monto == -1){
            System.out.println("El participante " + nombre + " no puede participar en la categoria " + categorias.get(categoriaID) + " por ser menor");
            return;
        }

        HashMap<String,String> inscripcion = new HashMap<>();

        inscripcion.put("nombre",nombre);
        inscripcion.put("dni",dni);
        inscripcion.put("edad",String.valueOf(edad));
        inscripcion.put("monto",String.valueOf(monto));
        inscripcion.put("categoriaID",categoriaID);

        inscripciones.add(inscripcion);



    }


    public static double calcularMonto(String categoriaID, int edad){
        switch (categoriaID) {
            case "1":
                return edad < 18 ? 1300 : 1500;
            case "2":
                return edad < 18 ? 2000 : 2300;
            case "3":
                return edad >= 18 ? 2000 : -1;
            default:
                return 0;
        }
    }

}