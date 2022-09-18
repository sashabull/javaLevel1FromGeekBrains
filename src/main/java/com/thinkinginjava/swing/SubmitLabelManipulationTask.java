package com.thinkinginjava.swing;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * не совсем правильно написанная программа, потому что:
 * 1. есть работа с компонентой не через очередь;
 * 2. работа через очередь замешана в код программы.
 */
public class SubmitLabelManipulationTask {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Hello Swing");
        final JLabel label = new JLabel("A Label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(3);
        label.setText("Меняем метку!");      // работа с полем напрямую
        TimeUnit.SECONDS.sleep(3);
        SwingUtilities.invokeLater( new Runnable(){
                                        public void run(){
                                            label.setText("Hey! This is Different!");   // работа с полем ставится в очередь
                                        }
                                    }
        );
    }
}
