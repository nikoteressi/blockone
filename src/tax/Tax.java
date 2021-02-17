package tax;

public class Tax {
    private static final int TAX_10 = 10;
    private static final int TAX_20 = 20;
    private static final int TAX_30 = 30;

    public static void main(String[] args) {
        getTax(args);
    }

    private static void getTax(String[] args) {
        for (String price : args) {
            if (isNumber(price)) {
                double priceNumber = Double.parseDouble(price);
                if (priceNumber <= 0 || priceNumber > 10000) {
                    System.out.printf("Для суммы %1f налог не предусмотрен! \n", priceNumber);
                } else if (priceNumber < 100) {
                    printPriceWithTax(priceNumber, TAX_10);
                } else if (priceNumber < 1000) {
                    printPriceWithTax(priceNumber, TAX_20);
                } else {
                    printPriceWithTax(priceNumber, TAX_30);
                }

            } else {
                System.out.printf("%s не является числовым значением\n", price);
            }
        }
    }

    private static void printPriceWithTax(double priceNumber, int tax) {
        double priceWithTax = (priceNumber * tax) / 100;
        System.out.printf("Налог для суммы %1f = %1f \n", priceNumber, priceWithTax);
    }

    private static boolean isNumber(String price) {
        return price.matches("-?\\d+(\\.\\d*)?");
    }
}

/*
Напишите программу «Налог».
На вход программы поступает массив с ценниками.

Вам нужно рассчитать налог исходя из диапазона цены.
Вывести налоги в консоль.

Проверять входной ценник по регулярному выражению, что это число и оно больше 0.
Если нет ценников с диапазоном 1,2,3 то и выводить такие данные не нужно.

Учтите:
Ценники больше 10000 не обрабатывать.
Ценники могут быть дробными.
*/