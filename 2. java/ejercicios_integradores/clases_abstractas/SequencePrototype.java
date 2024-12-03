package ejercicios_integradores.clases_abstractas;

public abstract class SequencePrototype<T extends Number> {
    protected T currentNumber;
    protected T incrementNumber;
    protected T startNumber;

    public SequencePrototype(T incrementNumber) {
        this.incrementNumber = incrementNumber;
    }

    public abstract T next();

    public void restartSequence() {
        setCurrentNumber(startNumber);
    }

    public void setCurrentNumber(T number) {
        this.currentNumber = number;
    }

    public T getCurrentNumber() {
        return currentNumber;
    }
}
