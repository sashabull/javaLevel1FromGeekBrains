package com.thinkinginjava.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.thinkinginjava.swing.SwingConsole.run;

/**
 * перехват событий от кнопки
 * и реакция в виде вывода "Слушателем" названия кнопки в текстовое поле
 */
public class Button2 extends JFrame {
    // поля формы
    private JButton
        b1 = new JButton("Button 1"),
        b2 = new JButton("Кнопка 2");
    private JTextField txt = new JTextField(10);

    // методы формы

    /**
     * реализация интерфейса ActionListener классом ButtonListener
     * реализация "Слушателя кнопки"
     * с методом рефлексии на действия кнопки
     */
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String name = ((JButton)e.getSource()).getText();
            // выше ((JButton)e.getSource()) - нотация приведения "e.getSource()" к типу "JButton"
            txt.setText(name);
        }
    }

    private ButtonListener bl = new ButtonListener(); // инициализировали "Слушатель кнопки" в адресном пространстве

    /**
     * constructor
     */
    public Button2(){
        b1.addActionListener(bl); // зарегистрировали на кнопке 1 "Слушателя кнопок" - подали кнопке 1 адрес Слушателя
        b2.addActionListener(bl); // на второй конопке тоже зарегили тот же слушатель
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(txt);
    }

    public static void main(String[] args) {
        run(new Button2(), 200, 150);
    }
}
