package composedFunctions;

import abstraction.AbstractFunction;
import logarithmic.Log2;
import logarithmic.Log3;
import logarithmic.Ln;
import util.Functions;

public class LogarithmicFunction extends AbstractFunction {
    public Ln getLn() {
        return ln;
    }

    public Log3 getLog3() {
        return log3;
    }

    public Log2 getLog2() {
        return log2;
    }

    Ln ln;
    Log3 log3;
    Log2 log2;

    public LogarithmicFunction(double precision) {
        super(precision);
        this.function = Functions.LOG_FUN;
        super.setFuncIsStub(true);
        ln = new Ln(precision);
        log3 = new Log3(precision);
        log2 = new Log2(precision);
    }

    @Override
    protected double getFunctionValue(double x) {
        return (Math.pow(Math.pow((ln.calculate(x) - log3.calculate(x)), 2), 3) - Math.pow(log3.calculate(x), 2)) * (Math.pow(ln.calculate(x), 2) * (log2.calculate(x) - ln.calculate(x)));
    }

    @Override
    public double getStubValue(double x) {
        return  (Math.pow(Math.pow((ln.getStubValue(x) - log3.getStubValue(x)), 2), 3) - Math.pow(log3.getStubValue(x), 2)) * (Math.pow(ln.getStubValue(x), 2) * (log2.getStubValue(x) - ln.getStubValue(x)));
    }
}
