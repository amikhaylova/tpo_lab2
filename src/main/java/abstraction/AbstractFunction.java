package abstraction;

import exceptions.InvalidPrecisionValueException;
import interfaces.CsvPrintable;
import util.Functions;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractFunction implements CsvPrintable {

    private static final double DEFAULT_PRECISION = 0.001;
    protected double precision;

    public final Boolean DEFAULT_IS_STUB = true;
    private static Map<Functions, Boolean> funcIsStub = new HashMap<>();
    protected Functions function;


    public AbstractFunction() {
        precision = DEFAULT_PRECISION;
        funcIsStub.put(function, DEFAULT_IS_STUB);
    }

    public AbstractFunction(double precision) {
        if (precision < 0.0 || precision >= 1.0)
            throw new InvalidPrecisionValueException(precision);
        this.precision = precision;
        //funcIsStub.put(function, DEFAULT_IS_STUB);
    }

    public double calculate(double x) {
        Boolean isStub;
        if (function == null) {
            throw new NullPointerException();
        }
        if ((isStub = funcIsStub.get(function)) == null) {
            isStub = DEFAULT_IS_STUB;
        }
        if (isStub) {
            //return stubValuesTable.get(x);
            return getStubValue(x);
        } else {
            return getFunctionValue(x);
        }
    }

    abstract protected double getFunctionValue(double x);

    abstract protected double getStubValue(double x);

    public void printToFile(double start, double step, int numberOfValues, String file) throws IOException {
        String fileName = file + ".csv";
        File csvOutputFile = new File(fileName);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            for (double i = 0; i < numberOfValues; i++) {
                double x = start + i * step;
                pw.write(x + ";" + calculate(x) + "\n");
            }
        }

    }


    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public void setFuncIsStub(boolean funcIsStub) {
        AbstractFunction.funcIsStub.put(function, funcIsStub);
    }
}
