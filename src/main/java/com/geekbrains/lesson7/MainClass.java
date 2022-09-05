package com.geekbrains.lesson7;

public class MainClass {
    public static void main(String[] args) {
        Cat[] cats = new Cat[9];    // создаем массив из 9 котов
        cats[0] = new Cat("Barsik", 5);
        cats[1] = new Cat("Барсик",10);
        cats[2] = new Cat("Мурзик", 15);
        cats[3] = new Cat("Пушок", 20);
        cats[4] = new Cat("Ешка", 25);
        cats[5] = new Cat("Том", 20);
        cats[6] = new Cat("Кузя", 15);
        cats[7] = new Cat("Персик", 10);
        cats[8] = new Cat("Граф", 5);
        Plate plate = new Plate(100);   // создаем одну тарелку с едой
        for (Cat c: cats) { // просим всех котов ...
            c.eat(plate);   // ... поесть из тарелки
            System.out.println("Кот:"+ c.getName() + " сыт: " + c.isSatiety());  // узнаем кот сыт или нет?
            if (!c.isSatiety()){    // если в тарелке не хватает коту еды
                plate.addFood(10);  // добавляем в тарелку 10 еды
                System.out.print("Добавили в тарелку еды. Информ.по "); plate.info(); // используем хотя бы здесь и так заявленный преподом метод инфо()
            }
        }
    }
}
