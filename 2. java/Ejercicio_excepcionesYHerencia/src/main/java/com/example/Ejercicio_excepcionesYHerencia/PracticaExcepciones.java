package com.example.Ejercicio_excepcionesYHerencia;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public PracticaExcepciones() {
    }

    public void calcularCociente1(){
        double res = 0;
        try{
            res= b/a;
        }catch (ArithmeticException e){
            System.out.println("1.Se ha producido un error");
        }finally {
            System.out.println("1.Programa finalizado");
        }
    }

    public void calcularCociente2(){
        double res = 0;
        try{
            res= b/a;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("2.No se puede dividir por cero!!");
        }finally {
            System.out.println("2.Programa finalizado");
        }
    }
}
