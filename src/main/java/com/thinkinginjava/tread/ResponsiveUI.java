package com.thinkinginjava.tread;
// Чуткость пользовательского интерфейса.
// {RunByHand}

public class ResponsiveUI extends Thread {
    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception {
        new ResponsiveUI();     // запустили поток для расчета
        System.in.read();       // ждем нажатия клавиш
        System.out.println(d);  // Вывод информации о ходе выполнения потока
    }
}
/* JDK 18. output:
<Enter>
111934.16352163145 <числа разные>

Process finished with exit code 0
 */