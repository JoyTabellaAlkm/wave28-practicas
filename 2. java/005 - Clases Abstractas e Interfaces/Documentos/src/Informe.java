import Interfaces.IDocumento;

import java.util.List;

public class Informe implements IDocumento {
    private String autor;
    private int noPaginas;

    public Informe(String autor, int noPaginas) {
        this.autor = autor;
        this.noPaginas = noPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNoPaginas() {
        return noPaginas;
    }

    public void setNoPaginas(int noPaginas) {
        this.noPaginas = noPaginas;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe: ");
        System.out.println("Nombre Autor: "+autor);
        System.out.println("No Paginas: "+noPaginas);

        }

}
