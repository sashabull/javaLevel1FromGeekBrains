package com.geekbrains.lesson6;

/**
 *  проверка выполнения задания 6
 */
public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик");    // собачка 1
        dog1.run(1);
        dog1.swim(1);
        Dog dog2 = new Dog("Шарик");    // собачка 2
        dog2.run(501);
        dog2.swim(11);
        Dog dog3 = new Dog("Тузик");    // собачка 3
        dog3.run(20);
        dog3.swim(3);
        Cat cat1 = new Cat("Васька");   // котик 1
        cat1.run(1);
        cat1.swim(5);
        Cat cat2 = new Cat("Котик");    // котик 2
        cat2.run(201);
        cat2.swim(3);
        System.out.println("Animals = " + Animal.countAnimals);     // сколько животных всего было создано
        System.out.println("Dogs = "+ Dog.countDogs);               // сколько было создано собак
        System.out.println("Cats = " + Cat.countCats);              // сколько было создано кошек
    }
}
