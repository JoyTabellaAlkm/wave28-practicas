package ejercicios_integradores.clases_abstractas;

public class SequenceInteger extends SequencePrototype<Integer> {

    public SequenceInteger(Integer incrementNumber) {
        super(incrementNumber);
        this.startNumber = 0;
        this.currentNumber = 0;
    }

    public SequenceInteger(Integer incrementNumber, Integer startNumber) {
        super(incrementNumber);
        this.startNumber = startNumber;
        this.currentNumber = startNumber;
    }

    @Override
    public Integer next() {
        this.currentNumber += this.incrementNumber;
        return this.currentNumber;
    }
}
