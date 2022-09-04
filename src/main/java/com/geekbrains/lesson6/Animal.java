package com.geekbrains.lesson6;

/**
 *  суперкласс житотное. абстрактный т.к. абстрактных животных не бывает
 */
abstract public class Animal {

    public static Integer countAnimals = 0;     // для подсчета всех созданных животных

    public String name;                 // по заданию имя нужно, а вид животного нет
    protected Integer maxLengthRun;     // максимальное количество метров пробегаемых животным
    protected Integer maxLengthSwim;    // максимальное количество метров проплываемых животным

    /**
     * конструктор для животных
     * @param name - имя животного
     */
    public Animal(String name){
        this.name = name;
        countAnimals ++;                // посчитали очередной созданный экз.животного
    }

    /**
     * задача животного на бег
     * @param lengthRun - длина препятсвия/бега
     */
    public void run(Integer lengthRun){
        if (lengthRun <= this.maxLengthRun){
            System.out.println(this.name + " пробежал " + lengthRun + "м.");
        }else {
            System.out.println("Животное (" + lengthRun + " м.): " + this.name + " больше " + this.maxLengthRun + " м. не бегает.");
        }
    }

    /**
     * задача животного на плавание
     * @param lengthSwim - длина плавания
     */
    public void swim(Integer lengthSwim){
        if (lengthSwim <= this.maxLengthSwim){
            System.out.println(this.name + " проплыл " + lengthSwim + "м.");
        }else {
            System.out.println("Животное (" + lengthSwim + " м.): " + this.name + " больше " + this.maxLengthSwim + " м. не плавает.");
        }
    }
}