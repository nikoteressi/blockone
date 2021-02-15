package calculator;

import java.util.Scanner;

public class CalculatorFor {

    public static void main(String[] args) {

        double[] results = new double[10];

        Scanner reader = new Scanner(System.in);

        for (int i = 0; i < results.length; i++) {
            System.out.println("Введите 2 числа ");

            double first = reader.nextDouble();
            double second = reader.nextDouble();
            char operator = readOperator(reader);
            results[i] = makeOperation(first, second, operator);

            System.out.printf("%.1f %c %.1f = %.1f \n", first, operator, second, results[i]);

            System.out.println("Для выхода напечатайте Выход: ");
            System.out.println("Для продолжения нажмите Enter");
            reader.nextLine();
            String line = reader.nextLine();
            if ("выход".equalsIgnoreCase(line)) {
                System.out.println("Вы вышли из программы. Ваши результаты: ");
                break; // сразу выходим из цикла
            }
            if (i == 9) {
                System.out.println("Место в таблице закончилось. Ваши результаты: ");
            }
        }
        reader.close();

        for (int j = 0; j < results.length; ++j) {
            if (results[j] != 0) {
                System.out.println((j + 1) + ". " + results[j]);
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

/*
 *     ДЗ
 *     1. добавьте массив для сохранения результатов размерностью 10
 *     если результатов стало больше мы завершаем работы, информируя пользователя и распечатывая результаты
 *
 *     2. поместите код в цикл для возможности использования без постоянного запуска программы.
 *     Для выхода пусть буду слова "выход"
 *     T.е. пользователь ввел выход - мы просто выходим, сохраняя результат в массиве результатов и выводим массив на консоль.
 *
 *
 */
