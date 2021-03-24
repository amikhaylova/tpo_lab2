package composedFunctions;

import abstraction.AbstractFunction;
import util.Functions;

public class PiecewiseFunction extends AbstractFunction {
    public LogarithmicFunction getLogarithmicFunction() {
        return logarithmicFunction;
    }

    public TrigonometricFunction getTrigonometricFunction() {
        return trigonometricFunction;
    }

    LogarithmicFunction logarithmicFunction;
    TrigonometricFunction trigonometricFunction;

    public PiecewiseFunction(double precision){
        super(precision);
        this.function = Functions.PW_FUN;
        super.setFuncIsStub(true);
        logarithmicFunction = new LogarithmicFunction(precision);
        trigonometricFunction = new TrigonometricFunction(precision);
    }

    @Override
    protected double getFunctionValue(double x){
        if (x<= 0)
            return trigonometricFunction.calculate(x);
        else
            return logarithmicFunction.calculate(x);
    }

    @Override
    public double getStubValue(double x) {
        if (x<= 0)
            return trigonometricFunction.getStubValue(x);
        else
            return logarithmicFunction.getStubValue(x);
    }
}
