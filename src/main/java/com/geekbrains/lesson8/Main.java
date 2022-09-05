package com.geekbrains.lesson8;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // создание фрейма в потоке диспетчеризации событий,
        // иначе могут быть проблемы при запуске нескольких фреймов.
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new SwingDemo();
            }
        });
    }
}
