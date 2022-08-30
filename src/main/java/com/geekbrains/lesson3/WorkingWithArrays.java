package com.geekbrains.lesson3;

import java.util.Arrays;

public class WorkingWithArrays {
    public static void main(String[] args) {
        System.out.println("1. метод");
        method1();

        System.out.println("2-ой метод");
        method2();

        System.out.println("3-ий метод");
        method3();

        System.out.println("4-ый метод");
        method4();

        System.out.println("5-ый метод");
        System.out.println( Arrays.toString( method5( 11, 22 )));

        System.out.println("6-ой метод");
        method6();

        System.out.println("7-ой метод");
        //int[] arr = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] arr7 = {1, 1, 1, 2, 1};
        System.out.println( method7( arr7 ) );

        System.out.println("8-ое метод");
        int[] arr8 = {3, 5, 6, 1};
        System.out.println(Arrays.toString(arr8));
        method8( arr8, -2 );
        System.out.println(Arrays.toString(arr8));
    }

    /**  8-ой метод, которому на вход подается одномерный массив и число n
     *   (может быть положительным, или отрицательным),
     *   при этом метод должен сместить все элементы массива на n позиций.
     *   Элементы смещаются циклично.
     *   Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     *   Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
     *   при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
     *   При каком n в какую сторону сдвиг можете выбирать сами.
     */
    public static void method8(int[] arr, int n) {
        int direct = 0;         // направление движения n к 0: -1 или 1
        int an = 0;              // модуль n
        if ( n > 0 ){           // опускаем n до 0
            direct = 1;         // Движемся по матрице вправо
        } else if (n < 0) {     // поднимаем n до 0
            direct = -1;        // движемся по матрице влево
            n = n * direct;      // n оберем по модулю положительное
        }

        do{     // делаем только n циклов сдвига до 0
            int stack_in = 0;
            int stack_out = 0;
            int stack_0 = 0;
            int stack_len = 0;

            for (int i = 0; i < arr.length; i++ ){
                System.out.println("n = "+n+",dir = "+direct+", i = " +i );
                if ((i==0) && (direct > 0)){
                    stack_in = arr[1];
                    stack_out = stack_in;
                    arr[1]=arr[0];
                    arr[0] = arr[arr.length-1];
                } else if ((i>=0) && (i< (arr.length-1)) && (direct>0)){
                    stack_in = arr[i+1];
                    arr[i+1] = stack_out;
                    stack_out = stack_in;
                } else if ((i==0) && (direct < 0)) {
                    stack_in = arr[0];
                    arr[0]=arr[1];
                } else if ((i>=0) && (i< (arr.length-1)) && (direct<0)) {
                    arr[i]= arr[i+1];
                } else if ((i == (arr.length-1)) && (direct<0)) {
                    arr[arr.length-1] = stack_in;
                }
            }
            n = n - 1;
        }while ( n != 0 );
    }

    /**  7-ой метод, Написать метод,
     *   в который передается не пустой одномерный целочисленный массив - arr ,
     *   метод должен вернуть true, если в массиве есть место,
     *   в котором сумма левой и правой части массива равны.
     *   **Примеры:
     *     checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
     *     checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
     *     граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
     */
    public static boolean method7( int[] arr ) {
        int len = arr.length;
        int le = 0 ;            // позиция суммы слева
        int ri = len-1 ;        // позиция суммы справа
        int suml = arr[le];     // сюда складываем суммы слева нарастающим итогом
        int sumr = arr[ri];     // сюда складываем суммы справа нарастающим итогом
        System.out.println( Arrays.toString( arr ));
        System.out.println("1. le = " + le + " suml = "+suml+", ri = " + ri + ", sumr = " + sumr);

        // несколько очевидных решений
        if ( len <= 1 ){
            return false;       // для одномерного массива из 1-го или менее эл-тов не может быть истинного ответа.
        }

        if (( len == 2 ) && ( suml == sumr )){    // для массива из 2-х эл-тов
            return true;
        } else if (( len == 2 ) && ( suml != sumr )) {
            return false;
        }

        // для массивов более 2-х шт, считаем слева и подсчитываем справа, если встретились, то решение, или истина, или ложь
        do {
            if ( suml > sumr ){     // слева сумма больше, делаем шаг справа
                for (int r = ri-1; ((le < r) && (suml >= sumr)) ; r--){
                    ri = r;
                    sumr = sumr + arr[ri];
                    System.out.println("сделали шаг справа");
                    System.out.println("le = " + le + " suml = "+suml+", ri = " + ri + ", sumr = " + sumr);
                }
            }else {                 // слева сумма меньше или равна сумме справа, делаем шаг справа
                for (int l = le+1; ((l < ri) && (suml <= sumr)); l++ ){
                    le = l;
                    suml = suml + arr[le];
                    System.out.println("сделали шаг слева");
                    System.out.println("le = " + le + " suml = "+suml+", ri = " + ri + ", sumr = " + sumr);
                }
            }
        } while ( le + 1 < ri );

        if( suml == sumr ){
            return true;
        }else {
            return false;
        }
    }

