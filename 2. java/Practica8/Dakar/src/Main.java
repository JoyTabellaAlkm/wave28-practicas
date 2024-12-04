import Classes.*;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(100, 2000, "Carrera de dios", 10);

        carrera.darDeAltaAuto(200, 10, 30, "FCS221");
        carrera.darDeAltaAuto(220, 13, 12, "HSN211");
        carrera.darDeAltaAuto(180, 12, 19, "JMR526");
        carrera.darDeAltaAuto(240, 11, 40, "VYR213");
        carrera.darDeAltaAuto(210, 15, 30, "MAJ819");
        carrera.darDeAltaMoto(220, 13, 20, "HSM029");
        carrera.darDeAltaMoto(250, 15, 16, "MKL992");
        carrera.darDeAltaMoto(200, 15, 15, "HAM819");
        carrera.darDeAltaMoto(215, 12, 30, "JAR145");
        carrera.darDeAltaMoto(250, 15, 25, "NAR019");
        carrera.darDeAltaMoto(212, 13, 30, "BNM819");
        carrera.eliminarVehiculoConPatente("NAR019");
        carrera.darDeAltaMoto(180, 15, 60, "LMK990");

        carrera.socorrerMoto("HAM819");
        carrera.socorrerAuto("MAJ819");

        System.out.println("El auto ganador es: " + carrera.defineGanador().getPatente());

    }
}