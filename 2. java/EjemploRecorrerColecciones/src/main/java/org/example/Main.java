package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> Personas = new HashMap<>();
        Personas.put(1, "Juan");
        Personas.put(2, "María");
        Personas.put(3, "Carlos");
        Personas.put(4, "Ana");

        // Ejemplo 1: Con for clásico
        mostrarConFor(Personas);

        // Ejemplo 2: Con for-each
        mostrarConForEach(Personas);

        // Ejemplo 3: Con entrySet
        mostrarConEntrySet(Personas);

        // Ejemplo 4: Con stream()
        mostrarConStream(Personas);
    }

    // Métodos de ejemplo
    static void mostrarConFor(Map<Integer, String> mapa) {
        System.out.println("Usando for clásico:");
        for (Integer key : mapa.keySet()) {
            System.out.println("ID: " + key + " - Nombre: " + mapa.get(key));
        }
    }

    static void mostrarConForEach(Map<Integer, String> mapa) {
        System.out.println("\nUsando for-each:");
        mapa.forEach((key, value) -> System.out.println("ID: " + key + " - Nombre: " + value));
    }

    static void mostrarConEntrySet(Map<Integer, String> mapa) {
        System.out.println("\nUsando entrySet:");
        for (Map.Entry<Integer, String> entry : mapa.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " - Nombre: " + entry.getValue());
        }
    }

    static void mostrarConStream(Map<Integer, String> mapa) {
        System.out.println("\nUsando stream():");
        mapa.entrySet().stream()
                .forEach(entry -> System.out.println("ID: " + entry.getKey() + " - Nombre: " + entry.getValue()));
    }
}