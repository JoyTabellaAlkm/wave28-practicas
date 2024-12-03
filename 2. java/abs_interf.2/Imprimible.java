public interface Imprimible {
        String obtenerContenido();
        
        static void imprimir(Imprimible documento) {
            System.out.println(documento.obtenerContenido());
        }
}
