package ejercicio2.interfaces;

import ejercicio2.clases.Documento;

public interface IImpresorDocumento {
    static void imprimir(Documento documento) {
        System.out.println(documento.toString());
    };
}
