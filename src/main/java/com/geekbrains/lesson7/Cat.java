package com.geekbrains.lesson7;

/**
 * класс Кот
 */
public class Cat {
    private String name;                        // Кличка кота
    private int appetite;                       // аппетит кота - мин. кол-во еды чтобы 1 раз поесть
    private boolean satiety;                    // сытость кота

    /**
     * конструктор Кота
     * @param name - кличка кота
     * @param appetite - аппетит кота, мин.кол-во еды, чтобы он стал сытым
     *                 - когда создаем кота, он голодный
     *
     */
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;                        // кот создается голодным
    }

    /**
     * приказ коту поесть из указанной тарелки
     * @param p - тарелки из которой коту приказано поесть
     *          - кот не может есть из тарелки, если там не хватает еды для полного удовлетворения аппетита
     *          - если коту удалось поесть из тарелки, то его сытость становится true
     */
    public void eat(Plate p) {                  // приказ коту поесть из указанной тарелки
        if (p.getFood() >= appetite){           // в тарелке достаточно еды для кота
            p.decreaseFood(appetite);           // кот съел свое "аппетитное" кол-во еды в тарелке
            satiety = true;                     // кот стал сыт
        }
    }

    /**
     *  получение сытости кота
     */
    public boolean isSatiety() {
        return satiety;
    }

    /**
     * получение имени кота
     */
    public String getName() {
        return name;
    }
}
