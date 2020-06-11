package br.edu.newtonpaiva.poo.u7.layouts;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagLayoutExample extends JFrame implements ActionListener {
    public static Container c;
    JButton jb1, jb2, jb3;

    public GridBagLayoutExample() {
        c = getContentPane();
        // Define new buttons
        GridBagLayout layout = new GridBagLayout();
        c.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        // Put constraints on different buttons
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        c.add(SwingLayoutUtils.createButton("Button1", this), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        c.add(SwingLayoutUtils.createButton("Button2", this), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        c.add(SwingLayoutUtils.createButton("Button3", this), gbc);
    }

    public static void main(String[] args) {
        // Create and set up a frame window
        GridBagLayoutExample cl = new GridBagLayoutExample();
        cl.setSize(300, 300);
        cl.setVisible(true);
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Action listener
    public void actionPerformed(ActionEvent e) {
        System.out.println(((JButton) e.getSource()).getLabel());
    }

}
