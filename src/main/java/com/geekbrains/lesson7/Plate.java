package com.geekbrains.lesson7;

/**
 * класс Тарелка
 * с едой для животного
 */
public class Plate {
    private int food;                           // кол-во еды в тарелке
    public Plate(int food) {
        this.food = food;
    }

    /**
     * кот поел из тарелки свою порцию еды
     * @param n - количество еды сьедаемое животным из тарелки за один подход
     */
    public void decreaseFood(int n) {
        food -= n;
    }

    /**
     * выдаем инф. о состоянии тарелки
     */
    public void info() {
        System.out.println("plate: " + food);
    }

    /**
     * получение информации о количестве еды в тарелке
     * @return - количество еды в тарелке
     * для оценки - хватит ли животному еды в тарелке
     */
    public int getFood() {
        return food;
    }

    /**
     * добавление еды в тарелку
     * @param food - кол-во добавляемой еды
     */
    public void addFood(int food){
        this.food += food;
    }
}
