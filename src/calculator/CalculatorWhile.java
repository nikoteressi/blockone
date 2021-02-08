package calculator;

import java.util.Scanner;

public class CalculatorWhile {

    public static void main(String[] args) {

        double[] results = new double[10]; // results.length == 10

        Scanner reader = new Scanner(System.in);

        int count = 0;

        // начальные значения не важны, мы их перетрем пользовательским вводом
        double first = 0;
        double second = 0;
        char operator = '0';

        // выполняем цикл пока есть место в массиве
        while (count < results.length) {

            System.out.println("Введите 2 числа ");

            first = reader.nextDouble();
            second = reader.nextDouble();

            operator = readOperator(reader);
            results[count] = makeOperation(first, second, operator);

            System.out.printf("%.1f %c %.1f = %.1f \n", first, operator, second, results[count]);
            count++;

            if (count < results.length) {
                System.out.print("Для выхода из программы напечатайте Выход: ");
                System.out.print("Для продолжения нажмите Enter");
                String line = reader.nextLine(); // пока еще не понял почему нужно один пропустить
                line = reader.nextLine();
                if ("выход".equalsIgnoreCase(line)) {
                    System.out.println();
                    break; // сразу выходим из цикла
                }
            }
        }

        reader.close();

        if (count == results.length) { // это значит что мы вышли не по приказу пользователя, а потому что достигли границы массива
            System.out.println("Место в таблице закончилось. Ваши результаты: ");
        } else {
            System.out.println("Вы вышли из программы. Ваши результаты: ");
        }

        for (int i = 0; i < count; ++i) {
            if (results[i] != 0) { // не знаю зачем так, но у тебя так было
                System.out.println((i + 1) + ". " + results[i]);
            }
        }
    }

    private static char readOperator(Scanner reader) {
        System.out.println("Введите оператор: (+, -, *, /): ");
        char operator = reader.next().charAt(0);
        if (!isValidOperator(operator)) {
            // пока не введут нормальный оператор повторяем требование
            while (!isValidOperator(operator)) {
                System.out.println("Введите корректный оператор");
                operator = reader.next().charAt(0);
            }
        }
        return operator;
    }

    private static boolean isValidOperator(char operator) {
        return "+-*/".contains("" + operator);
    }

    private static double makeOperation(double first, double second, char operator) {
        switch (operator) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
            default:
                throw new IllegalArgumentException();
        }
    }
}