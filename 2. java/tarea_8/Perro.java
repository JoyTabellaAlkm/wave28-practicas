package tarea_8;

import tarea_8.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro{

  @Override
  public void sonido(){
    System.out.println("Guauuuuuu Guauuuuuuuuuuuu");
  }

  @Override
  public String comerCarne(){
    return "Guau guau, rico";
  }
  
}
