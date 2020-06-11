package br.edu.newtonpaiva.poo.u7.desktop;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class JDPaneDemo extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public JDPaneDemo() {
        CustomDesktopPane desktopPane = new CustomDesktopPane();
        Container contentPane = getContentPane();
        contentPane.add(desktopPane, BorderLayout.CENTER);
        desktopPane.display(desktopPane);

        setTitle("JDesktopPane Example");
        setSize(300, 350);
        setVisible(true);
    }

    public static void main(String args[]) {
        new JDPaneDemo();
    }
}
