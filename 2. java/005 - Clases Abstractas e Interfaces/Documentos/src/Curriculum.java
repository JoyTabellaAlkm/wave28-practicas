import Interfaces.IDocumento;

import java.util.List;

public class Curriculum implements IDocumento {
    private String nombrePersona;
    public List<String> habilidades;

    public Curriculum(String nombrePersona, List<String> habilidades) {
        this.nombrePersona = nombrePersona;
        this.habilidades = habilidades;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum: ");
        System.out.println("Nombre: "+nombrePersona);
        System.out.println("Habilidades: ");
        habilidades.forEach(habilidad -> System.out.println(habilidad));
        }

}
