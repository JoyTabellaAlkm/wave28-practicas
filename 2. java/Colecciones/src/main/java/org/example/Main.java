package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // LISTA ARRAYLIST
        System.out.println("***** COLECCION -> LISTAS");
        System.out.println("ArrayList:");
        List<String> listaNombres = new ArrayList<>();

        listaNombres.add("Juan");
        listaNombres.add(0,"ASD");
        listaNombres.add("Pedro");
        listaNombres.add("Maria");



        for (String nombres : listaNombres) {
            System.out.println(nombres);
        }

        listaNombres.remove(0); // remueve el elemento en la posicion 0
        listaNombres.remove("Juan"); // remueve el elemento Juan

        System.out.println("Como queda la lista despues de los remove:");
        for (String nombres : listaNombres) {
            System.out.println(nombres);
        }

        //LINKEDLIST

        System.out.println("LinkedList:");
        List<Integer> listaNumeros = new LinkedList<>();

        listaNumeros.add(100);
        listaNumeros.add(200);
        listaNumeros.add(300);
        listaNumeros.add(2,400);
        listaNumeros.addFirst(500);

        for (Integer numeros : listaNumeros) {
            System.out.println(numeros);
        }

        System.out.println("Conocer el tamaño de una lista: " + listaNumeros.size());

        // MAPAS
        System.out.println("***** COLECCION -> MAPAS O DICCIONARIOS");
        Map<String, String> traductor = new HashMap<>();

        //Agregar elementos

        traductor.put("dog", "perro");
        traductor.put("cat", "gato");
        traductor.put("bird", "pajaro");
        traductor.put("fish", "pez");

        //Recorrer mapas

        for (Map.Entry<String, String> entrada : traductor.entrySet()) {
            System.out.println("Ingles: "+ entrada.getKey() + " Español: " + entrada.getValue());
        }

        for ( String entradaClave : traductor.keySet()) {
            System.out.println("Ingles: "+ entradaClave);
        }

        for ( String entradaValor : traductor.values()) {
            System.out.println("Español: "+ entradaValor);
        }

        String palabra = traductor.get("cat");
        System.out.println(palabra);
        traductor.remove("fish");

        for ( String entradaClave : traductor.keySet()) {
            System.out.println("Ingles: "+ entradaClave);
        }

        /// MANEJO DE MEMORIA EN JAVA
        // direcciones de memoria en HEAP (no consecutivas)
        System.out.println("**** MANEJO DE MEMORIA EN JAVA");
        Integer a = new Integer(1000);
        Integer b = new Integer(1000);

        // ¿a y b son iguales? Veamos que sucede cuando comparamos con los siguientes comparadores
        if (a == b) {
            System.out.println("a y b son iguales con ==");
        } else {
            System.out.println("a y b no son iguales con ==");
        }

        // Usando equals (ya sobrescrito en Integer)
        if (a.equals(b)) {
            System.out.println("a y b son iguales con equals");
        } else {
            System.out.println("a y b no son iguales con equals");
        }

        // porción de Memoria JAVA String.pool
        // Atención al detalle de no inicializar el objeto String con NEW
        String nom = "Juan";
        String nom2 = "Juan";

        // ¿nom y nom2 son iguales? Veamos que sucede cuando comparamos con los siguientes comparadores
        if (nom == nom2) {
            System.out.println("nom y nom2 son iguales con ==");
        } else {
            System.out.println("nom y nom2 no son iguales con ==");
        }

        // Porción de Memoria JAVA HEAP
        // Ahora si inicializo el objeto String con NEW
        String nombre3 = new String("Juan");
        String nombre4 = new String("Juan");

        // ¿nom y nom2 son iguales? Veamos que sucede cuando comparamos con los siguientes comparadores
        if (nombre3 == nombre4) {
            System.out.println("nombre3 y nombre4 son iguales con ==");
        } else {
            System.out.println("nombre3 y nombre4 no son iguales con ==");
        }

        if (nombre3.equals(nombre4)) {
            System.out.println("nombre3 y nombre4 son iguales con equals");
        } else {
            System.out.println("nombre3 y nombre4 no son iguales con equals");
        }


        // En este caso no estoy inicializando con new la clase wrapper Integer, porque el valor esta entre el rango de -127 y 128 (con 128 ya no funciona, probalo ;) )
        // direcciones de memoria alojadas en Integer.cache
        Integer c = 127;
        Integer d = 127;
        // ¿c y d son iguales? Veamos que sucede cuando comparamos con los siguientes comparadores
        if (c == d) {
            System.out.println("c y d son iguales con ==");
        } else {
            System.out.println("c y d no son iguales con ==");
        }

        // tipo de dato primitivo, se guarda su valor directamente en el Stack de la porcion de memoria que usa JAVA
        int e = 10000;
        int f = 10000;
        // ¿e y f son iguales? Veamos que sucede cuando comparamos con los siguientes comparadores
        if (e == f) {
            System.out.println("e y f son iguales con ==");
        } else {
            System.out.println("e y f no son iguales con ==");
        }


    }
}