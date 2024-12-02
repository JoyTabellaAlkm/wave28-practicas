package tarea_7;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Documento {
  public String nombre;
  public String experiencia;
  public String premios;
  public String publicaciones;
  public List<String> habilidades = new ArrayList<String>();

  @Override
  public void imprimir(){
    System.out.println("Nombre: " + nombre);
    System.out.println("Nombre: " + experiencia);
    System.out.println("Nombre: " + premios);
    System.out.println("Nombre: " + publicaciones);
    System.out.println("Habilidades: ");
    for(String i : habilidades){
      System.out.println(i);
    }
  }
}
