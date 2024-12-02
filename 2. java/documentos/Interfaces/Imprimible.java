package Interfaces;

public interface Imprimible {

    static void imprimir(String name, String content){
        System.out.println("""
                Nombre del documento: %s
                Contenido: %s""".formatted(name, content));
    }
}
