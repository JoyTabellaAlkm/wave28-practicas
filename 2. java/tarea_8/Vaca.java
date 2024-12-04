package tarea_8;

import tarea_8.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro{
  @Override
  public void sonido(){
    System.out.println("Muuuuuuuuuu");
  }
  @Override
  public String comerPlanta(){
    return "Estoy a dieta";
  } 
}
