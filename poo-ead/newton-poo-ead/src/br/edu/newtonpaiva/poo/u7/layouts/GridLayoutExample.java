package br.edu.newtonpaiva.poo.u7.layouts;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutExample extends JFrame implements ActionListener {
    public static Container c;
    JButton jb1, jb2, jb3;

    public GridLayoutExample() {
        c = getContentPane();
        c.setLayout(new GridLayout(3, 2)); // lines, columns
        // Define new buttons
        JButton jb1 = new JButton("Button 1");
        jb1.addActionListener(this);
        JButton jb2 = new JButton("Button 2");
        jb2.addActionListener(this);
        JButton jb3 = new JButton("Button 3");
        jb3.addActionListener(this);
        JButton jb4 = new JButton("Button 4");
        jb4.addActionListener(this);
        JButton jb5 = new JButton("Button 5");
        jb5.addActionListener(this);

        // Define the panel to hold the buttons
        c.add(jb1);
        c.add(jb2);
        c.add(jb3);
        c.add(jb4);
        c.add(jb5);
    }

    public static void main(String[] args) {
        // Create and set up a frame window
        GridLayoutExample cl = new GridLayoutExample();
        cl.setSize(300, 300);
        cl.setVisible(true);
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Action listener
    public void actionPerformed(ActionEvent e) {
        System.out.println(((JButton) e.getSource()).getLabel());
    }

}
