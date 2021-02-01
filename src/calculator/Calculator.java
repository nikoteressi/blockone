package calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        double[] results = new double[10];
        int count = 0;

        for (int i = 0; i < results.length; i++) {
            Scanner reader = new Scanner(System.in);

            System.out.println("Введите 2 числа ");

            double first = reader.nextDouble();
            double second = reader.nextDouble();

            System.out.println("Введите оператор: (+, -, *, /): ");
            char operator = reader.next().charAt(0);

            double result;

            switch (operator) {
                case '+' -> result = first + second;
                case '-' -> result = first - second;
                case '*' -> result = first * second;
                case '/' -> result = first / second;
                default -> {
                    System.out.println("Введите корректный оператор");
                    return;
                }
            }
            System.out.printf("%.1f %c %.1f = %.1f \n", first, operator, second, result);
            results[i] = result;
            count++;

            if (count == 10) {
                int count5 = 1;
                System.out.println("Место в таблице закончилось. Ваши результаты: ");
                for (double v : results) {
                    System.out.println(count5 + ". " + v);
                    count5++;
                }
            }

            System.out.println("Для выхода из ппрограммы напечатайте Выход");
            String exit = reader.next();

            if (exit.equals("Выход")) {
                int count3 = 1;
                System.out.println("Вы вышли из программы. Ваши результаты: ");
                for (double res : results) {
                    if (res != 0) {
                        System.out.println(count3 + ". " + res);
                        count3++;
                    }
                }
                return;
            }

        }
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
