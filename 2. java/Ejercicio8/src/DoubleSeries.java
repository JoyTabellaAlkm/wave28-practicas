import java.lang.Integer;
import java.lang.Math;

public class DoubleSeries extends Prototype{
    public DoubleSeries(Integer firstElement) {
        super(firstElement);
    }

    @Override
    public Double next() {
        currentElement = Double.sum(currentElement.doubleValue(), currentElement.doubleValue());
        return currentElement.doubleValue();
    }
}
