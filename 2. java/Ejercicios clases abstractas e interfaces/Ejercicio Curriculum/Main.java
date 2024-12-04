package org.example;

import org.example.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        List<IImprimible> listaDeDocumentos= new ArrayList<>();

        Curriculum cv1 = new Curriculum(new Persona("Lucas", "Bianchi"), List.of("Java", "Go"));
        LibroPdf libro1 = new LibroPdf(2, "Ryan Holiday","Stoic everyday", "filosofia");
        Informes informe1 = new Informes( new Texto(2,2,"Joe Dispenza", "Messi"));

        listaDeDocumentos.add(cv1);
        listaDeDocumentos.add(libro1);
        listaDeDocumentos.add(informe1);

        listaDeDocumentos.stream().forEach(e -> System.out.println(e.imprimir()));





    }
}