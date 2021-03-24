package trigonometric;

import abstraction.AbstractFunction;
import util.Functions;

public class Cotangent extends AbstractFunction {
    public Cotangent(double precision) {
        super(precision);
        this.function = Functions.CTG;
        super.setFuncIsStub(true);
    }

    @Override
    public double getFunctionValue(double x) {
        x = x % Math.PI;
        if (x == Math.PI) {
            return Double.NEGATIVE_INFINITY;
        }
        if (x == 0.0) {
            return Double.POSITIVE_INFINITY;
        }
        double sin = x, cos = 1, cotan = 0, a = 1;
        int n = 2;
        while (Math.abs(cos / sin - cotan) > precision) {
            cotan = cos / sin;
            a *= -x * x / ((n - 1) * n);
            cos += a;
            sin += a * x / (n + 1);
            n += 2;
        }
        cotan = cos / sin;
        return cotan;
    }

    @Override
    public double getStubValue(double x) {
        //System.out.println(x%Math.PI);
        if ( Math.abs(x%Math.PI) == Math.PI) {
            return Double.NEGATIVE_INFINITY;
        }
        if (Math.abs(x%Math.PI) == 0.0) {
            return Double.POSITIVE_INFINITY;
        } else
            return 1 / Math.tan(x);
    }

}
