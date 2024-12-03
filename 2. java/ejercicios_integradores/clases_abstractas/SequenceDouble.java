package ejercicios_integradores.clases_abstractas;

public class SequenceDouble extends SequencePrototype<Double> {
    public SequenceDouble(Double incrementNumber) {
        super(incrementNumber);
        this.startNumber = 0.0;
        this.currentNumber = 0.0;
    }

    public SequenceDouble(Double incrementNumber, Double startNumber) {
        super(incrementNumber);
        this.startNumber = startNumber;
        this.currentNumber = startNumber;
    }

    @Override
    public Double next() {
        this.currentNumber += this.incrementNumber;
        return this.currentNumber;
    }
}
