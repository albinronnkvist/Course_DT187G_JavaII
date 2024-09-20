package com.albinronnkvist.gui.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomTextFieldFrame extends CustomFrame implements ActionListener {
    private JTextField textField;
    private JButton button;

    public CustomTextFieldFrame() {
        textField = new JTextField(15);
        button = new JButton("Submit");

        button.addActionListener(this);

        var panel = new JPanel();
        panel.add(textField);
        panel.add(button);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button)
        {
            button.setEnabled(false);
            textField.setEditable(false);

            var enteredText = textField.getText();
            JOptionPane.showMessageDialog(CustomTextFieldFrame.this, "You entered: " + enteredText);

            button.setEnabled(true);
            textField.setEditable(true);
        }
    }
}