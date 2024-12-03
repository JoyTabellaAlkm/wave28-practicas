public class SerieDouble extends Prototipo<Double>{
    @Override
    public Double getSiguienteValorSerie() throws IllegalAccessException {
        if (this.getValorActual() == null) {
            throw new IllegalAccessException("Debe inicializarse el valor inicial de la serie");
        }
        this.setValorActual(this.getValorActual() + this.getValorAumento());
        return this.getValorActual();
    }

    @Override
    public void reiniciarSerie() {
        this.setValorActual(null);
        this.setValorAumento(null);
    }

    @Override
    public void setValorInicialSerie(Double valor) {
        if (this.getValorActual() == null) {
            this.setValorActual(valor);
            this.setValorAumento(valor);
        }
    }
}
