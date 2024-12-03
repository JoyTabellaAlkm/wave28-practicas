package PrototipoAsincronico;

public class Prototipo {
    Integer valorInicial=1;

    public Object getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Integer valorInicial) {
        this.valorInicial = (Integer)valorInicial;
    }

    public<T> void valorSiguiente(T valor){};

    public void reiniciarSerie(){
        this.valorInicial=1;
        System.out.println("Se reinicio la serie");
    };

    public <T> void cambiarValorInicial(T valor){
        this.valorInicial = (Integer) valor;
        System.out.println("Valor inicial cambiado a: " + valor);
    };
}
