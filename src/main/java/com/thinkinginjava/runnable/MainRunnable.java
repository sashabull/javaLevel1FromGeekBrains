package com.thinkinginjava.runnable;

public class MainRunnable {
    public static void main(String[] args) {
        RunnableTest launch = new RunnableTest();
        launch.run();   // определяем выполнение класса в отдельном потоке исполняемого процесса
    }
}
/* вывод в консоль
поток #0, работа потока (10),
поток #0, работа потока (9),
поток #0, работа потока (8),
поток #0, работа потока (7),
поток #0, работа потока (6),
поток #0, работа потока (5),
поток #0, работа потока (4),
поток #0, работа потока (3),
поток #0, работа потока (2),
поток #0, работа потока (1),
поток #0, работа потока (RunnableTest (стоп поток)!),

Process finished with exit code 0 */