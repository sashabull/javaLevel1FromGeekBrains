package com.geekbrains.lesson2;

public class BasicConstructions {
    public static void main(String[] args) {
        System.out.println( "1. метод");
        System.out.println( method1( 5, 16 ) );

        System.out.println("2. метод");
        method2(1);

        System.out.println("3. метод");
        System.out.println( method3( 1 ) );

        System.out.println("4. метод");
        method4( "проба", 3);

        System.out.println("5. метод - определяем високосный или нет");
        System.out.println( method5( 8 ));
    }

    /**  5-ый УЧЕБНЫЙ метод, который определяет,
     *   является ли год високосным,
     *   и возвращает boolean (високосный - true, не високосный - false).
     *   Каждый 4-й год является високосным,    (делимость на 4,    прим. СШБ)
     *   кроме каждого 100-го,                  (делимость на 100,  прим. СШБ)
     *   при этом каждый 400-й – високосный     (делимость на 400,  прим. СШБ).
     */
    public static boolean method5(int year) {
        //System.out.print( year + " - ");
        if( year%4 != 0 ){                  // выделили все возможные високосные
            return false;                   // все НЕвисокосные и не 100-ые - таких большинство
        }else {
            if ( year%100 != 0) {
                return true;                // все Високосные кроме 100-ых - эти на втором месте по количеству
            } else if ( year%400 != 0) {
                return false;               // все НЕвисокосные 100-ые, но уже без 400-х - эти на 3-м месте
            }else {
                return true;                // из 100-ых разрешили только 400-ые Високосные - этих меньше всего
            }
        }
    }

    /**  4-ый метод, которому в качестве аргументов передается строка и число,
     *   метод должен отпечатать в консоль указанную строку,
     *   указанное количество раз;
     */
    public static void method4( String str, int i ) {
        for( int j=i; j > 0; j--){
            //System.out.print( j + ". ");
            System.out.println(str);
        }
    }

    /**  3-ий метод, которому в качестве параметра передается целое число.
     *   Метод должен вернуть true,
     *   если число отрицательное,
     *   и вернуть false если положительное.
     */
    public static boolean method3( int i) {
        if( i < 0 ){
            return true;
        } else {
            return false;
        }
    }

    /**  2-ой метод, которому в качестве параметра передается целое число,
     *   метод должен напечатать в консоль,
     *   положительное ли число передали или отрицательное.
     *   Замечание: ноль считаем положительным числом.
     */
    public static void method2( int i) {
        //System.out.print( i + " - ");
        if (i>=0){
            System.out.println("положительное");
        }else {
            System.out.println("отрицательное");
        }
    }

    /**  1-ый метод, принимающий на вход два целых числа и проверяющий,
     *  что их сумма лежит в пределах от 10 до 20 (включительно),
     *  если да – вернуть true,
     *  в противном случае – false.
     */
    public static boolean method1(int int1, int int2 ) {
        int sum = int1 + int2 ;
        //System.out.println( "sum: " + int1 + " + " + int2 + " = " + sum );
        if ( (10 <= sum) && (sum <= 20) ){
            return true;
        } else {
            return false;
        }
    }
}
