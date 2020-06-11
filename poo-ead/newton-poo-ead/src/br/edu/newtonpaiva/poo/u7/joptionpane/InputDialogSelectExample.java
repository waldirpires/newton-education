package br.edu.newtonpaiva.poo.u7.joptionpane;

import javax.swing.JOptionPane;

public class InputDialogSelectExample {

    public static void main(String[] args) {
        Object[] possibleValues = { "First", "Second", "Third" };
        Object selectedValue = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE,
                null, possibleValues, possibleValues[0]);

        System.out.println(selectedValue);
    }
}
