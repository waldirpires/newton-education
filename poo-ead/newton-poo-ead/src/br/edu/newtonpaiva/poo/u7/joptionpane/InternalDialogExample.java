package br.edu.newtonpaiva.poo.u7.joptionpane;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.edu.newtonpaiva.poo.u7.desktop.CustomDesktopPane;

public class InternalDialogExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDesktopPane j = new JDesktopPane();

        CustomDesktopPane desktopPane = new CustomDesktopPane();
        Container contentPane = frame.getContentPane();
        contentPane.add(desktopPane, BorderLayout.CENTER);
        desktopPane.display(desktopPane);

        frame.setTitle("JOptionPane Internal Dialog Example");
        frame.setSize(500, 500);
        frame.setVisible(true);

        j.setVisible(true);

        JOptionPane.showInternalMessageDialog(contentPane, "information", "information",
                JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showInternalConfirmDialog(contentPane, "please choose one", "information",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

    }
}
