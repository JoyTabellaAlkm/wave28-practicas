public interface IImprimible {
    static void imprimir(IImprimible documento){
        System.out.println(documento.obtenerContenido());
    }

    String obtenerContenido();
}
