package PrototipoAsincronico;

public class Clase1 extends Prototipo{

    public Clase1() {
    }

    @Override
    public <T> void valorSiguiente( T valor) {
        super.valorInicial+= (Integer)valor;
        System.out.println(valorInicial);
    }



}
