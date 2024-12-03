import java.lang.Integer;
import java.lang.Math;

public class IntegerSeries extends Prototype{
    public IntegerSeries(Integer firstElement) {
        super(firstElement);
    }

    @Override
    public Integer next() {
        currentElement = Integer.sum(currentElement.intValue(), currentElement.intValue());
        return currentElement.intValue();
    }
}
