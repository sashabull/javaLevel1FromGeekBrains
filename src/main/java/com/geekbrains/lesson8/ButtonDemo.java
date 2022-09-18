package com.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo implements ActionListener {
    // поля
    JLabel jlab;

    //методы
    /**
     * конструктор граф.окна
     */
    ButtonDemo(){
        JFrame jfrm = new JFrame("A Button Example"); // создание фрейма окна
        jfrm.setLayout(new FlowLayout()); // установка менеджера компоновки
        jfrm.setSize(220, 90);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // создание и настройка работы кнопок
        JButton jbtnUp = new JButton("Up");
        JButton jbtnDown = new JButton("Down");
        jbtnUp.addActionListener(this); // зарегили локального Слушателя событий конопки
        jbtnDown.addActionListener(this); // аналогично для 2-ой конопки
        jfrm.add(jbtnUp);
        jfrm.add(jbtnDown);
        // создание текстовой метки
        jlab = new JLabel("Press a button.");
        jfrm.add(jlab);
        // завершение формирование граф.окна
        jfrm.setVisible(true);
    }

    /**
     * обработка событий кнопок
     */
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("Up"))
            jlab.setText("You pressed Up");
        else
            jlab.setText("You pressed Down.");
    }

    public static void main(String[] args) {
        /**
         * создание фрейма окна в потоке (Runnable())
         * диспетчеризации событий (SwingUtilities.invokeLater)
         */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonDemo();
            }
        });
    }
}
