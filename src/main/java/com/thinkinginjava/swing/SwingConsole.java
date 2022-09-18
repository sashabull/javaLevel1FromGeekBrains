package com.thinkinginjava.swing;

import javax.swing.*;

/**
 * Вспомогательный класс
 * Чтобы избавиться от лишнего кода,
 * мы воспользуемся изложенными выше концепциями
 * и создадим вспомогательный класс,
 * который будет использоваться в примерах
 * Swing
 *
 * Чтобы использовать его,
 * (!!!) конечное приложение должно выполняться в JFrame).
 * Статический метод run() назначает
 * заголовком окна простое имя класса JFrame.
 *
 */
public class SwingConsole {
    public static void
    run( final JFrame f, final int width, final int height){
        SwingUtilities.invokeLater(new Runnable() {
                                        public void run(){
                                            f.setTitle(f.getClass().getSimpleName());
                                            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            f.setSize(width, height);
                                            f.setVisible(true);
                                        }
                                   }
        );
    }
}