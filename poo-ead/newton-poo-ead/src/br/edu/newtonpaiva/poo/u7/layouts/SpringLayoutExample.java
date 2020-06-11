package br.edu.newtonpaiva.poo.u7.layouts;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class SpringLayoutExample extends JFrame implements ActionListener {

    public static Container c;

    public SpringLayoutExample(String s) {
        super(s);

        c = getContentPane();

        // Define the panel to hold the components
        SpringLayout layout = new SpringLayout();

        JLabel label = new JLabel("Label: ");
        JTextField text = new JTextField("Text field", 15);
        c.setSize(300, 300);
        c.setLayout(layout);
        c.add(label);
        c.add(text);

        // Put constraint on components
        layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, c);
        layout.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, c);
        layout.putConstraint(SpringLayout.WEST, text, 5, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, text, 5, SpringLayout.NORTH, c);

        // Set the window to be visible as the default to be false
        this.pack();

    }

    public static void main(String[] args) {
        // Create and set up a frame window
        JFrame.setDefaultLookAndFeelDecorated(true);
        SpringLayoutExample frame = new SpringLayoutExample("Layout");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
