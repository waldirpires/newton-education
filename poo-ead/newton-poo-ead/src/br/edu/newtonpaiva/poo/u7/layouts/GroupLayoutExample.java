package br.edu.newtonpaiva.poo.u7.layouts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;

/*
 * A Java swing GroupLayout example
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GroupLayoutExample implements ActionListener {

    public static void main(String[] args) {

        GroupLayoutExample ex = new GroupLayoutExample();

        // Create and set up a frame window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define new buttons with different width on help of the ---
        JButton jb1 = SwingLayoutUtils.createButton("1", ex);
        JButton jb2 = SwingLayoutUtils.createButton("2", ex);
        JButton jb3 = SwingLayoutUtils.createButton("3", ex);
        JButton jb4 = SwingLayoutUtils.createButton("4", ex);

        // Define the panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setSize(300, 300);
        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        // Set for horizontal and vertical group
        layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(jb1).addComponent(jb2)
                .addGroup(layout.createSequentialGroup().addGroup(layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jb3).addComponent(jb4))));
        layout.setVerticalGroup(
                layout.createSequentialGroup().addComponent(jb1).addComponent(jb2).addComponent(jb3).addComponent(jb4));
        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(((JButton) e.getSource()).getLabel());
    }

}