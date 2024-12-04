package tarea_8;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Perro perro = new Perro(); 
    Gato gato = new Gato(); 
    Vaca vaca = new Vaca(); 

    perro.sonido();
    gato.sonido();
    vaca.sonido();


    perro.comerCarne();
    gato.comerCarne();
    vaca.comerPlanta();
  }
}
