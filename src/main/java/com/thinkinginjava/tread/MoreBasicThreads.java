package com.thinkinginjava.tread;

import com.thinkinginjava.runnable.RunnableTest;

/**
 * несколько потоков запускаются в одном процессе
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) new Thread(new RunnableTest()).start();
        System.out.println("main() waiting for stop RunnableTest procces.");
    }
}
/* output console
поток #0, работа потока (10),
main() waiting for stop RunnableTest procces.
поток #0, работа потока (9),
поток #0, работа потока (8),
поток #1, работа потока (10),
поток #1, работа потока (9),
поток #2, работа потока (10),
поток #3, работа потока (10),
поток #4, работа потока (10),
поток #0, работа потока (7),
поток #1, работа потока (8),
поток #2, работа потока (9),
поток #3, работа потока (9),
поток #4, работа потока (9),
поток #0, работа потока (6),
поток #1, работа потока (7),
поток #2, работа потока (8),
поток #3, работа потока (8),
поток #4, работа потока (8),
поток #0, работа потока (5),
поток #1, работа потока (6),
поток #2, работа потока (7),
поток #3, работа потока (7),
поток #0, работа потока (4),
поток #4, работа потока (7),
поток #1, работа потока (5),
поток #2, работа потока (6),
поток #3, работа потока (6),
поток #4, работа потока (6),
поток #0, работа потока (3),
поток #1, работа потока (4),
поток #2, работа потока (5),
поток #3, работа потока (5),
поток #4, работа потока (5),
поток #0, работа потока (2),
поток #1, работа потока (3),
поток #2, работа потока (4),
поток #3, работа потока (4),
поток #4, работа потока (4),
поток #0, работа потока (1),
поток #1, работа потока (2),
поток #2, работа потока (3),
поток #3, работа потока (3),
поток #4, работа потока (3),
поток #0, работа потока (RunnableTest (стоп поток)!),
поток #2, работа потока (2),
поток #1, работа потока (1),
поток #3, работа потока (2),
поток #4, работа потока (2),
поток #2, работа потока (1),
поток #1, работа потока (RunnableTest (стоп поток)!),
поток #3, работа потока (1),
поток #4, работа потока (1),
поток #2, работа потока (RunnableTest (стоп поток)!),
поток #3, работа потока (RunnableTest (стоп поток)!),
поток #4, работа потока (RunnableTest (стоп поток)!),

Process finished with exit code 0
 */