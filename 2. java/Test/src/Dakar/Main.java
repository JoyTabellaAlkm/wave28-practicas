package Dakar;

public class Main {
    public static void main(String[] args) {

        Carrera carrera1 = new Carrera(1200,10000,"Qatar",4);
        carrera1.darDeAltaAuto(200,10,5,"ASD123");
        carrera1.darDeAltaAuto(250,15,10,"DSA456");
        carrera1.darDeAltaMoto(150,20,9,"FGH567");
        carrera1.darDeAltaMoto(200,25,4,"JKL980");
        carrera1.darDeAltaAuto(300,100,20,"ZXC135");

        carrera1.definirGanador();

        System.out.println("Elimino Vehiculo ganador");
        carrera1.eliminarVehiculoConPatente("JKL980");


        carrera1.darDeAltaMoto(200,25,4,"ZXC135");

        System.out.println("Nuevo ganador");
        carrera1.definirGanador();


        carrera1.socorrerAuto("ASD123");
        carrera1.socorrerMoto("FGH567");

    }
}
