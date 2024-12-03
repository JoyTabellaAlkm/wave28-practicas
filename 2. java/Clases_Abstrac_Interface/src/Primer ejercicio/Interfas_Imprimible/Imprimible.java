public interface Imprimible {

    static void imprimirDocumento(Imprimible documento) {
        System.out.println("Contenido del documento: " + documento.toString());
    }
}