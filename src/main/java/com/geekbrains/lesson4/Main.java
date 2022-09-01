package com.geekbrains.lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *   Крестики нолики в процедурном стиле
 *   Задача учебного курса.
 */
public class Main {
    public static void main(String[] args) {
        int sizeFiled = 5;  // размер игрового поля
        String star = "*";  // символ пустого поля
        String X = "X";     // символ хода игрока
        String O = "O";     // символ хода программы
        String[][] GameField =  prepareGameField( sizeFiled, star );
        printField(GameField);
        do {
            // System.out.println("gaming"); // отладка на одном проходе
            // ход игрока
            humanMotion(GameField, X, star);
            printField(GameField);
            // проверка на победу
            if (checkVictory(GameField, 4)){
                break;
            }
            // проверка на ничью
            if (checkNoting(GameField, star)){
                break;
            }

            // ход программы
            progtammMotion(GameField);
            printField(GameField);
            // проверка на победу
            if (checkVictory(GameField, 4)){
                break;
            }
            // проверка на ничью
            if (checkNoting(GameField, star)){
                break;
            }
        }while (true);
    }

    /**
     *  проверка на победу - циклами
     *  arr - проверяемый массив
     *  count - выигрышное кол-во фишек подряд в подсчитываемом ряду или диагонали
     */
    public static boolean checkVictory(String[][] arr, int count) {
        int result = 0; //  подсчет позиций Х или О подряд
        int[] result_column = new int[arr.length]; // подсчет позиций подряд в столбиках за один проход массива
        int diag_ij = 0; // подсчет позиций подряд в прямая диагональ
        int diag_ji = 0; // подсчет позиций подряд в обратная диагональ

        for (int i = 0; i < arr.length; i++){  // проверка всех строк
            result = 0;
            for (int j = 0; j < arr.length; j++){  // проверка строки
                //System.out.println("i="+i+", j="+j+", result="+result+", arr="+arr[i][j]);
                if (j==0 && (arr[i][j].equals("X") || arr[i][j].equals("O"))){
                    result = 1;
                } else if (j>0 && arr[i][j].equals("X") && arr[i][j-1].equals("X")) {
                    result++;
                } else if (j>0 && arr[i][j].equals("O") && arr[i][j-1].equals("O")) {
                    result++;
                } else if (j>0 && arr[i][j].equals("X") && (arr[i][j-1].equals("O") || arr[i][j-1].equals("*"))) {
                    result = 1;
                } else if (j>0 && arr[i][j].equals("O") && (arr[i][j-1].equals("X") || arr[i][j-1].equals("*"))) {
                    result = 1;
                } else if (j>0 && arr[i][j].equals("*")) {
                    result = 0;
                }

                if ( result >= count ){
                    System.out.println("обаружена выигрышная строка");
                    return true;
                }

                // считаем в столбцах
                //System.out.println("начинаем считать столбцы");
                //System.out.println(Arrays.toString(result_column));
                if (i==0 && (arr[i][j].equals("X") || arr[i][j].equals("O"))){
                    result_column[j] = 1;
                } else if (i>0 && arr[i][j].equals("X") && arr[i-1][j].equals("X")) {
                    result_column[j]++;
                } else if (i>0 && arr[i][j].equals("O") && arr[i-1][j].equals("O")) {
                    result_column[j]++;
                } else if (i>0 && arr[i][j].equals("X") && (arr[i-1][j].equals("O") || arr[i-1][j].equals("*"))) {
                    result_column[j] = 1;
                } else if (i>0 && arr[i][j].equals("O") && (arr[i-1][j].equals("X") || arr[i-1][j].equals("*"))) {
                    result_column[j] = 1;
                } else if (i>0 && arr[i][j].equals("*")) {
                    result_column[j] = 0;
                }

                if ( i >= count-1 ){
                    //System.out.println("вошли на выявление колонок");
                    for (int k=0; k<result_column.length; k++) {
                        if ( result_column[k] >= count ){
                            System.out.println("Обаружен выигрышный стобец.");
                            return true;
                        }
                    }
                }

                // проверяем прямую диагональ
                if (i==0 && j==i && (arr[i][j].equals("X") || arr[i][j].equals("O"))){
                    diag_ij = 1;
                } else if (i==j && j>0 && arr[i][j].equals("X") && arr[i-1][j-1].equals("X")) {
                    diag_ij++;
                } else if (i==j && j>0 && arr[i][j].equals("O") && arr[i-1][j-1].equals("O")) {
                    diag_ij++;
                } else if (i==j && j>0 && arr[i][j].equals("X") && (arr[i-1][j-1].equals("O") || arr[i-1][j-1].equals("*"))) {
                    diag_ij = 1;
                } else if (i==j && j>0 && arr[i][j].equals("O") && (arr[i-1][j-1].equals("X") || arr[i-1][j-1].equals("*"))) {
                    diag_ij = 1;
                } else if (i==j && arr[i][j].equals("*")) {
                    diag_ij = 0;
                }
                if (i>=count-1){
                    if (diag_ij >= count){
                        System.out.println("Обнаружена выигрышная диагональ (прямая).");
                        return true;
                    }
                }

                // проверяем обратную диагональ
                //System.out.println("i="+i+", j="+j+", diag_ji="+diag_ji+", arr.length-2-j="+(arr.length-1-j)+", "+arr[i][j]);
                if (i==0 && j == arr.length-1 && (arr[i][j].equals("X") || arr[i][j].equals("O"))){
                    diag_ji = 1;
                    //System.out.println("1. i="+i+", j="+j+", diag_ji="+diag_ji+", arr.length-2-j="+(arr.length-1-j));
                } else if (i==(arr.length-1-j) && arr[i][j].equals("X") && arr[i-1][j+1].equals("X")) {
                    diag_ji++;
                    //System.out.println("2. i="+i+", j="+j+", diag_ji="+diag_ji+", arr.length-2-j="+(arr.length-1-j));
                } else if (i==(arr.length-1-j) && arr[i][j].equals("O") && arr[i-1][j+1].equals("O")) {
                    diag_ji++;
                    //System.out.println("3. i="+i+", j="+j+", diag_ji="+diag_ji+", arr.length-2-j="+(arr.length-1-j));
                } else if (i==(arr.length-1-j) && arr[i][j].equals("X") && (arr[i-1][j+1].equals("O") || arr[i-1][j+1].equals("*"))) {
                    diag_ji = 1;
                    //System.out.println("4. i="+i+", j="+j+", diag_ji="+diag_ji+", arr.length-2-j="+(arr.length-1-j));
                } else if (i==(arr.length-1-j) && arr[i][j].equals("O") && (arr[i-1][j+1].equals("X") || arr[i-1][j+1].equals("*"))) {
                    diag_ji = 1;
                    //System.out.println("5. i="+i+", j="+j+", diag_ji="+diag_ji+", arr.length-2-j="+(arr.length-1-j));
                } else if (i>=0 && diag_ji!=0 && i==(arr.length-1-j) && arr[i][j].equals("*")) {
                    diag_ji = 0;
                    //System.out.println("6. i="+i+", j="+j+", diag_ji="+diag_ji+", arr.length-2-j="+(arr.length-1-j));
                }
                if (i>=count-1){
                    if (diag_ji >= count){
                        System.out.println("Обнаружена выигрышная диагональ (обратная)");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *   ход программы - как оппонента игроку
     *   ставит большие буквы "О" англ.
     */
    public static void progtammMotion(String[][] arr) {
        boolean check = true;
        do {
            Random random = new Random();
            int x = random.nextInt(arr.length);
            int y = random.nextInt(arr.length);
            if (arr[x][y].equals("*")){
                arr[x][y] = "O";
                check = false;
                System.out.println("Программа сделала ход.");
            }
        }while (check);
    }

    /**
     *   проверка на ничью - все поля заняты, ходить некуда
     */
    public static boolean checkNoting(String[][] arr, String star) {
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (arr[i][j].equals(star)) {
                    return false;
                }
            }
        }
        System.out.println("Все поля заняты - НИЧЬЯ .");
        return true;
    }

    /**
     *   ход игрока
     *   arr - массив игрового поля
     *   X  - символ игрока
     *   star - звездочка свободного поля
     */
    public static void humanMotion(String[][] arr, String X, String star) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Укажите клетку X и Y");
            int x = scanner.nextInt()-1;
            int y = scanner.nextInt()-1;
            int size = arr.length;
            if ( x<size && x>=0 && y<size && y>=0){
                if (arr[x][y].equals(star)) {
                    arr[x][y] = X;
                    break;
                }else{
                    System.out.println("Поле недоступно для ввода! Повторите ввод.");
                }
            }else{
                System.out.println("Указанные значения вне игрового поля! Повторите ввод.");
            }
        }while (true);
    }

    /**
     *  печать игрового поля
     *  arr - массив игрового поля
     */
    public static void printField(String[][] arr) {
        for (int i = 0; i < arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        for (int i = 0; i < arr[0].length*3; i++ ){
            System.out.print("-");
        }
        System.out.println("");
    }
    /**
     *  создание игрового квадратного поля (size * size)
     *  size - сторона квадратного поля
     *  star - символ заполненмя поля (звездочками)
     */
    public static String[][] prepareGameField( int size, String star ) {
        String[][] arr = new String[size][size];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                arr[i][j] = star;
            }
        }
        return arr;
    }
}
