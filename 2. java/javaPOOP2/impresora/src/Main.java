
/*Se plantea desarrollar un programa que permita mediante una interfaz imprimir diferentes tipos de documentos.

Entre los tipos de documentos se encuentran:


Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.
Libros en PDF: Incluyen atributos como cantidad de páginas, nombre del autor, título y género.
Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.

Representar un escenario donde se creen cada uno de estos objetos y que, por medio de un método e
stático de una interfaz imprimible, se pueda pasar cualquier tipo de documento y sea impreso el contenido.
        */

import java.util.HashMap;
import java.util.Map;

interface Impresora{
    void imprimir();
}
public class Main {
    public static void main(String[] args) {

        Map<String, Object> habilidades = new HashMap<>();
        habilidades.put("1", "Java");
        habilidades.put("1", "PHP");
        habilidades.put("1", "GO");
        habilidades.put("1", "JS");

        Impresora curriculum = new Curriculum("Maria", "19", "Desarrollador", habilidades);
        curriculum.imprimir();

        Impresora informes = new Informes(200, "Pepe", "Ana");
        informes.imprimir();

        Impresora libros = new Libros(10, "Pepe", "Drama");
        libros.imprimir();
    }
}