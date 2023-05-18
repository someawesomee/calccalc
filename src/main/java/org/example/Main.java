package org.example;

import org.calc.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        double ans;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите числа через пробел: ");
            String[] numbersString = reader.readLine().split(" ");
            double[] numbers = new double[numbersString.length];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Double.parseDouble(numbersString[i]);
            }
            System.out.print("\nВыберите действие (+, -, *, /): ");
            char op = (char) System.in.read();
            try {
                switch (op) {
                    case '+':
                        ans = Calculator.add(numbers);
                        break;
                    case '-':
                        ans = Calculator.subtract(numbers);
                        break;
                    case '*':
                        ans = Calculator.multiply(numbers);
                        break;
                    case '/':
                        ans = Calculator.divide(numbers);
                        break;
                    default:
                        System.out.print("Error! Введите коректное действие");
                        return;
                }
                System.out.print("\nРезультат вычислений:\n");
                System.out.printf("Результат = " + ans);
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}