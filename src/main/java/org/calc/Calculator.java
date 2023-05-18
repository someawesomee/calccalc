package org.calc;

import java.util.Arrays;

public class Calculator {

    public static double add(double... numbers) throws Exception {

        if (Calculator.check_len(numbers)) {
            throw new Exception("Not enough data");
        }
        return Arrays.stream(numbers).sum();
    }

    public static double multiply(double... numbers) throws Exception {

        if (Calculator.check_len(numbers)) {
            throw new Exception("Not enough data");
        }

        double res = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            res = res * numbers[i];
        }
        return res;
    }

    public static double divide(double... numbers) throws Exception {

        if (Calculator.check_len(numbers)) {
            throw new Exception("Not enough data");
        }

        double res = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new Exception("Division by zero");
            }
            res = res / numbers[i];
        }
        return res;
    }

    public static double subtract(double... numbers) throws Exception {

        if (Calculator.check_len(numbers)) {
            throw new Exception("Not enough data");
        }

        double res = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            res = res - numbers[i];
        }
        return res;
    }

    private static boolean check_len(double... numbers) {
        return numbers.length < 2;
    }
}