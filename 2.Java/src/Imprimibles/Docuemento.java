package Imprimibles;

public class Docuemento implements iImprimible{

    @Override
    public void imprimir(String documento) {  // Implementación de la interfaz
        System.out.println("Imprimiendo documento: " + documento);
    }

    @Override
    public void imprimirTipoDoc() {  // Implementación de la interfaz
        System.out.println("Tipo de documento: Documento");
    }


}
