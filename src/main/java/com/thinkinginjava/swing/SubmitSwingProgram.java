package com.thinkinginjava.swing;

import javax.swing.*;
import java.util.concurrent.*;

public class SubmitSwingProgram extends JFrame {
    JLabel label;

    /**
     * constructor
     */
    public SubmitSwingProgram(){
        super("Hello Swing");
        label = new JLabel("A Label");
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }

    static SubmitSwingProgram ssp;

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
                                       @Override
                                       public void run() {
                                           ssp = new SubmitSwingProgram();
                                       }
        });
        TimeUnit.SECONDS.sleep(5);
        SwingUtilities.invokeLater( new Runnable() {
                                        public void run(){
                                            ssp.label.setText("Hey! This is Different!");
                                    }
        });
    }
}
