package composedFunctions;

import abstraction.AbstractFunction;
import trigonometric.Cotangent;
import util.Functions;

public class TrigonometricFunction extends AbstractFunction {
    public Cotangent getCtg() {
        return ctg;
    }

    Cotangent ctg;

    public TrigonometricFunction (double precision){
        super(precision);
        this.function = Functions.TRIG_FUN;
        super.setFuncIsStub(true);
        ctg = new Cotangent(precision);
    }

    @Override
    protected double getFunctionValue(double x){
        return Math.pow(ctg.calculate(x)*ctg.calculate(x),3);
    }

    @Override
    public double getStubValue(double x) {
        return Math.pow(ctg.getStubValue(x)*ctg.getStubValue(x),3);
    }
}
