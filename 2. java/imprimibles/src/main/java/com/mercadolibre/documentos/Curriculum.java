package com.mercadolibre.documentos;

import java.util.List;

public class Curriculum extends Documento {

    private String nombrePersona;
    private String telefonoPersona;
    private String direccionPersona;
    private String resumen;
    private List<String> habilidades;

    public Curriculum(String nombrePersona, String telefonoPersona, String direccionPersona, String resumen,
            List<String> habilidades) {
        this.nombrePersona = nombrePersona;
        this.telefonoPersona = telefonoPersona;
        this.direccionPersona = direccionPersona;
        this.resumen = resumen;
        this.habilidades = habilidades;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo curriculum: " + toString());
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombrePersona='" + nombrePersona + '\'' +
                ", telefonoPersona='" + telefonoPersona + '\'' +
                ", direccionPersona='" + direccionPersona + '\'' +
                ", resumen='" + resumen + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }

}
