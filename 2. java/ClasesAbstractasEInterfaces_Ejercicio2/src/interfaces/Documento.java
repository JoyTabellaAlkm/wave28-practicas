package interfaces;

public interface Documento{
    default void imprimirDocumento(Documento d){
        System.out.println(d.toString());
    };
}
