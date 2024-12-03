package com.company;

public class Prototipo {

    protected Integer valor;
    Integer incremento;

    public Prototipo(Integer valor, Integer incremento) {
        this.valor = valor;
        this.incremento = incremento;
    }

    public Integer siguienteValor() {
        valor += incremento;
        return valor;
    }
    public void reiniciar(){
        valor = 0;
    }
    public void valorInicial(Integer inicial){
        this.valor = inicial;
    }

}
