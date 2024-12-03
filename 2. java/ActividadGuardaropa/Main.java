import java.util.List;

public class Main {
    public static void main(String[] args) {

        Prenda pr1 = new Prenda("Adidas","Superstar");
        Prenda pr2 = new Prenda("Nike","Air force");


        Guardaropa guardaropa = new Guardaropa();

        int codigo = guardaropa.guardarPrendas(List.of(pr1,pr2));
        int codigo2 = guardaropa.guardarPrendas(List.of(pr1,pr2));

        guardaropa.mostrarPrendas();
        System.out.println("La prenda que te devolvemos tiene: ");

        System.out.println(guardaropa.devolverPrendas(codigo));

    }
}