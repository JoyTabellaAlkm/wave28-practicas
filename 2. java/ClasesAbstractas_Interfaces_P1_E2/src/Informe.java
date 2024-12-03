public class Informe implements Imprimible {
    String texto;
    String autor;
    String revisor;
    Integer paginas;

    public Informe(String texto, String autor, String revisor, Integer paginas) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", paginas=" + paginas +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
