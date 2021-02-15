package tax;

public class Tax {
    private static final int TAX_10 = 10;
    private static final int TAX_20 = 20;
    private static final int TAX_30 = 30;

    public static void main(String[] args) {
        double[] prices = new double[10];
        fillArray(prices, 100, 20000);
        getTax(prices);
    }

    private static void fillArray(double[] prices, double a, double b) {
        for (int i = 0; i < prices.length; i++) {
            prices[i] = a + Math.random() * b;
        }
    }
    private static void getTax(double[] prices){
        double priceWithTax = 0;
        for (double price : prices) {
            if (price > 0 && price < 100) {
                priceWithTax = (price * TAX_10) / 100;
            }
            if (price > 100 && price < 1000) {
                priceWithTax = (price * TAX_20) / 100;
            }
            if (price > 1000 && price < 10000) {
                priceWithTax = (price * TAX_30) / 100;
            }
            if (price<0 || price>10000){
                    System.out.printf("Для суммы %1f налог не предусмотрен! \n", price);
                    continue;
            }
            System.out.printf("Налог для суммы %1f = %1f \n", price, priceWithTax);
        }
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