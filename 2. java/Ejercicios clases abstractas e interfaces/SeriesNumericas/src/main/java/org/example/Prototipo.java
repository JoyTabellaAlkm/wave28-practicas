package org.example;

import java.util.List;

public class Prototipo {

    private int primerNumero;
    private int numeroActual;

    private int salto;

    public int calcularSerieProgresiva(){

        if(numeroActual == 0){
            int nuevoValor ;
            nuevoValor =primerNumero+salto;
            setNumeroActual(nuevoValor);
            return nuevoValor;
        }else{
            int nuevoValor =numeroActual+salto;
            setNumeroActual(nuevoValor);
            return nuevoValor;
        }
    }

    public int valorSiguiente(){
        if(numeroActual == 0){
            int nuevoValor ;
            nuevoValor =primerNumero+2;
            setNumeroActual(nuevoValor);
            return nuevoValor;
        }else{
            int nuevoValor =numeroActual+2;
            setNumeroActual(nuevoValor);
            return nuevoValor;
        }
    }

    public int reinciarSerie(){
        setNumeroActual(primerNumero);
        return primerNumero;
    }

    public int reiniciarSerieConOtroValor(int valorNuevo){
        setPrimerNumero(valorNuevo);
        setNumeroActual(valorNuevo);
        return valorNuevo;
    }

    public int establecerValorInicial(){
        return 1;
    }

    public Prototipo(int primerNumero, int salto) {
        this.primerNumero = primerNumero;
        this.salto = salto;
    }


    public int getPrimerNumero() {
        return primerNumero;
    }

    public void setPrimerNumero(int primerNumero) {
        this.primerNumero = primerNumero;
    }

    public int getNumeroActual() {
        return numeroActual;
    }

    public void setNumeroActual(int numeroActual) {
        this.numeroActual = numeroActual;
    }

    public int getSalto() {
        return salto;
    }

    public void setSalto(int salto) {
        this.salto = salto;
    }
}
