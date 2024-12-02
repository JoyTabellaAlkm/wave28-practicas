package org.example;

public interface Imprimible {


     static void imprimir(Documento documento){
          System.out.println("Imprimiendo" + documento.toString());
     };

}
