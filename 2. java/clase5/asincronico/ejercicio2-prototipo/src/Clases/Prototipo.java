package Clases;

import java.util.List;

public abstract class Prototipo {
    private Number valorInicial;
    private Number valorIncremento;
    private List<Number> serieNumerica;

    public Number getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Number valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Number getValorIncremento() {
        return valorIncremento;
    }

    public void setValorIncremento(Number valorIncremento) {
        this.valorIncremento = valorIncremento;
    }

    public List<Number> getSerieNumerica() {
        return serieNumerica;
    }

    public void setSerieNumerica(List<Number> serieNumerica) {
        this.serieNumerica = serieNumerica;
    }

    public Prototipo(Number valorInicial, Number valorIncremento, List<Number> serieNumerica) {
        this.valorInicial = valorInicial;
        this.valorIncremento = valorIncremento;
        this.serieNumerica = serieNumerica;
    }

    public abstract Number devolverSiguienteNumero();
    public void reiniciarSerie(){
        serieNumerica.clear();
    };
    public void setearValorInicial(Number n){
        this.valorInicial = n;
    };
}
