package br.edu.newtonpaiva.poo.u7.joptionpane;

import javax.swing.JOptionPane;

public class ConfirmDialogExample {

    public static void main(String[] args) {
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "choose one", "choose one",
                JOptionPane.YES_NO_OPTION);
        System.out.println(showConfirmDialog);
    }
}
