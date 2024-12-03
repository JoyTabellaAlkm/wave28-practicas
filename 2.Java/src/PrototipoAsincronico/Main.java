package PrototipoAsincronico;

public class Main {

    public static void main(String[] arg){
        Clase1 clase= new Clase1();
        System.out.println("--------Primero------");
        clase.valorSiguiente(2);
        clase.valorSiguiente(2);
        clase.valorSiguiente(2);

        System.out.println("--------segundo------");
        clase.reiniciarSerie();
        clase.valorSiguiente(1);
        clase.valorSiguiente(1);
        clase.valorSiguiente(1);

        System.out.println("--------tercero------");
        clase.reiniciarSerie();
        clase.valorSiguiente(3);
        clase.valorSiguiente(3);
        clase.valorSiguiente(3);

    }
}
