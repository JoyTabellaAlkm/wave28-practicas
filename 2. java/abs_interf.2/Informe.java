

    public class Informe implements Imprimible {
        private String texto;
        private String autor;
        private String revisor;
        private int cantidadPaginas;
    
        // Constructor
        public Informe(String texto, String autor, String revisor, int cantidadPaginas) {
            this.texto = texto;
            this.autor = autor;
            this.revisor = revisor;
            this.cantidadPaginas = cantidadPaginas;
        }
    
        // Implementación del método obtenerContenido
        @Override
        public String obtenerContenido() {
            return "Informe:\nTexto: " + texto +
                   "\nAutor: " + autor +
                   "\nRevisor: " + revisor +
                   "\nPáginas: " + cantidadPaginas;
        }
    }
