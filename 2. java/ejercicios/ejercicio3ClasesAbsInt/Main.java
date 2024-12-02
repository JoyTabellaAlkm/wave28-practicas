package ejercicios.ejercicio3ClasesAbsInt;

public class Main {
    public static void main(String[] args){
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        System.out.println(perro.comer());
        System.out.println(gato.comer());
        System.out.println(vaca.comer());

        System.out.println(perro.emitirSonido());

    }
}
