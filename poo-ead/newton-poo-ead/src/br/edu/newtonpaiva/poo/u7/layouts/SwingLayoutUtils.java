package br.edu.newtonpaiva.poo.u7.layouts;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SwingLayoutUtils {

    public static JButton createButton(String label, ActionListener al) {
        JButton button = new JButton(label);
        button.addActionListener(al);

        return button;
    }

}
