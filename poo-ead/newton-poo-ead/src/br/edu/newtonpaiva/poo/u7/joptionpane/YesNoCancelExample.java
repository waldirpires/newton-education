package br.edu.newtonpaiva.poo.u7.joptionpane;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class YesNoCancelExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);

        JOptionPane.showInternalConfirmDialog(frame, "please choose one", "information",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }
}
