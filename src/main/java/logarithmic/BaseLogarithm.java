package logarithmic;

import abstraction.AbstractFunction;
import exceptions.IllegalBaseException;

public abstract class BaseLogarithm extends AbstractFunction {
    Ln ln;

    public BaseLogarithm(double precision){
        super(precision);
        ln = new Ln(precision);
    }


    @Override
    protected double getStubValue(double x) {
        return Math.log(x);
    }

    @Override
    protected double getFunctionValue(double x){
        return ln.calculate(x);
    }
}
