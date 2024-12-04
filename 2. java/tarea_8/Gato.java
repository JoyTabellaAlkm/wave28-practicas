package tarea_8;

import tarea_8.interfaces.*;

public class Gato extends Animal implements Carnivoro {
  
  @Override 
  public void sonido(){
    System.out.println("Miauuuuuuuuuuuuuuuuu");;
  }
  @Override
  public String comerCarne(){
    return "Rico rico";
  }
}
