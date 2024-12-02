package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_2;

import java.util.List;

public class Curriculum implements Imprimible {
    private Persona persona;
    private List<String> listaDeHabilidades;

    public Curriculum(List<String> listaDeHabilidades, Persona persona) {
        this.listaDeHabilidades = listaDeHabilidades;
        this.persona = persona;
    }

    public List<String> getListaDeHabilidades() {
        return listaDeHabilidades;
    }

    public void setListaDeHabilidades(List<String> listaDeHabilidades) {
        this.listaDeHabilidades = listaDeHabilidades;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "listaDeHabilidades=" + listaDeHabilidades +
                ", persona=" + persona +
                '}';
    }
}
