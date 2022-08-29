package com.geekbrains.lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println("2.");
        printThreeWords();  // 2-ой пункт практ.задания
        System.out.println("3.");
        checkSumSign();     // 3-ий пункт практ.задания
        System.out.println("4.");
        printColor();       // 4-ый пункт практ.задания
        System.out.println("5.");
        compareNumbers();   // 5-ый пункт практ.задания
    }

    /**  2-ой пункт практрического задания
     *   печать в столбик трех слов
     */
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    /**  3-ий пункт практического задания
     *    суммирование 2-х целых числел и вывод фразы по условию на сумму.
     */
    public static void checkSumSign() {
        int a = -10 ; // -10 - проверено, -6 - проверено, -5 - проверено
        int b = 6 ;
        System.out.println("Sum: " + a + " + " + b + " = " + (a+b));
        if ( a + b >= 0 ) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    /**  4-ый пункт практ. задания
     *   - инициализация целого числа от <0 до >100
     *   - печать фраз по условиюн на число
     */
    public static void printColor() {
        int value = 101 ;    // -5 - проверено Красный, 0 - проверено Красный, 1 - проверено Желтый, 100 - проверено Желтый, 101 - Зеленый
        System.out.println("value = " + value);
        if( value <= 0 ){
            System.out.println("Красный");            
        } else if ( (value > 0) && (value <= 100) ) {
            System.out.println("Желтый");
        } else if ( value > 100 ){
            System.out.println("Зеленый");
        }
    }

    /**  5. пункт практ. задания
     *   - инициализация 2-х целых чисел
     *   - вывод сообщнеия по условию
     */
    public static void compareNumbers() {
        int a = 0 ; // 5 - проверено, 6 - проверено, 0 - проверено
        int b = 5 ;
        System.out.println("a = " + a + ", b = " + b );
        if ( a >= b ) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
