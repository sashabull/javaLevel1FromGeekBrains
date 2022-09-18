package com.thinkinginjava.tread;

import com.thinkinginjava.runnable.RunnableTest;

// Простейшее использование класса Thread.
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread( new RunnableTest());
        t.start();
        System.out.println("main() waiting for stop runnableTest!");
    }
}
/* output
main() waiting for stop runnableTest!
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

Process finished with exit code 0
 */
