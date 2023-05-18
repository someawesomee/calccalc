package calc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.calc.Calculator;

public class CalculatorTest {

    @Test
    void not_enough_data_test() {
        Throwable thrown = assertThrows(Exception.class, () -> {
            Calculator.add();
            Calculator.add(1);

            Calculator.multiply();
            Calculator.multiply(2);

            Calculator.divide();
            Calculator.divide(3);

            Calculator.subtract();
            Calculator.subtract(4);
        });
        assertEquals(thrown.getMessage(), "Not enough data");
    }

    @Test
    void add_test() throws Exception {
        assertEquals(5, Calculator.add(2, 3));
        assertEquals(10, Calculator.add(1, 2, 3, 4));
    }

    @Test
    void subtract_test() throws Exception {
        assertEquals(7, Calculator.subtract(10, 3));
        assertEquals(10, Calculator.subtract(20, 2, 3, 5));
    }

    @Test
    void multiply_test() throws Exception {
        assertEquals(6, Calculator.multiply(2, 3));
        assertEquals(24, Calculator.multiply(1, 2, 3, 4));
    }

    @Test
    void divide_test() throws Exception {
        assertEquals(3.0, Calculator.divide(15, 5));
        assertEquals(1.0, Calculator.divide(20, 4, 5));
    }

    @Test
    void division_by_zero_test() {
        Throwable thrown1 = assertThrows(Exception.class, () -> Calculator.divide(2, 2, 0));
        assertEquals(thrown1.getMessage(), "Division by zero");

        Throwable thrown2 = assertThrows(Exception.class, () -> Calculator.divide(2, 0, 4));
        assertEquals(thrown2.getMessage(), "Division by zero");

        Throwable thrown3 = assertThrows(Exception.class, () -> Calculator.divide(15, 0));
        assertEquals(thrown3.getMessage(), "Division by zero");
    }
}
