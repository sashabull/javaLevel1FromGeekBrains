package com.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;

/**
 * простая Swing программа
 * по Шилдт Г. Java для начинающих. 7-ое изд. 2019.
 */
public class SwingDemo {
    /**
     * конструктор
     */
    public SwingDemo(){
        // создание контейнера Верхнего уровня
        JFrame jfrm = new JFrame("Простое приложение Swing по Шилдт Г.");
        jfrm.setSize(500, 250);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // контейнер вложенный
        JLabel jlabel1 = new JLabel("Программирование интерфейса с помощью Swing.");
        jfrm.add(jlabel1, BorderLayout.NORTH);

        jfrm.setVisible(true);
    }
}
