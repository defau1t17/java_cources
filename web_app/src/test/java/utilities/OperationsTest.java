package utilities;

import org.junit.Test;

import static org.junit.Assert.*;

public class OperationsTest {

    @Test
    public void calculate() {
        Operations operation = new Operations(2, 2, "sum");
        double result = operation.calculate(2, 2, "sum");

        assertEquals(4.0, result);

    }
}