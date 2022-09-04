package com.geekbrains.lesson6;

/**
 *  подкласс животных - коты
 */
public class Cat extends Animal{
    public static Integer countCats = 0; // для подсчета созданных экз. котов
    {
        maxLengthRun = 200;     // ограничения котов на бег
        maxLengthSwim = 0;      // ограничения котов на плавание
    }

    public Cat(String name) {
        super(name);
        countCats++;    // посчитали очередной экз. созданного кота
    }

    /**
     * поскольку коты не умеют плавать, для них переопределен метод (не перегружен)
     * @param lengthSwim - длина плавания
     */
    @Override
    public void swim(Integer lengthSwim) {
        System.out.println("Кот плавание (" + lengthSwim + "): кот не умеет плавать");
    }
}
