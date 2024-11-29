package com.company;

public class Main {

    public static void main(String[] args) {

        //region Ejercicio Practico #1

        //Mensaje final
       /* String mensajeFinal = "Este es el último mensaje";

        //Código que arroja excepción
        try{
            int[] numeros = new int[5];
            numeros[5] = 10;
        }catch (ArrayIndexOutOfBoundsException exception){
            System.out.println(exception.getMessage());
        }finally {
            System.out.println(mensajeFinal);
        }*/

        //endregion

        //region Ejercicio Practico #2
        /*Animal perro = new Perro("Perro","Tita");
        perro.mostrarEspecie();
        perro.hacerSonido();

        Animal gato = new Gato("Gato","Tita");
        gato.mostrarEspecie();
        gato.hacerSonido();

        Animal animal = perro;
        animal.mostrarEspecie();
        animal.hacerSonido();*/
        //endregion

        //region Ejercicio VIVO 1

        PracticaExcepciones pe = new PracticaExcepciones();
        pe.calcularCociente1();
        pe.calcularCociente2();

        //endregion
    }
}
