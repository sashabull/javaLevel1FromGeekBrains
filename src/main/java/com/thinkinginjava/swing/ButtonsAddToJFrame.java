package com.thinkinginjava.swing;

import javax.swing.*;
import java.awt.*;
/**
 * используем вспомогательный класс
 * из Философия java
 */
import com.thinkinginjava.swing.SwingConsole;

public class ButtonsAddToJFrame extends JFrame {
    private JLabel label = new JLabel("A Label");
    private JButton
        b1 = new JButton("Button 1"),
        b2 = new JButton("Button 2");
    public ButtonsAddToJFrame(){
        setLayout(new FlowLayout());
        add(label);
        add(b1);
        add(b2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new ButtonsAddToJFrame(), 300, 100);
    }
}
