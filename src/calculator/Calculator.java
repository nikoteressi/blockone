package calculator;

import java.util.Scanner;

public class Calculator {


    public static void main(String[] args) {
        double[] results = new double[10];
        Scanner reader = new Scanner(System.in);
        if (loopFor(results, reader) == results.length) {
            System.out.println("""
                                        
                    Место в таблице закончилось.
                    Ваши результаты : 
                    """);
        } else {
            System.out.println("""
                    Вы вышли из программы.
                    Ваши результаты: 
                    """);
        }
        for (int i = 0; i < results.length; i++) {
            System.out.println((i + 1) + ". " + results[i]);
        }
    }

    public static double engine(Scanner reader) {

        System.out.println("Введите два числа: ");
        double first = reader.nextDouble();
        double second = reader.nextDouble();

        System.out.println("Введите оператор (+ - * /) : ");
        char operator = reader.next().charAt(0);
        while (!"+-*/".contains("" + operator)) {
            System.out.println("Введите корректный оператор : ");
            operator = reader.next().charAt(0);
        }

        double result = switch (operator) {
            case '+' -> first + second;
            case '-' -> first - second;
            case '*' -> first * second;
            case '/' -> first / second;
            default -> throw new IllegalArgumentException();
        };

        System.out.printf("%.1f %c %.1f = %.1f \n", first, operator, second, result);
        return result;
    }

    public static boolean stepUp(Scanner reader) {
        boolean flag = false;
        System.out.println("""
                Для продолжения нажмите любую клавишу.
                Для выхода напечатайте Выход
                """);
        reader.nextLine();
        String line = reader.nextLine();
        if ("выход".equalsIgnoreCase(line)) {
            flag = true;
        }
        return flag;
    }

    public static int loopFor(double[] results, Scanner reader) {
        int count = 0;
        for (int i = 0; i < results.length; i++) {
            results[i] = engine(reader);
            count++;
            if (stepUp(reader)) {
                break;
            }
        }
        return count;
    }

    public static int loopWhile(double[] results, Scanner reader) {
        int count = 0;
        while (count < results.length) {
            results[count] = engine(reader);
            count++;
            if (stepUp(reader)) {
                break;
            }
        }
        return count;
    }

    public static int loopDoWhile(double[] results, Scanner reader) {
        int count = 0;
        do {
            results[count] = engine(reader);
            count++;
            if (stepUp(reader)) {
                break;
            }
        } while (count < results.length);
        return count;
    }

}
