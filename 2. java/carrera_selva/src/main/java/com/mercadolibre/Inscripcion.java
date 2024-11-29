package com.mercadolibre;

public class Inscripcion {

    private int numero;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(int numero, Categoria categoria, Participante participante, double monto) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = monto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

}
