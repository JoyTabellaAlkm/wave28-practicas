package ejercicio2;

public interface IImpresorDocumento {
    static void imprimir(Documento documento) {
        System.out.println(documento.toString());
    };
}
