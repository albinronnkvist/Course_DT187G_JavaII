package com.albinronnkvist.gui.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CustomCheckBoxFrame extends CustomFrame implements ActionListener, ItemListener {
    private JCheckBox checkBox;
    private JButton button;

    public CustomCheckBoxFrame() {
        checkBox = new JCheckBox("Accept Terms and Conditions");
        button = new JButton("Submit");

        checkBox.addItemListener(this);
        button.addActionListener(this);

        var panel = new JPanel();
        panel.add(checkBox);
        panel.add(button);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button)
        {
            if (checkBox.isSelected()) {
                JOptionPane.showMessageDialog(this, "Checkbox is selected!");
            } else {
                JOptionPane.showMessageDialog(this, "Checkbox is not selected.");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == checkBox) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("Checkbox selected!");
            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                System.out.println("Checkbox deselected!");
            }
        }
    }
}