public class Informe implements IImprimible{
    private String texto;
    private int paginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int paginas, String autor, String revisor) {
        this.texto = texto;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String obtenerContenido() {
        return "Informe:\nTexto: " + texto + "\nPáginas: " + paginas + "\nAutor: " + autor + "\nRevisor: " + revisor;
    }
}
