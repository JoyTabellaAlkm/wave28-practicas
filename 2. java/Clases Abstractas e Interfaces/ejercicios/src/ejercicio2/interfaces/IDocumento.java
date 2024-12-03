package ejercicio2.interfaces;

public interface IDocumento {
    static void imprimirDocumento(IDocumento documento) {
        documento.imprimir();
    }

    void imprimir();
}
