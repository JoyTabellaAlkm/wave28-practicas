import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Prenda pr1 = new Prenda("Adidas","Superstar");
        Prenda pr2 = new Prenda("Nike","Air force");
        Guardaropa guardaropa = new Guardaropa();
        int codigo = guardaropa.guardarPrendas(List.of(pr1));
        int codigo2 = guardaropa.guardarPrendas(List.of(pr2));
        guardaropa.mostrarPrendas();
        System.out.println("Escoje el codigo de tu prenda para visualizar");
        Scanner sc = new Scanner(System.in);
        int cod = sc.nextInt();
        System.out.println("La prenda que te devolvemos tiene: ");
        System.out.println(guardaropa.devolverPrendas(cod));
    }
}