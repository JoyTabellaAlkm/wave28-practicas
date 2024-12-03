public abstract class Prototype<T extends  Number> {

    protected T firstElement;
    protected T currentElement;

    public abstract T next();

    public Prototype(T number){
        firstElement = currentElement = number;
    }

    public T reset(){
        return set(firstElement);
    }

    public T set(T number){
        firstElement = currentElement = number;
        return currentElement;
    }

}
