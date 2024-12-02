public class Informe extends Documento{

    private String texto;
    private String revisor;

    public Informe(String autor, int cantpaginas, String texto, String revisor) {
        super(autor, cantpaginas);
        this.texto = texto;
        this.revisor = revisor;
    }

    @Override
    public String getTipo() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String ToString() {
        return "Informe de " + getAutor() + "\n"+
                "Texto: " + texto + "\n"+
                "Paginas: " + getCantpaginas() + "\n"+
                "Revsor: " + revisor;
    }
}