    /**  6-ой метода, Задать одномерный массив и
     *  найти в нем минимальный и максимальный элементы ;
     */
    public static void method6() {
        int l = 100;    // размер массива
        int z = 99;     // для заполнения массива
        int min = 0;    // переменная для минимального значения в массиве
        int max = 0;    // переменная для максимального значения в массиве
        int[] arr = new int[l];

        for (int i = 0; i < l; i++ ){  // заполняем массив
            arr[i] = z - i*2 ;
        }

        min = max = arr[0]; // взяли данные первого эл.

        for (int i = 1; i < l; i++){  // начали поиск со 2-го эл.
            if ( arr[i] < min ){
                min = arr[i];
            }
            if (arr[i] > max ){
                max = arr[i];
            }
        }
        System.out.println( Arrays.toString( arr));
        System.out.println("min = "+ min + ", max = " + max);
    }

    /**  5-ый метод, принимающий на вход два аргумента: len и initialValue, и
     *   возвращающий одномерный массив типа int длиной len,
     *   каждая ячейка которого равна initialValue;
     */
    public static int[] method5( int len, int initialValue) {
        int[] arr = new int[len];
        // System.out.println( Arrays.toString( arr ));
        for (int i = 0; i < len; i++){
            arr[i] = initialValue;
        }
        return arr;
    }

    /** 4-ый метод, Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и
     *  с помощью цикла(-ов) заполнить его диагональные элементы единицами
     *  (можно только одну из диагоналей, если обе сложно).
     *  Определить элементы одной из диагоналей можно по следующему принципу:
     *    индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
     */
    public static void method4() {
        int a = 10;
        int[][] arr = new int[a][a];

        for (int i = 0; i < a; i++ ) {
            System.out.println( Arrays.toString( arr[i] ));
        }

        for (int i = 0; i < a; i++ ){
            for (int j = 0; j < a; j++){
                if ( i == j ){              // диагональ прямая
                    arr[i][j] = 1;
                }
                if ( j == ( a - i - 1 )){   // диагональ обратная
                    arr[i][j] = 1;
                }
            }
        }
        System.out.println();

        for ( int i = 0; i < a; i++){
            System.out.println( Arrays.toString( arr[i] ));
        }

    }

    /**  3-ий метод, Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
     *  пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    public static void method3() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println( Arrays.toString( arr ));
        for ( int i = 0; i < arr.length; i++){
            if( arr[i] < 6 ){
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println( Arrays.toString( arr ));
    }

    /** 2-ой метод, Задать пустой целочисленный массив длиной 100.
     *  С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
     */
    public static void method2() {
        int[] arr = new int[100];
        System.out.println( Arrays.toString( arr ));
        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
        System.out.println( Arrays.toString( arr ));
    }

    /**  1-ый метод, Задать целочисленный массив, состоящий из элементов 0 и 1.
     *   Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     *   С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static void method1() {
        int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println(Arrays.toString(arr));
        for ( int i = 0; i < arr.length; i++) {
            //System.out.print( "i = " + arr[i] );
            if ( arr[i] == 0 ){
                //System.out.print(", меняем 0 на 1");
                arr[i] = 1;
                //System.out.println(", i = " + arr[i] );
            } else if ( arr[i] == 1 ) {
                //System.out.print(", меняем 1 на 0");
                arr[i] = 0;
                //System.out.println(", i = " + arr[i] );
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
