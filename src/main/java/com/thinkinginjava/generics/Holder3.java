package com.thinkinginjava.generics;
/**
 * изучение "Обобщенных типов" для понимания
 * их применения в Swing
 * при возврате значений
 */

class Automobile{}
public class Holder3<T> {
    private T a;

    /**
     * constructor
     * @param a - object
     */
    public Holder3(T a){ this.a = a; }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
        Automobile a = h3.get();
    }
}
/* output console:
Process finished with exit code 0
 */
