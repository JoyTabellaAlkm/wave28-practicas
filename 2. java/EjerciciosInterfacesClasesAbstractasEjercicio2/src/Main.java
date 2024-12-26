public class Main {
    public static void main(String[] args) {

        String[] habilidades = {"Java", "Python", "Ciberseguridad"};
        Curriculum curriculum = new Curriculum("Juan", "Pérez", "26283463", 123456789, habilidades);

        LibroPdf libro = new LibroPdf("El arte de la guerra", "Sun Tzu", "Estrategia", 300);

        Informe informe = new Informe("Este es el texto del informe.", 10, "Ana Gómez", "Luis Rodríguez");

        IImprimible.imprimir(curriculum);
        System.out.println("---------------------");
        IImprimible.imprimir(libro);
        System.out.println("---------------------");
        IImprimible.imprimir(informe);
    }
}