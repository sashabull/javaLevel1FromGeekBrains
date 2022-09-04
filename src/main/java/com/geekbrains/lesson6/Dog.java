package com.geekbrains.lesson6;

/**
 *  подкласс животного собака
 */
public class Dog extends Animal{
    public static Integer countDogs = 0;    // для подсчета созданных экз. собак
    {
        maxLengthRun = 500;     // ограничения собак на бег
        maxLengthSwim = 10;     // ограничение собак на плавание
    }

    public Dog(String name) {
        super(name);
        countDogs++;    // считаем созданные экз. собак
    }
}
