package br.edu.newtonpaiva.poo.u7.joptionpane;

import javax.swing.JOptionPane;

public class InputDialogExample {

    public static void main(String[] args) {
        String inputValue = JOptionPane.showInputDialog("Please input a value");
        System.out.println(inputValue);
    }
}
