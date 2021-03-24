import composedFunctions.PiecewiseFunction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Ln function integration")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LnIntegration {
    final double PRECISION = 0.00001;
    PiecewiseFunction piecewiseFunction;

    @BeforeAll
    public void SetUp(){
        piecewiseFunction = new PiecewiseFunction(PRECISION);
        piecewiseFunction.setFuncIsStub(false);
        piecewiseFunction.getLogarithmicFunction().setFuncIsStub(false);
        piecewiseFunction.getTrigonometricFunction().setFuncIsStub(false);
        piecewiseFunction.getLogarithmicFunction().getLog2().setFuncIsStub(false);
        piecewiseFunction.getLogarithmicFunction().getLog3().setFuncIsStub(false);
        piecewiseFunction.getLogarithmicFunction().getLn().setFuncIsStub(false);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2*Math.PI, -2.5, -Math.PI/2, -0.5, 0.0, 0.5, 1.5})
    public void testIntegration(double x){
        double expected = piecewiseFunction.getStubValue(x);
        double actual = piecewiseFunction.calculate(x);
        assertEquals(expected, actual, PRECISION);
    }

    @AfterAll
    public void tearDown(){
        try {
            piecewiseFunction.printToFile(-5.0, 0.1, 100, "ln_integration");
        } catch (IOException e) {
            e.printStackTrace();
        }
        piecewiseFunction = null;
    }
}