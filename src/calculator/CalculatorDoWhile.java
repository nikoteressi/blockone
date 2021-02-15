package calculator;

import java.util.Scanner;

public class CalculatorDoWhile {

    public static void main(String[] args) {
        double[] results = new double[10];
        Scanner reader = new Scanner(System.in);
        double first;
        double second;
        char operator;
        int count = 0;

        do {
            System.out.println("Введите 2 числа ");

            first = reader.nextDouble();
            second = reader.nextDouble();

            operator = readOperator(reader);
            results[count] = makeOperation(first, second, operator);

            System.out.printf("%.1f %c %.1f = %.1f \n", first, operator, second, results[count]);
            count++;

            System.out.println("Для выхода напечатайте Выход: ");
            System.out.println("Для продолжения нажмите Enter");
            reader.nextLine();
            String line = reader.nextLine();
            if ("выход".equalsIgnoreCase(line)) {
                System.out.println();
                break;
            }
        }
        while (count < results.length);

        reader.close();

        if (count == results.length) {
            System.out.println("Место в таблице закончилось. Ваши результаты: ");
        } else {
            System.out.println("Вы вышли из программы. Ваши результаты: ");
        }

        for (int i = 0; i < count; ++i) {
            if (results[i] != 0) {
                System.out.println((i + 1) + ". " + results[i]);
            }
        }
    }

    private static char readOperator(Scanner reader) {
        System.out.println("Введите оператор: (+, -, *, /): ");
        char operator = reader.next().charAt(0);
        if (isValidOperator(operator)) {
            while (isValidOperator(operator)) {
                System.out.println("Введите корректный оператор");
                operator = reader.next().charAt(0);
            }
        }
        return operator;
    }

    private static boolean isValidOperator(char operator) {
        return !"+-*/".contains("" + operator);
    }

    private static double makeOperation(double first, double second, char operator) {
        return switch (operator) {
            case '+' -> first + second;
            case '-' -> first - second;
            case '*' -> first * second;
            case '/' -> first / second;
            default -> throw new IllegalArgumentException();
        };
    }
}
