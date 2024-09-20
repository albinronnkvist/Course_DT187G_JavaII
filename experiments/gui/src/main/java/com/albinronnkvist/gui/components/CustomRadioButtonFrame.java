package com.albinronnkvist.gui.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomRadioButtonFrame extends CustomFrame implements ActionListener {
    private JRadioButton option1;
    private JRadioButton option2;
    private JRadioButton option3;
    private JButton button;

    public CustomRadioButtonFrame() {
        option1 = new JRadioButton("Option 1");
        option2 = new JRadioButton("Option 2");
        option3 = new JRadioButton("Option 3");

        var group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);

        button = new JButton("Submit");
        button.addActionListener(this);

        var panel = new JPanel();
        panel.add(option1);
        panel.add(option2);
        panel.add(option3);
        panel.add(button);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if (option1.isSelected()) {
                JOptionPane.showMessageDialog(this, "Option 1 is selected.");
            } else if (option2.isSelected()) {
                JOptionPane.showMessageDialog(this, "Option 2 is selected.");
            } else if (option3.isSelected()) {
                JOptionPane.showMessageDialog(this, "Option 3 is selected.");
            } else {
                JOptionPane.showMessageDialog(this, "No option is selected.");
            }
        }
    }
}
