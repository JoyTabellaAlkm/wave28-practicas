package practica_documentos.src.meli.practica.models;
import practica_documentos.src.meli.practica.Imprimible;

public abstract class Documento implements Imprimible {

    @Override
    public void imprimir() {
        System.out.println("Este es un documento");
    }

}
