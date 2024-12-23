import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("SAVE THE ROPA!");

        GuardaRopa unGuardaRopa = new GuardaRopa();

        Prenda prenda = new Prenda("ADIDAS", "UltraBoost");
        Prenda prenda2 = new Prenda("Nike", "AirForce");

        // CREAMOS UNA LISTA DE PRUEBA
        List<Prenda> prendasEdu = Arrays.asList(prenda,
                new Prenda("ADIDAS", "Messi"),
                new Prenda("Nike", "CR7"),
                new Prenda("Puma", "Bolt"));

        // CREAMOS OTRA LISTA DE PRUEBA
        List<Prenda> prendasJoy = new ArrayList<>();
        prendasJoy.add(prenda);
        prendasJoy.add(prenda2);


        /** PUNTO 1 - GUARDAR PRENDAS **/

        Integer keyPrendaGuardada = unGuardaRopa.guardarPrendas(prendasEdu);
        Integer keyPrendaGuardada2 = unGuardaRopa.guardarPrendas(prendasJoy);
        System.out.println("1) El identificador asignado para este conjunto de prendas es: " + keyPrendaGuardada );


        /** PUNTO 2 - MOSTRAR PRENDAS **/
        System.out.println("2) El guardarropas tiene las siguientes prendas: ");
        // Una forma
        unGuardaRopa.mostrarPrendas();
        // Otra forma
        unGuardaRopa.mostrarPrendas2();

        /** PUNTO 3 - DEVOLVER PRENDAS **/
        System.out.println("3) Prendas devueltas:");
        List<Prenda> prendasADevolver = unGuardaRopa.devolverPrendas(keyPrendaGuardada);
        //Lista<Prenda> prendasADevolver = unGuardaRopa.devolverPrendas(0); // Otra forma
        System.out.println(prendasADevolver);

        /** PUNTO 4 - MOSTRAR PRENDAS DESPUES DE DEVOLVER LAS PRENDAS DE EDU**/
        System.out.println("4) Comprobamos como quedo el guardarropa despues de devolver las prendas del Nº id = 0 (Edu): ");
        unGuardaRopa.mostrarPrendas();

        //System.out.println(unGuardaRopa.getDiccionario());
    }
}
