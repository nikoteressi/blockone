package calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

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
        System.out.printf("%.1f %c %.1f = %.1f", first, operator, second, result);

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
