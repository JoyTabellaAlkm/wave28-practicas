package practica_dakar.src.meli.practica.models;

public class Main {

    public static void main(String[] args) {

        Carrera carrera = new Carrera(40, 500, "Carrera MeLi", 2 );

        carrera.darDeAltaAuto(50, 30, 30, "Ford");
        carrera.darDeAltaAuto(20, 10, 10, "Ford");

        System.out.println("El ganador de esta carrera es:");
        System.out.println(carrera.definirGanador());

    }
}
