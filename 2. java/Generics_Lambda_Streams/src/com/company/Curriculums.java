package com.company;

public class Curriculums implements IDocumentos {
    private String persona;
    private String listaHabilidades;

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getListaHabilidades() {
        return listaHabilidades;
    }

    public void setListaHabilidades(String listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }
    @Override
    public void imprimir(){
        System.out.println("Curriculums{" +
                "persona='" + persona + '\'' +
                ", listaHabilidades='" + listaHabilidades + '\'' +
                '}');
    }
}
